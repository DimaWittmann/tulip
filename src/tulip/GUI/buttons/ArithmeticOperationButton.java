package tulip.GUI.buttons;

import java.awt.Graphics;
import static tulip.GUI.Constants.SIZE_UNIT;

/**
 *
 * @author Wittman
 */
public class ArithmeticOperationButton extends CommonButton{

    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawRect(SIZE_UNIT/2, SIZE_UNIT*2+SIZE_UNIT/2, SIZE_UNIT*5, SIZE_UNIT*5);
    }

}
