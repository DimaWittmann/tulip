package tulip.GUI.OperationalUnits.interfaces;

import java.awt.Point;

/**
 * 
 * @author Wittman
 */
public interface IInputUnit {

    public int getNumberInputs();
    
    public void setNextUnit(AbstractUnit unit, int pos);
    
    public AbstractUnit getNextUnit(int pos);
    
    public Point getConnectionPoint(int pos);
    
}
