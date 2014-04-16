package tulip.translator;

import java.awt.Color;
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
//                    tulip.Tulip.mainFrame.writeConsole("unit №"+unit.unitNumber+ " has no next unit");
//                    unit.color = Color.BLUE;
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
    
    public String validate(){
        for (AbstractUnit unit : units) {
            if(unit instanceof IInstructionUnit){
                String error = ((IInstructionUnit)unit).validateIntruction();
                if (error != null){
                    unit.color = Color.YELLOW;
                    return unit.unitNumber+"  "+ error;
                }
            }
        }
        return null;
    }
    
    public String translate(){     
        fillData();
        
        String error = validate();
        if (error != null){
            tulip.Tulip.mainFrame.writeConsole(error);
            return null;
        }
   
        String result = "program "+ name.substring(0, (name.indexOf(".") > 0)?name.indexOf("."):name.length() )+" \n begin\n";
        for (AbstractUnit unit : units) {
            if(unit instanceof IInstructionUnit){
                result += ((IInstructionUnit)unit).getInstruction(unit.unitNumber) + "\n";
            }
        }
        result += "end\n";
        
        return result;
    } 

}
