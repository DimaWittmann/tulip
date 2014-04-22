package tulip.translator;

/**
 *
 * @author Wittman
 */
public class Instruction {
    
    public int number;
    public String operation;
    public String operand1;
    public String operand2;
    public int resPosition;
    public int destination;

    /**
     * Create Instruction
     * @param number
     * @param operation
     * @param operand1
     * @param operand2
     * @param resPosition
     * @param destination 
     */
    public Instruction(int number, String operation, String operand1, String operand2, int resPosition, int destination) {
        this.number = number;
        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.resPosition = resPosition;
        this.destination = destination;
    }
    
    /**
     * Create instruction with
     * @param number
     * @param operation
     * @param resPosition
     * @param destination 
     */
    public Instruction(int number, String operation, int resPosition, int destination) {
        this.number = number;
        this.operation = operation;
        this.operand1 = "_";
        this.operand2 = "_";
        this.resPosition = resPosition;
        this.destination = destination;
    }
    

    @Override
    public String toString() {
        return number +" : "+operation+"  " +operand1 +", "+ operand2+" ! "+
                resPosition+" to " + destination;
    }
    
    

}
