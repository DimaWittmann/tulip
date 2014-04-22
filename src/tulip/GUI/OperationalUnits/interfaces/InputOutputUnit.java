package tulip.GUI.OperationalUnits.interfaces;

import tulip.translator.IInstructionUnit;
import java.awt.Point;
import tulip.translator.Instruction;

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
    public Point getLeftConnectionPoint() {
        Point connectionPoint = new Point(getWidth()/4, 0);
        connectionPoint.x += this.getX();
        connectionPoint.y += this.getY();
        return connectionPoint;
    }

    @Override
    public Point getRightConnectionPoint() {
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
    public Instruction getInstruction(int number) {
        Instruction instr = new Instruction(number, getMnemonic(), getOperand(0), getOperand(1),  
                position.ordinal(), getNextUnit().unitNumber);
        return instr;
            
    }

    @Override
    public String validateIntruction() {
        if(getOperand(0) == null || getOperand(1) == null){
            return "Has no operand";
        }
        if(this.position == null){
            return "Choose position";
        }
        if(getNextUnit() == null){
            return "Choose next unit";
        }
        return null;
    }

    @Override
    public int getNumberInputs() {
        return 2;
    }

    @Override
    public void setPredUnit(AbstractUnit unit, int pos) {
        if (pos == 0){
            setLeftUnit(unit);
        }
        if(pos == 1){
            setRightUnit(unit);
        }
    }

    @Override
    public AbstractUnit getPredUnit(int pos) {
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