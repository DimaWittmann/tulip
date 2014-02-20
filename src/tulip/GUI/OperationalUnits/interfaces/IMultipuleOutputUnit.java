package tulip.GUI.OperationalUnits.interfaces;

/**
 *
 * @author Wittman
 */
public interface IMultipuleOutputUnit extends IOutputUnit{
    
    public void setNextUnit(AbstractUnit nextUnit, AbstractUnit.Operand pos, int number);
    
    
    public AbstractUnit getNextUnit(int number);


}
