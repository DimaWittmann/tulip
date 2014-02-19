package tulip.GUI.OperationalUnits;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import static tulip.GUI.Constants.SIZE_UNIT;

/**
 *
 * @author Wittman
 */
public class ArithmeticUnit extends AbstractUnit{

    public ArithmeticUnit() {
        setSize(new Dimension(10*SIZE_UNIT+1, 5*SIZE_UNIT+1));

    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawRect(0, 0, SIZE_UNIT*10, SIZE_UNIT*5);
    }

}
