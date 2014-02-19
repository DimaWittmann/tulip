package tulip.GUI.listeners;

import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import tulip.GUI.OperationalUnits.AbstractUnit;

/**
 *
 * @author Wittman
 */
public class CreateUnitAction extends AbstractAction{

    private Class<? extends AbstractUnit> unit;

    public CreateUnitAction(Class unit) {
        this.unit = unit;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
             AbstractUnit obj = unit.newInstance();
             tulip.Tulip.mainFrame.getGrapPanel().addUnit(obj);
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(CreateUnitAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
