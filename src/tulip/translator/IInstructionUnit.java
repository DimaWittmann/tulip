package tulip.translator;

/**
 *
 * @author Wittman
 */
public interface IInstructionUnit {

    public void setOperand(String value, int operand);

    public String getOperand(int operand);
    
    
    public abstract String getMnemonic(); 
    

    public String getInstruction();
}
