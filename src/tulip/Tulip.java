package tulip;

import tulip.GUI.MainFrame;

/**
 *
 * @author Wittman
 */
public class Tulip {

    public static MainFrame mainFrame;
    
    public static void main(String [] args){
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
