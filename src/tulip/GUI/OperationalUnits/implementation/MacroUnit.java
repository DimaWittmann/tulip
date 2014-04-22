package tulip.GUI.OperationalUnits.implementation;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import tulip.GUI.OperationalUnits.interfaces.*;
import tulip.translator.IInstructionUnit;
import tulip.translator.Instruction;

/**
 *
 * @author Wittman
 */
public class MacroUnit extends AbstractUnit{
    
    private String [] inLables;
    private Map<String, AbstractUnit> predUnits;
    
    private String [] outLables;
    private Map<String, AbstractUnit> nextUnits;
    private Map<String, Operand> operPos;
    
    private ArrayList<AbstractUnit> units;
    
    private int macroSize;
    
    /**
     * Unit represent macro
     * @param inCount number of inputs
     * @param outCount number of outputs
     */
    private void initArrays(int inCount, int outCount) {
        inLables = new String[inCount];
        predUnits = new HashMap();
        
        outLables = new String[outCount];
        nextUnits = new HashMap<>();
        operPos = new HashMap<>();
    }

    public MacroUnit(ArrayList<AbstractUnit> units) {
        this.units = units;
    }
    
    public int getMacrosSize(){
        return macroSize;
    }
    
    public void setOperand(String var, String op){
        if(!Arrays.asList(inLables).contains(var)){
            return;
        }
        Operand pos = null;
        for( AbstractUnit unit : units){
            if(unit instanceof  InputPin){
                if(((InputPin)unit).name.equals(var)){
                    IInstructionUnit nextInst = ((IInstructionUnit)(((InputPin)unit).getNextUnit()));
                    nextInst.setOperand(var, unit.position.ordinal());
                    break;
                }
            }
        }

        ((IInstructionUnit)predUnits.get(var)).setOperand(var, pos.ordinal());
    }
    
    @Override
    public void showCustomizedDialog() {
    }


    public int getNumberInputs() {
        return inLables.length;
    }
    
    public String getInLable(int pos){
        return inLables[pos];
    }
    
    public int getNumberOutputs(){
        return outLables.length;
    }
    
    public String getOutLable(int pos){
        return outLables[pos];
    }


    public void setPredUnit(AbstractUnit unit, String conn) {
        if(!Arrays.asList(inLables).contains(conn)){
            return;
        }else{
            predUnits.put(conn, unit);
        }
        
    }


    public AbstractUnit getPredUnit(String conn) {
        return predUnits.get(conn);
    }



    public void setNextUnit(AbstractUnit nextUnit, Operand pos, String conn) {
        nextUnits.put(conn, nextUnit);
        operPos.put(conn, pos);
    }

    
    public void fillData(){
        for(String l: outLables){
            AbstractUnit next = nextUnits.get(l);
            
            for( AbstractUnit unit : units){
                if(unit instanceof  OutputPin){
                    if(((OutputPin)unit).name.equals(l)){
                       AbstractUnit pred = ((OutputPin)unit).getPredUnit(0);
                       
                    }
                }
            }
        }
    }

    public AbstractUnit getNextUnit(String conn) {
        return  nextUnits.get(conn);
    }
    

    public Operand getNextUnitOperand(String conn) {
        return operPos.get(conn);
    }


    public Point getDownConnection(String conn) {
        int pos = 0;
        for (int i = 0; i <= outLables.length; i++) {
            if(i == outLables.length){
                return null;
            }
            if(outLables[i].equals(conn)){
                pos = i;
                break;
            }
        }
        
        Point connectionPoint = new Point(getWidth()/getNumberOutputs()*(pos+1), getHeight());
        connectionPoint.x += this.getX();
        connectionPoint.y += this.getY();
        return connectionPoint;
    }
    
    public final ArrayList<Instruction> compileMacros(int offest){
        ArrayList<Instruction> program = new ArrayList<>();
        ArrayList<InputPin> inPins = new ArrayList<>();
        ArrayList<OutputPin> outPins = new ArrayList<>();
        macroSize = 0;
        for (AbstractUnit unit : units) {
            if(unit instanceof InputPin){
                inPins.add((InputPin) unit);
            }
            if(unit instanceof OutputPin){
                outPins.add((OutputPin) unit);
            }
            if(unit instanceof AbstractUnit){
                macroSize++;
            }
        }
        
        initArrays(inPins.size(), outPins.size());
        int i = 0;
        for (InputPin pin : inPins) {
            inLables[i] = pin.name;
            i++;
        }
        i = 0;
        for (OutputPin pin : outPins) {
            inLables[i] = pin.name;
            i++;
        }
        
        int comm = 0;
        for (AbstractUnit unit : units) {
             if(unit instanceof IInstructionUnit){
                ((IInstructionUnit)unit).getInstruction(unitNumber+comm);
            }
        }
        
        return program;
    }

}
