package tulip.GUI.OperationalUnits.implementation;

import tulip.GUI.OperationalUnits.interfaces.IOutputUnit;
import tulip.GUI.OperationalUnits.interfaces.AbstractUnit;
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
public class DataUnit extends AbstractUnit
                      implements IOutputUnit{

    private static String lastInput = "0";
    private String data = "0";
    public DataUnit() {
        
        setSize(new Dimension(Constants.DIAMETER*SIZE_UNIT*3/2+1, Constants.DIAMETER*SIZE_UNIT*3/2+1));
    }


    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillOval(0, 0, SIZE_UNIT*Constants.DIAMETER*3/2, SIZE_UNIT*Constants.DIAMETER*3/2);
        g.setColor(color);
        g.drawOval(0, 0, SIZE_UNIT*Constants.DIAMETER*3/2, SIZE_UNIT*Constants.DIAMETER*3/2);
        g.setFont(new Font(Font.SERIF, Font.BOLD, 24));
        g.drawString(data, SIZE_UNIT*Constants.DIAMETER/2, SIZE_UNIT*Constants.DIAMETER);

    }

    
    @Override
    public void showCustomizedDialog() {
        Object result = JOptionPane.showInputDialog(
            tulip.Tulip.mainFrame, 
            "Input data", 
            lastInput
        );
        if( result != null){
            try{
                data = (String) result;
                lastInput = data;
                tulip.Tulip.mainFrame.getGrapPanel().repaint();
            }catch(NumberFormatException e){
            }
        }
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
    
    
        
    @Override
    public  Point getDownConnection(){
        Point connectionPoint = new Point(getWidth()/2, getHeight());
        connectionPoint.x += this.getX();
        connectionPoint.y += this.getY();
        return connectionPoint;
    }
    
    public String getData(){
        return data;
    }

}
