package tulip.GUI.OperationalUnits;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JOptionPane;
import tulip.GUI.Constants;
import static tulip.GUI.Constants.SIZE_UNIT;

/**
 *
 * @author Wittman
 */
public class OutUnit extends AbstractUnit 
                     implements ITwoInputUnit{

    
    public OutUnit() {
        setSize(new Dimension(10*SIZE_UNIT+1, 5*SIZE_UNIT+1));
    }
    
    
    @Override
    public AbstractUnit getLeftUnit() {
        return leftUnit;
    }

    @Override
    public void setLeftUnit(AbstractUnit leftUnit) {
        this.leftUnit = leftUnit;
    }

    @Override
    public AbstractUnit getRightUnit() {
        return rightUnit;
    }

    @Override
    public void setRightUnit(AbstractUnit rightUnit) {
        this.rightUnit = rightUnit;
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.WHITE);
        g.fillOval(0, 0, SIZE_UNIT*Constants.DIAMETER*2, SIZE_UNIT*Constants.DIAMETER);
        g.setColor(color);
        g.drawOval(0, 0, SIZE_UNIT*Constants.DIAMETER*2, SIZE_UNIT*Constants.DIAMETER);
        
        g.setFont(new Font(Font.SERIF, Font.BOLD, 24));
        g.drawString("OUT", SIZE_UNIT*Constants.DIAMETER/2, SIZE_UNIT*Constants.DIAMETER/3*2);
        
        this.setBackground(new Color(255, 225, 225, 0));
    }

    @Override
    @Deprecated
    public void showCustomizedDialog() {
    }


    @Override
    public Point getLeftConnection() {
        Point connectionPoint = new Point(getWidth()/2, 0);
        connectionPoint.x += this.getX();
        connectionPoint.y += this.getY();
        return connectionPoint;
    }

    @Override
    public Point getRightConnection() {
        Point connectionPoint = new Point( getWidth(), getHeight()/2);
        connectionPoint.x += this.getX();
        connectionPoint.y += this.getY();
        return connectionPoint;
    }
}
