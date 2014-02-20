package tulip.GUI.OperationalUnits.implementation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import tulip.GUI.OperationalUnits.interfaces.InputOutputUnit;
import java.awt.Point;
import tulip.GUI.Constants;
import static tulip.GUI.Constants.SIZE_UNIT;
import tulip.GUI.OperationalUnits.interfaces.AbstractUnit;
import tulip.GUI.OperationalUnits.interfaces.IMultipuleOutputUnit;
import tulip.GUI.OperationalUnits.interfaces.ITwoInputUnit;

/**
 *
 * @author Wittman
 */
public class PropagatorUnit extends AbstractUnit 
                            implements ITwoInputUnit, IMultipuleOutputUnit{

    private int connections;
    
    public PropagatorUnit() {
        this.connections = 0;
        setSize(new Dimension(Constants.DIAMETER*SIZE_UNIT/2+1, Constants.DIAMETER*SIZE_UNIT/2+1));
    }

    
    
    @Override
    public void showCustomizedDialog() {
        
    }

    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(0, 0, SIZE_UNIT*Constants.DIAMETER/2, SIZE_UNIT*Constants.DIAMETER/2);
        g.setColor(Color.WHITE);
        g.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        g.drawString(String.valueOf(connections), SIZE_UNIT*Constants.DIAMETER/6, SIZE_UNIT*Constants.DIAMETER/3);

    }


    @Override
    public Point getLeftConnection() {
        Point connectionPoint = new Point(getWidth()/4, 0);
        connectionPoint.x += this.getX();
        connectionPoint.y += this.getY();
        return connectionPoint;
    }

    @Override
    public Point getRightConnection() {
        Point connectionPoint = new Point(getWidth()/4*3, 0);
        connectionPoint.x += this.getX();
        connectionPoint.y += this.getY();
        return connectionPoint;
    }

    @Override
    public Point getDownConnection() {
        Point connectionPoint = new Point(getWidth()/2, getHeight());
        connectionPoint.x += this.getX();
        connectionPoint.y += this.getY();
        return connectionPoint;
    }

    @Override
    public AbstractUnit getLeftUnit() {
        return null;
    }

    @Override
    public void setLeftUnit(AbstractUnit leftUnit) {
    }

    @Override
    public AbstractUnit getRightUnit() {
        return null;
    }

    @Override
    public void setRightUnit(AbstractUnit rightUnit) {
    }

    @Override
    public void setNextUnit(AbstractUnit nextUnit, Operand pos, int number) {
    }

    @Override
    public AbstractUnit getNextUnit(int number) {
        return null;
    }

    @Override
    public void setNextUnit(AbstractUnit nextUnit, Operand pos) {
    }

    @Override
    public AbstractUnit getNextUnit() {
        return null;
    }

    
    
    

}
