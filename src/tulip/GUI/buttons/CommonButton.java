package tulip.GUI.buttons;

import java.awt.Dimension;
import javax.swing.JButton;
import static tulip.GUI.Constants.SIZE_UNIT;

/**
 *
 * @author Wittman
 */
public class CommonButton extends JButton{

    public CommonButton() {
        setPreferredSize(new Dimension(10*SIZE_UNIT, 10*SIZE_UNIT));
        setMinimumSize(new Dimension(10*SIZE_UNIT, 10*SIZE_UNIT));
    }


}
