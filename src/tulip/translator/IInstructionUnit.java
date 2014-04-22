package tulip.translator;

/**
 * Respresent macroassembelr instruction
 * @author Wittman
 */
public interface IInstructionUnit {

    public void setOperand(String value, int operand);

    public String getOperand(int operand);
    
    
    public String getMnemonic(); 
    

    public Instruction getInstruction(int number);
    
    /**
     * Test if intruction has all necessary data
     * @return null if validate, otherwise - description of error
     */
    public String validateIntruction();
    
}
