package tulip.GUI.OperationalUnits.interfaces;

import java.awt.Point;

/**
 *
 * @author Wittman
 */
public interface IMultipuleOutputUnit extends IOutputUnit{
    
    public void setNextUnit(AbstractUnit nextUnit, AbstractUnit.Operand pos, int number);
    
    
    public AbstractUnit getNextUnit(int number);
    
    public AbstractUnit.Operand getNextUnitOperand(int number);

    public int getNumberOfNext();
    
    public Point getDownConnection(int pos);

}
