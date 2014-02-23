package tulip.translator;

import java.util.ArrayList;
import tulip.GUI.OperationalUnits.implementation.DataUnit;
import tulip.GUI.OperationalUnits.interfaces.AbstractUnit;
import tulip.GUI.OperationalUnits.interfaces.IOutputUnit;

/**
 *
 * @author Wittman
 */
public class Translator {
    
    private ArrayList<AbstractUnit> units;

    public Translator(ArrayList<AbstractUnit> units) {
        this.units = units;
    }
    
    private void fillData(){
        for (AbstractUnit unit : units) {
            if(unit instanceof DataUnit){
                DataUnit dataUnit = (DataUnit)unit;
                IInstructionUnit nextUnit = (IInstructionUnit) dataUnit.getNextUnit();
                
                nextUnit.setOperand(dataUnit.getData(), dataUnit.position.ordinal());
            }else{
                if(unit instanceof IOutputUnit){
                    IInstructionUnit nextUnit = (IInstructionUnit) ((IOutputUnit)unit).getNextUnit();
                    nextUnit.setOperand("_", unit.position.ordinal());
                }
            }
        }
    }
    
    
    public String translate(){
        fillData();
        
        String result = "program p1 \n begin\n";
        for (AbstractUnit unit : units) {
            if(unit instanceof IInstructionUnit){
                result += ((IInstructionUnit)unit).getInstruction() + "\n";
            }
        }
        result += "end\n";
        
        return result;
    } 

}
