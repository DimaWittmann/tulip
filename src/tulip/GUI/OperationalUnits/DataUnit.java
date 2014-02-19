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
public class DataUnit extends AbstractUnit
                      implements IOutputUnit{

    private static double lastInput = 0;
    private double data;
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
        g.drawString(String.valueOf(data), SIZE_UNIT*Constants.DIAMETER/3, SIZE_UNIT*Constants.DIAMETER);
        this.setBackground(new Color(255, 225, 225, 0));
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
                data = Double.parseDouble((String) result);
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
    


}
