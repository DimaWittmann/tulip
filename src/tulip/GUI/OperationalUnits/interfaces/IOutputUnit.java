package tulip.GUI.OperationalUnits.interfaces;

import java.awt.Point;

/**
 * Interface with one output pin
 * @author Wittman
 */
public interface IOutputUnit{
    
    
    public  Point getDownConnection();
    
    public void setNextUnit(AbstractUnit nextUnit, AbstractUnit.Operand pos);
    
    
    public AbstractUnit getNextUnit();
    
}
