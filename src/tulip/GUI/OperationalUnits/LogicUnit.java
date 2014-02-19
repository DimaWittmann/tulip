package tulip.GUI.OperationalUnits;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import javax.swing.JOptionPane;
import tulip.GUI.Constants;
import static tulip.GUI.Constants.SIZE_UNIT;

/**
 *
 * @author Wittman
 */
public class LogicUnit extends AbstractUnit 
                       implements ITwoInputUnit, IOutputUnit{

    
    protected Type type;
    
    private static Type lastChoosed;
    
    public LogicUnit() {
        setSize(new Dimension(10*SIZE_UNIT+1, 10*SIZE_UNIT+1));
    }
    
    @Override
    public AbstractUnit getLeftUnit() {
        return leftUnit;
    }

    @Override
    public void setLeftUnit(AbstractUnit leftUnit) {
        this.leftUnit = leftUnit;
    }

    @Override
    public AbstractUnit getRightUnit() {
        return rightUnit;
    }

    @Override
    public void setRightUnit(AbstractUnit rightUnit) {
        this.rightUnit = rightUnit;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       
        
        Polygon rombus = new Polygon();
        rombus.addPoint(SIZE_UNIT*Constants.DIAMETER, 0);
        rombus.addPoint(SIZE_UNIT*Constants.DIAMETER*2, SIZE_UNIT*Constants.DIAMETER);
        rombus.addPoint(SIZE_UNIT*Constants.DIAMETER, SIZE_UNIT*2*Constants.DIAMETER);
        rombus.addPoint(0, SIZE_UNIT*Constants.DIAMETER);
        
        g.setColor(Color.WHITE);
        g.fillPolygon(rombus);
        g.setColor(color);
        g.drawPolygon(rombus);
        if( type != null){
            g.setFont(new Font(Font.SERIF, Font.BOLD, 20));
            g.drawString(type.toString(), SIZE_UNIT*2, SIZE_UNIT*6);
        }
        
        
    }

    @Override
    public void showCustomizedDialog() {
        Object result = JOptionPane.showInputDialog(
                tulip.Tulip.mainFrame, 
                "Choose arithmetic operation", 
                "Operation", 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                Type.values(), 
                lastChoosed);
        if( result != null){
            type = (Type) result;
            lastChoosed = type;
            tulip.Tulip.mainFrame.getGrapPanel().repaint();
        }
    }

    @Override
    public Point getLeftConnection() {
        Point connectionPoint = new Point(getWidth()/4, getHeight()/4);
        connectionPoint.x += this.getX();
        connectionPoint.y += this.getY();
        return connectionPoint;
    }

    @Override
    public Point getRightConnection() {
        Point connectionPoint = new Point(getWidth()/4*3, getHeight()/4);
        connectionPoint.x += this.getX();
        connectionPoint.y += this.getY();
        return connectionPoint;
    }   
    
    
    @Override
    public AbstractUnit getNextUnit() {
        
        return nextUnit;
    }

    @Override
    public void setNextUnit(AbstractUnit nextUnit, Operand pos) {

        this.position = pos;
        this.nextUnit = nextUnit;
    }
    
    
    
    @Override
    public  Point getDownConnection(){
        Point connectionPoint = new Point(getWidth()/2, getHeight());
        connectionPoint.x += this.getX();
        connectionPoint.y += this.getY();
        return connectionPoint;
    }
    

    public enum Type{
        CMPE, CMPM, CMPME, CMPLE
    }

}
