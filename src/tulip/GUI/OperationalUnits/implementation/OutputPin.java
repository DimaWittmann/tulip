package tulip.GUI.OperationalUnits.implementation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JOptionPane;
import static tulip.GUI.Constants.SIZE_UNIT;
import tulip.GUI.OperationalUnits.interfaces.AbstractUnit;
import tulip.GUI.OperationalUnits.interfaces.IInputUnit;

/**
 *
 * @author Wittman
 */
public class OutputPin extends AbstractUnit implements IInputUnit{
    
    public String name;

    public OutputPin() {
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
    public int getNumberInputs() {
        return 1;
    }

    @Override
    public void setPredUnit(AbstractUnit unit, int pos) {
        if(pos == 0){
            leftUnit = unit;
        }
    }

    @Override
    public AbstractUnit getPredUnit(int pos) {
        if(pos == 0){
            return leftUnit;
        }
        return null;
    }

    @Override
    public Point getConnectionPoint(int pos) {
        if(pos == 0){
            Point connectionPoint = new Point(getWidth()/2, 0);
            connectionPoint.x += this.getX();
            connectionPoint.y += this.getY();
            return connectionPoint;
        }
        return null;
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(color);
        g.setFont(new Font(g.getFont().getFontName(), Font.BOLD, 30));
        
        g.drawRect(0, 0, getWidth()-1, getHeight()-1);
        g.drawLine(0, 0, getWidth()/2, getHeight()/4);
        g.drawLine(getWidth()/2, getHeight()/4, getWidth(), 0);
        
        if( name != null){
            g.drawString(name,getWidth()/4, getHeight()/2);
        }
    }


}
