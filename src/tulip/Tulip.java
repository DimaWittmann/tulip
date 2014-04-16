package tulip;

import tulip.GUI.MainFrame;

/**
 * Applecation entrance 
 * @author Wittman
 */
public class Tulip {

    /**
     * 
     * Represent whole application.
     * Provids access to all elements of GUI
     */
    public static MainFrame mainFrame;
    
    public static void main(String [] args){
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
