package tulip.GUI.OperationalUnits.interfaces;

import java.awt.Color;
import javax.swing.JPanel;
import tulip.GUI.OperationalUnits.implementation.DataUnit;

import tulip.GUI.OperationalUnits.listeners.UnitListener;

/**
 *
 * @author Wittman
 */
public abstract class AbstractUnit extends JPanel{
    
    public Color color;
    public Operand position;
    
    public int UnitNumber;
    public static int counter;
    
    public AbstractUnit() {
        if(!(this instanceof DataUnit)){
            counter++;
        }
        UnitNumber = counter;
        
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
