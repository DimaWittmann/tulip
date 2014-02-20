package tulip.GUI.OperationalUnits.interfaces;

import java.awt.Point;

/**
 * Інтерфейс підключення вхідних даних до вузла
 * @author Wittman
 */
public interface IOutputUnit {
    
    
    public  Point getDownConnection();
    
    public void setNextUnit(AbstractUnit nextUnit, AbstractUnit.Operand pos);
    
    
    public AbstractUnit getNextUnit();

}
