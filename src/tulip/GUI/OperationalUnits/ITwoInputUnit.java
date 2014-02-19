package tulip.GUI.OperationalUnits;

import java.awt.Point;

/**
 * Інтерфейс підключення двох джерела даних
 * @author Wittman
 */
public interface ITwoInputUnit {
    
    public AbstractUnit getLeftUnit();

    public void setLeftUnit(AbstractUnit leftUnit);

    public AbstractUnit getRightUnit();
    
    public void setRightUnit(AbstractUnit rightUnit);
    
    public Point getLeftConnection();
    
    public Point getRightConnection();
}
