package tulip.GUI.OperationalUnits;

import java.awt.Dimension;
import java.awt.Graphics;
import tulip.GUI.Constants;
import static tulip.GUI.Constants.SIZE_UNIT;

/**
 *
 * @author Wittman
 */
public class OutUnit extends AbstractUnit{

    public OutUnit() {
        setSize(new Dimension(10*SIZE_UNIT+1, 5*SIZE_UNIT+1));
    }
    

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawOval(0, 0, SIZE_UNIT*Constants.DIAMETER*2, SIZE_UNIT*Constants.DIAMETER);
    }

}
