package tulip.GUI.listeners;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.log;
import java.nio.Buffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import tulip.translator.Translator;

/**
 *
 * @author Wittman
 */
public class SaveTextFileAction extends AbstractAction{

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(tulip.Tulip.mainFrame);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            BufferedWriter writer;
            try {
                writer = new BufferedWriter(new FileWriter(file));
                Translator translator = new Translator(tulip.Tulip.mainFrame.getGrapPanel().getUnits(), file.getName());
                writer.write(translator.translate());
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(SaveTextFileAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } 
    }

}
