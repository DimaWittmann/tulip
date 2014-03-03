package tulip.GUI.listeners;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Wittman
 */
public class NewFileAction extends AbstractAction{

    @Override
    public void actionPerformed(ActionEvent e) {
        tulip.Tulip.mainFrame.addNewTab();
    }

}
