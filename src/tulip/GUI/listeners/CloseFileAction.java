package tulip.GUI.listeners;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Wittman
 */
public class CloseFileAction extends AbstractAction{

    @Override
    public void actionPerformed(ActionEvent e) {
        tulip.Tulip.mainFrame.deleteTab();
    }

}
