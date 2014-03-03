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
    private String name;
    
    public Translator(ArrayList<AbstractUnit> units, String name) {
        this.units = units;
        this.name = name;
    }
    
    private void fillData(){
        for (AbstractUnit unit : units) {
            if(unit instanceof IOutputUnit ){
                IInstructionUnit nextUnit = (IInstructionUnit) ((IOutputUnit)unit).getNextUnit();
                if(nextUnit == null){
                    tulip.Tulip.mainFrame.writeConsole(unit +"  №"+unit.UnitNumber+ " have no next unit");
                }else
                if(unit instanceof DataUnit){
                    DataUnit dataUnit = (DataUnit)unit;
                    nextUnit.setOperand(dataUnit.getData(), dataUnit.position.ordinal());
                }else
                if(unit instanceof IOutputUnit){
                    nextUnit.setOperand("_", unit.position.ordinal());
                }
            }
        }
    }
    
    
    public String translate(){
        fillData();
        
        String result = "program "+ name.substring(0, name.indexOf("."))+" \n begin\n";
        for (AbstractUnit unit : units) {
            if(unit instanceof IInstructionUnit){
                result += ((IInstructionUnit)unit).getInstruction() + "\n";
            }
        }
        result += "end\n";
        
        return result;
    } 

}
