package tulip.GUI.OperationalUnits;

import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import static javax.swing.UIManager.put;

import tulip.GUI.OperationalUnits.listeners.UnitListener;

/**
 *
 * @author Wittman
 */
public abstract class AbstractUnit extends JPanel{
    
    public Color color;
    public Operand position;
    
    
    public AbstractUnit() {
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
