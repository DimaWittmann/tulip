package tulip.GUI.listeners;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import tulip.translator.Translator;

/**
 *
 * @author Wittman
 */
public class SaveFileAction extends  AbstractAction{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(tulip.Tulip.mainFrame);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                tulip.Tulip.mainFrame.setTabName(file.getName());
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(tulip.Tulip.mainFrame.getGrapPanel().getUnits());
                oos.flush();
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(SaveFileAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }

}
