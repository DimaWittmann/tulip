package tulip.GUI.OperationalUnits.interfaces;

import java.awt.Color;
import java.io.Serializable;
import javax.swing.JPanel;
import tulip.GUI.OperationalUnits.implementation.DataUnit;

import tulip.GUI.OperationalUnits.listeners.UnitListener;

/**
 *
 * @author Wittman
 */
public abstract class AbstractUnit extends JPanel implements Serializable{
    
    public Color color;
    public Operand position;
    
    public int UnitNumber;

    public AbstractUnit() {
        this(0);
    }
    
    public void setNumber(int number){
        UnitNumber = number;
        this.setToolTipText(String.valueOf(number));
    }
    
    public AbstractUnit(int number) {
        setNumber(number);
        
        UnitListener listener = new UnitListener();
        this.addMouseListener(listener);
        this.addMouseMotionListener(listener);
        this.addKeyListener(listener);
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
