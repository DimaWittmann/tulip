package tulip.GUI.OperationalUnits.implementation;

import tulip.GUI.OperationalUnits.interfaces.ITwoInputUnit;
import tulip.GUI.OperationalUnits.interfaces.AbstractUnit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import tulip.GUI.Constants;
import static tulip.GUI.Constants.SIZE_UNIT;
import tulip.translator.IInstructionUnit;

/**
 *
 * @author Wittman
 */
public class OutUnit extends AbstractUnit 
                     implements ITwoInputUnit, IInstructionUnit{

    private String []op;
    
    public OutUnit() {
        op = new String[2];
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
        super.paintComponent(g);
        
        g.setColor(Color.WHITE);
        g.fillOval(0, 0, SIZE_UNIT*Constants.DIAMETER*2, SIZE_UNIT*Constants.DIAMETER);
        g.setColor(color);
        g.drawOval(0, 0, SIZE_UNIT*Constants.DIAMETER*2, SIZE_UNIT*Constants.DIAMETER);
        
        g.setFont(new Font(Font.SERIF, Font.BOLD, 24));
        g.drawString("OUT", SIZE_UNIT*Constants.DIAMETER/2, SIZE_UNIT*Constants.DIAMETER/3*2);
        
        this.setBackground(new Color(255, 225, 225, 0));
    }

    @Override
    @Deprecated
    public void showCustomizedDialog() {
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
        Point connectionPoint = new Point( getWidth(), getHeight()/2);
        connectionPoint.x += this.getX();
        connectionPoint.y += this.getY();
        return connectionPoint;
    }
    
    
        
    @Override
    public void setOperand(String value, int operand) {
        try {
            op[operand] = value;
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public String getOperand(int operand) {
        try {
            return op[operand];
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    @Override
    public String getInstruction(int number) {
        String inst = 
            number + ": " +
            getMnemonic() +" " +
            getOperand(0) + ", " +
            getOperand(1) + ", !" +
            "0" + " to "+
            number;
        
        return inst;
            
    }

    @Override
    public String getMnemonic() {
        return "OUT";
    }

    @Override
    public String validateIntruction() {
        if(getOperand(0) == null || getOperand(1) == null){
            return "Has no operand";
        }
        return null;
    }
    
    @Override
    public int getNumberInputs() {
        return 2;
    }

    @Override
    public void setNextUnit(AbstractUnit unit, int pos) {
        if (pos == 0){
            setLeftUnit(unit);
        }
        if(pos == 1){
            setRightUnit(unit);
        }
    }

    @Override
    public AbstractUnit getNextUnit(int pos) {
        if (pos == 0){
            return getRightUnit();
        }
        if(pos == 1){
            return getRightUnit();
        }
        return null;
    }

    @Override
    public Point getConnectionPoint(int pos) {
        if (pos == 0){
            return getLeftConnectionPoint();
        }
        if(pos == 1){
            return getRightConnectionPoint();
        }
        return null;
    }
    
    

}
