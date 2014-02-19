package tulip.GUI.OperationalUnits;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import tulip.GUI.Constants;
import static tulip.GUI.Constants.SIZE_UNIT;

/**
 *
 * @author Wittman
 */
public class LogicUnit extends AbstractUnit{

    public LogicUnit() {
        setSize(new Dimension(10*SIZE_UNIT+1, 10*SIZE_UNIT+1));
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Polygon rombus = new Polygon();
        rombus.addPoint(SIZE_UNIT*Constants.DIAMETER, 0);
        rombus.addPoint(SIZE_UNIT*Constants.DIAMETER*2, SIZE_UNIT*Constants.DIAMETER);
        rombus.addPoint(SIZE_UNIT*Constants.DIAMETER, SIZE_UNIT*2*Constants.DIAMETER);
        rombus.addPoint(0, SIZE_UNIT*Constants.DIAMETER);
        g.drawPolygon(rombus);
    }

}
