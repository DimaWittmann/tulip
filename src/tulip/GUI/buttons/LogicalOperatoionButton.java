package tulip.GUI.buttons;

import java.awt.Graphics;
import java.awt.Polygon;
import static tulip.GUI.Constants.SIZE_UNIT;

/**
 *
 * @author Wittman
 */
public class LogicalOperatoionButton extends CommonButton{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Polygon rombus = new Polygon();
        rombus.addPoint(SIZE_UNIT*2+SIZE_UNIT/2, SIZE_UNIT/2);
        rombus.addPoint(SIZE_UNIT*4+SIZE_UNIT/2, SIZE_UNIT*2+SIZE_UNIT/2);
        rombus.addPoint(SIZE_UNIT*2+SIZE_UNIT/2, SIZE_UNIT*4+SIZE_UNIT/2);
        rombus.addPoint(SIZE_UNIT/2, SIZE_UNIT*2+SIZE_UNIT/2);
        g.drawPolygon(rombus);
    }

}
