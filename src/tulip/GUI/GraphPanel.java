package tulip.GUI;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;
import tulip.GUI.OperationalUnits.interfaces.AbstractUnit;
import tulip.GUI.OperationalUnits.interfaces.IOutputUnit;
import tulip.GUI.OperationalUnits.interfaces.ITwoInputUnit;

/**
 *
 * @author Wittman
 */
public class GraphPanel extends JPanel{
    
    private ArrayList<AbstractUnit> units;
    
    public void addUnit(AbstractUnit unit){
    
        units.add(unit);
        this.add(unit);
        repaint();
    }
    
    public void removeUnit(AbstractUnit unit){
    
        units.remove(unit);
        this.remove(unit);
        repaint();
    }

    public GraphPanel() {
        units = new ArrayList<>();
    }
    
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (AbstractUnit unit : units) {
            if(!(unit instanceof IOutputUnit)){
                continue;
            }
            AbstractUnit next = ((IOutputUnit)unit).getNextUnit();
            if(next != null && next instanceof ITwoInputUnit){
                Point from = ((IOutputUnit)unit).getDownConnection();
                Point to = null;
                if(unit.position == AbstractUnit.Operand.FIRST){
                    to = ((ITwoInputUnit)next).getLeftConnection();
                }
                if(unit.position == AbstractUnit.Operand.SECOND){
                    to = ((ITwoInputUnit)next).getRightConnection();
                }
                g.drawLine(from.x, from.y, to.x, to.y);
                fillArrow(from, to, g, 10, 5);
            }

            
        }
        
    }
    
     /**
     * Намалювати рінобедрений трикутник і залити його
     * @param from початок лінії
     * @param to вершина трикутника
     * @param g графічний контекст
     * @param leng довжина стрілки
     * @param w ширина стрілки
     */
    public static void fillArrow(Point from, Point to, Graphics g, int leng, int w ){
        double xX = to.x - from.x;    //малюємо стрілочку
        double yY = to.y - from.y;
        double lenL = Math.sqrt(xX*xX+yY*yY);
        xX = xX/lenL*(lenL-leng);
        yY = yY/lenL*(lenL-leng);
        from.x += xX;                //початок стрілки
        from.y += yY;
        
        
        
        
        double xArrow = to.x - from.x;
        double yArrow = to.y - from.y;
        double lenArrow = Math.sqrt(xArrow*xArrow + yArrow*yArrow);
        xArrow /= lenArrow;
        yArrow /= lenArrow;
        
        double xW = - yArrow;
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

        int [] xarray = {(int)xW, to.x, (int)xW1};
        int [] yarray = {(int)yW, to.y,(int) yW1};
        g.fillPolygon(xarray, yarray, 3);
    }
}
