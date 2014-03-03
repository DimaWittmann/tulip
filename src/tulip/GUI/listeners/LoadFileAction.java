package tulip.GUI.listeners;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import tulip.GUI.OperationalUnits.interfaces.AbstractUnit;

/**
 *
 * @author Wittman
 */
public class LoadFileAction extends AbstractAction{

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(tulip.Tulip.mainFrame);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file))) {
                tulip.Tulip.mainFrame.setTabName(file.getName());
                tulip.Tulip.mainFrame.getGrapPanel().addUnits((ArrayList<AbstractUnit>) oin.readObject());
                System.out.println(file.getName());
            } catch (IOException ex) {
                Logger.getLogger(SaveFileAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoadFileAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
    }

}
