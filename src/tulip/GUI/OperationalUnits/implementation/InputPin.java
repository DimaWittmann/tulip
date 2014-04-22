package tulip.GUI.OperationalUnits.implementation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JOptionPane;
import static tulip.GUI.Constants.SIZE_UNIT;
import tulip.GUI.OperationalUnits.interfaces.AbstractUnit;
import tulip.GUI.OperationalUnits.interfaces.IOutputUnit;

/**
 * Represent an input for the user defined macroses
 * @author Wittman
 */
public class InputPin extends AbstractUnit implements IOutputUnit{

    public String name;

    public InputPin() {
        super();
        setSize(new Dimension(5*SIZE_UNIT+1, 10*SIZE_UNIT+1));
    }
    
    
    
    @Override
    public void showCustomizedDialog() {
        Object result = JOptionPane.showInputDialog(
            tulip.Tulip.mainFrame, 
            "Input pin name"
        );
        if( result != null){
            name = (String) result;
            tulip.Tulip.mainFrame.getGrapPanel().repaint();
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(color);
        g.setFont(new Font(g.getFont().getFontName(), Font.BOLD, 30));
        
        g.drawRect(0, 0, getWidth()-1, getHeight()-1);
        g.drawLine(0, getHeight()/4*3, getWidth()/2, getHeight());
        g.drawLine(getWidth()/2, getHeight(), getWidth(), getHeight()/4*3);
        
        if( name != null){
            g.drawString(name,getWidth()/4, getHeight()/2);
        }
    }

    @Override
    public Point getDownConnection() {
        Point connectionPoint = new Point(getWidth()/2, getHeight());
        connectionPoint.x += this.getX();
        connectionPoint.y += this.getY();
        return connectionPoint;
    }

    @Override
    public AbstractUnit getNextUnit() { 
        return nextUnit;
    }

    @Override
    public void setNextUnit(AbstractUnit nextUnit, Operand pos) {
        this.position = pos;
        this.nextUnit = nextUnit;
    }
}
