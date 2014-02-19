package tulip.GUI.OperationalUnits;

import javax.swing.JPanel;
import tulip.GUI.OperationalUnits.listeners.UnitListener;

/**
 *
 * @author Wittman
 */
public class AbstractUnit extends JPanel{

    public AbstractUnit() {
        UnitListener listener = new UnitListener();
        this.addMouseListener(listener);
        this.addMouseMotionListener(listener);
    }

}
