package tulip.GUI.OperationalUnits;

import java.awt.Dimension;
import java.awt.Graphics;
import tulip.GUI.Constants;
import static tulip.GUI.Constants.SIZE_UNIT;

/**
 *
 * @author Wittman
 */
public class DataUnit extends AbstractUnit{

    public DataUnit() {
        setSize(new Dimension(Constants.DIAMETER*SIZE_UNIT*3/2+1, Constants.DIAMETER*SIZE_UNIT*3/2+1));
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawOval(0, 0, SIZE_UNIT*Constants.DIAMETER*3/2, SIZE_UNIT*Constants.DIAMETER*3/2);
    }



}
