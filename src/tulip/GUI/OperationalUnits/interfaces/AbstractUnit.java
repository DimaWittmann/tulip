package tulip.GUI.OperationalUnits.interfaces;

import java.awt.Color;
import java.io.Serializable;
import javax.swing.JPanel;

/**
 *
 * @author Wittman
 */
public abstract class AbstractUnit extends JPanel implements Serializable{
    
    public Color color;
    public Operand position;
    
    public int unitNumber;

    public AbstractUnit() {
        this(0);
    }
    
    public void setNumber(int number){
        unitNumber = number;
        this.setToolTipText(String.valueOf(number));
    }
    
    public AbstractUnit(int number) {
        setNumber(number);
        
//        UnitListener listener = new UnitListener();
//        this.addMouseListener(listener);
//        this.addMouseMotionListener(listener);
//        this.addKeyListener(listener);
        this.setFocusable(true);
        this.setBackground(new Color(255, 225, 225, 0));
        this.color = Color.BLACK;

    }
    
    protected AbstractUnit leftUnit;
    protected AbstractUnit rightUnit;
    protected AbstractUnit nextUnit;
   

    

    
    public abstract void showCustomizedDialog();

    public enum Operand{
        FIRST, SECOND
    }
}
