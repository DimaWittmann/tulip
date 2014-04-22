package tulip.GUI.OperationalUnits.interfaces;

import java.awt.Point;

/**
 * Specifies posibilities to connect to this element
 * @author Wittman
 */
public interface IInputUnit {

    public int getNumberInputs();
    
    public void setPredUnit(AbstractUnit unit, int pos);
    
    public AbstractUnit getPredUnit(int pos);
    
    public Point getConnectionPoint(int pos);
    
}
