package tulip.GUI.OperationalUnits.interfaces;

import tulip.translator.IInstructionUnit;
import java.awt.Point;

/**
 * Абстрактний клас, що представляє елемент зі двома входами і виходом
 * @author Wittman
 */
public abstract class InputOutputUnit extends AbstractUnit
                            implements ITwoInputUnit, IOutputUnit, IInstructionUnit{

    
    private String [] op;
    
    public InputOutputUnit() {
        op = new String[2];
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
    public String getInstruction() {
        String inst = 
            UnitNumber + ": " +
            getMnemonic() +" " +
            getOperand(0) + ", " +
            getOperand(1) + ", !" +
            position.ordinal() +" to "+
            getNextUnit().UnitNumber;
        
        return inst;
            
    }
    
        

}