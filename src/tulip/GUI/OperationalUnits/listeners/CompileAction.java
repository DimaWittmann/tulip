package tulip.GUI.OperationalUnits.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tulip.translator.Translator;

/**
 *
 * @author Wittman
 */
public class CompileAction implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        Translator translator = new Translator(tulip.Tulip.mainFrame.getGrapPanel().getUnits());
        String result = translator.translate();
        tulip.Tulip.mainFrame.writeConsole(result);
    }

}
