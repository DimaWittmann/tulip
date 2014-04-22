package tulip.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;
import tulip.GUI.OperationalUnits.implementation.DataUnit;
import tulip.GUI.OperationalUnits.interfaces.AbstractUnit;
import tulip.GUI.OperationalUnits.interfaces.IInputUnit;
import tulip.GUI.OperationalUnits.interfaces.IMultipuleOutputUnit;
import tulip.GUI.OperationalUnits.interfaces.IOutputUnit;
import tulip.GUI.OperationalUnits.interfaces.ITwoInputUnit;
import tulip.GUI.OperationalUnits.listeners.UnitListener;

/**
 *
 * @author Wittman
 */
public class GraphPanel extends JPanel {

    private ArrayList<AbstractUnit> units;

    private int nextNumber;

    public void addUnit(AbstractUnit unit) {
        UnitListener listener = new UnitListener();
        unit.addMouseListener(listener);
        unit.addMouseMotionListener(listener);
        unit.addKeyListener(listener);
        unit.setNumber(nextNumber);
        units.add(unit);
        this.add(unit);
        if (!(unit instanceof DataUnit)) {
            nextNumber++;
        }
        repaint();
    }

    public void removeUnit(AbstractUnit unit) {
        unit.setNumber(nextNumber);
        units.remove(unit);
        this.remove(unit);
        if (!(unit instanceof DataUnit)) {
            nextNumber--;
        }
        repaint();
    }

    public ArrayList<AbstractUnit> getUnits() {
        return units;
    }

    public GraphPanel() {
        this(new ArrayList<AbstractUnit>());
    }

    public void addUnits(ArrayList<AbstractUnit> units) {
        this.units.clear();
        this.removeAll();
        for (AbstractUnit unit : units) {
            addUnit(unit);
        }
    }

    public GraphPanel(ArrayList<AbstractUnit> units) {
        nextNumber = 1;
        this.setLayout(null);
        this.units = new ArrayList<>();
        addUnits(units);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (AbstractUnit unit : units) {

            if (!(unit instanceof DataUnit)) {   //blue index under unit
                g.setColor(Color.blue);
                g.setFont(new Font(Font.SERIF, Font.BOLD, 14));
                g.drawString(new Integer(unit.unitNumber).toString(), unit.getX(), unit.getY());
                g.setColor(Color.BLACK);
            }
            if (!(unit instanceof IOutputUnit)) {
                continue;
            } else if (unit instanceof IMultipuleOutputUnit) {

                
                for (int i = 0; i < ((IMultipuleOutputUnit) unit).getNumberOfNext(); i++) {
                    Point to = null;
                    Point from = ((IMultipuleOutputUnit) unit).getDownConnection();
                    if (((IMultipuleOutputUnit) unit).getNextUnit(i) == null) {
                        continue;
                    }
                    if (unit.position == AbstractUnit.Operand.FIRST) {

                        AbstractUnit next = ((IMultipuleOutputUnit) unit).getNextUnit(i);
                        to = ((ITwoInputUnit) next).getLeftConnectionPoint();

                    } else if (unit.position == AbstractUnit.Operand.SECOND) {

                        AbstractUnit next = ((IMultipuleOutputUnit) unit).getNextUnit(i);
                        to = ((ITwoInputUnit) next).getRightConnectionPoint();

                    }

                    if(to != null){
                        g.drawLine(from.x, from.y, to.x, to.y);
                        fillArrow(from, to, g, 10, 5);
                    }
                }

            } else {
                AbstractUnit next = ((IOutputUnit) unit).getNextUnit();
                if (next != null && next instanceof IInputUnit) {
                    Point from = ((IOutputUnit) unit).getDownConnection();
                    Point to = null;
                    if(next instanceof ITwoInputUnit){
                        if (unit.position == AbstractUnit.Operand.FIRST) {
                            to = ((ITwoInputUnit) next).getLeftConnectionPoint();
                        }
                        if (unit.position == AbstractUnit.Operand.SECOND) {
                            to = ((ITwoInputUnit) next).getRightConnectionPoint();
                        }
                    }else{
                        to = ((IInputUnit) next).getConnectionPoint(0);
                    }
                    g.drawLine(from.x, from.y, to.x, to.y);
                    fillArrow(from, to, g, 10, 5);
                }
            }
        }
    }

    /**
     * Намалювати рінобедрений трикутник і залити його
     *
     * @param from початок лінії
     * @param to вершина трикутника
     * @param g графічний контекст
     * @param leng довжина стрілки
     * @param w ширина стрілки
     */
    public static void fillArrow(Point from, Point to, Graphics g, int leng, int w) {
        double xX = to.x - from.x;    //малюємо стрілочку
        double yY = to.y - from.y;
        double lenL = Math.sqrt(xX * xX + yY * yY);
        xX = xX / lenL * (lenL - leng);
        yY = yY / lenL * (lenL - leng);
        from.x += xX;                //початок стрілки
        from.y += yY;

        double xArrow = to.x - from.x;
        double yArrow = to.y - from.y;
        double lenArrow = Math.sqrt(xArrow * xArrow + yArrow * yArrow);
        xArrow /= lenArrow;
        yArrow /= lenArrow;

        double xW = -yArrow;
        double yW = xArrow;
        xW *= w;
        yW *= w;
        xW += from.x;
        yW += from.y;

        double xW1 = yArrow;
        double yW1 = -xArrow;
        xW1 *= w;
        yW1 *= w;
        xW1 += from.x;
        yW1 += from.y;

        int[] xarray = {(int) xW, to.x, (int) xW1};
        int[] yarray = {(int) yW, to.y, (int) yW1};
        g.fillPolygon(xarray, yarray, 3);
    }
}
