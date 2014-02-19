package tulip.GUI.buttons;

import java.awt.Graphics;
import static tulip.GUI.Constants.SIZE_UNIT;

/**
 *
 * @author Wittman
 */
public class DataButton extends CommonButton{
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawOval(SIZE_UNIT, SIZE_UNIT, SIZE_UNIT*3, SIZE_UNIT*3);
    }


}
