package tulip.GUI.OperationalUnits.interfaces;

import java.awt.Point;

/**
 * Інтерфейс підключення двох джерела даних
 * @author Wittman
 */
public interface ITwoInputUnit extends IInputUnit{
    
    public AbstractUnit getLeftUnit();

    public void setLeftUnit(AbstractUnit leftUnit);

    public AbstractUnit getRightUnit();
    
    public void setRightUnit(AbstractUnit rightUnit);
    
    public Point getLeftConnectionPoint();
    
    public Point getRightConnectionPoint();
}
