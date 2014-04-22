package tulip.GUI.OperationalUnits.implementation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JOptionPane;
import tulip.GUI.Constants;
import static tulip.GUI.Constants.SIZE_UNIT;
import tulip.GUI.OperationalUnits.interfaces.AbstractUnit;
import tulip.GUI.OperationalUnits.interfaces.IMultipuleOutputUnit;
import tulip.GUI.OperationalUnits.interfaces.InputOutputUnit;

/**
 *
 * @author Wittman
 */
public class PropagatorUnit extends InputOutputUnit 
                            implements IMultipuleOutputUnit{

    private int connNumber;
    private AbstractUnit[] nextUnits;
    
    public static int lastConnectedUnit;
    
    public PropagatorUnit() {
        nextUnits = new AbstractUnit[0];
        this.connNumber = 0;
        lastConnectedUnit = 0;
        setSize(new Dimension(Constants.DIAMETER*SIZE_UNIT/2+1, Constants.DIAMETER*SIZE_UNIT/2+1));
    }

    
    
    @Override
    public void showCustomizedDialog() {
        Object result = JOptionPane.showInputDialog(
            tulip.Tulip.mainFrame, 
            "Input number of connections", 
            connNumber
        );
        if( result != null){
            try{
                connNumber = Integer.parseInt((String) result);
                nextUnits = new AbstractUnit[connNumber];
                tulip.Tulip.mainFrame.getGrapPanel().repaint();
            }catch(NumberFormatException e){
            }
        }
    }

    
    
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillOval(0, 0, SIZE_UNIT*Constants.DIAMETER/2, SIZE_UNIT*Constants.DIAMETER/2);
        g.setColor(Color.WHITE);
        g.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        g.drawString(String.valueOf(connNumber), SIZE_UNIT*Constants.DIAMETER/6, SIZE_UNIT*Constants.DIAMETER/3);
        super.paintComponent(g);

    }


    @Override
    public Point getLeftConnectionPoint() {
        Point connectionPoint = new Point(getWidth()/2, 0);
        connectionPoint.x += this.getX();
        connectionPoint.y += this.getY();
        return connectionPoint;
    }

    @Override
    public Point getRightConnectionPoint() {
        Point connectionPoint = new Point(getWidth(), getHeight()/2);
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
    public void setNextUnit(AbstractUnit nextUnit, Operand pos, int number) {
        if(number > connNumber){
            return;
        }
        nextUnits[number] = nextUnit;
        this.position = pos;
        
    }

    @Override
    public AbstractUnit getNextUnit(int number) {
        if(number > connNumber){
            return null;
        }
        return nextUnits[number];
        
    }

    @Override
    public void setNextUnit(AbstractUnit nextUnit, Operand pos) {
        throw new UnsupportedOperationException();
    }

    @Override
    public AbstractUnit getNextUnit() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getNumberOfNext() {
        return connNumber;
    }

    @Override
    public String getMnemonic() {
        if( connNumber == 2){
            return "X2";
        }if (connNumber>2){
            return "Xn";
        }else{
            return null;
        }
    }

    @Deprecated
    @Override
    public Point getDownConnection(int pos) {
        if(pos == 0){
            return getDownConnection();
        }
        return null;
    }

    @Override
    public Operand getNextUnitOperand(int number) {
        return position;
    }
}
