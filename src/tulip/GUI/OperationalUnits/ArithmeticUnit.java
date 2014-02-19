package tulip.GUI.OperationalUnits;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JOptionPane;
import static tulip.GUI.Constants.SIZE_UNIT;

/**
 * @author Wittman
 */
public class ArithmeticUnit extends AbstractUnit
                            implements ITwoInputUnit, IOutputUnit{

    
    protected Type type;
    
    private static Type lastChoosed;
    public ArithmeticUnit() {
        lastChoosed = Type.ADD;
        type = null;
        setSize(new Dimension(10*SIZE_UNIT+1, 5*SIZE_UNIT+1));
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
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, SIZE_UNIT*10, SIZE_UNIT*5);
        g.setColor(color);
        g.drawRect(0, 0, SIZE_UNIT*10, SIZE_UNIT*5);
        if( type != null){
            g.setFont(new Font(Font.SERIF, Font.BOLD, 24));
            g.drawString(type.toString(), SIZE_UNIT*3, SIZE_UNIT*3);
        }
        //TODO розібратися з точками підключення
//        g.fillOval(getLeftConnection().x-1, getLeftConnection().y-1, 2, 2);
//        g.fillOval(getRightConnection().x-1, getRightConnection().y-1, 2, 2);
//        g.fillOval(getDownConnection().x-1, getDownConnection().y-1, 2, 2);
        this.setBackground(new Color(255, 225, 225, 0));
        super.paintComponent(g);

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
    public AbstractUnit getNextUnit() {
        
        return nextUnit;
    }

    @Override
    public void setNextUnit(AbstractUnit nextUnit, Operand pos) {

        this.position = pos;
        this.nextUnit = nextUnit;
    }
    
    
    
    public enum Type{
        ADD, SUB, MUL, DIV, SQR, SQRT
    }

}
