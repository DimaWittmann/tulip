package tulip.GUI.OperationalUnits.implementation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JOptionPane;
import tulip.GUI.Constants;
import static tulip.GUI.Constants.SIZE_UNIT;
import tulip.GUI.OperationalUnits.interfaces.InputOutputUnit;

/**
 *
 * @author Wittman
 */
public class ValveUnit extends InputOutputUnit{
    
    private Type type;

    public ValveUnit() {
        type = Type.IF;
        setSize(new Dimension(Constants.DIAMETER*SIZE_UNIT*3/2+1, Constants.DIAMETER*SIZE_UNIT*3/2+1));
    }
    
    
    
    @Override
    public void showCustomizedDialog() {
        Object result = JOptionPane.showInputDialog(
                tulip.Tulip.mainFrame, 
                "Choose operand", 
                "Operation", 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                Type.values(), 
                type);
        if( result != null){
            type = (Type) result;
            tulip.Tulip.mainFrame.getGrapPanel().repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillOval(0, 0, SIZE_UNIT*Constants.DIAMETER*3/2, SIZE_UNIT*Constants.DIAMETER*3/2);
        
        g.setColor(color);
        g.drawOval(0, 0, SIZE_UNIT*Constants.DIAMETER*3/2, SIZE_UNIT*Constants.DIAMETER*3/2);
        
        g.setFont(new Font(Font.SERIF, Font.BOLD, 24));
        g.drawString(type.toString(), SIZE_UNIT*Constants.DIAMETER/3, SIZE_UNIT*Constants.DIAMETER);

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
        Point connectionPoint = new Point(getWidth()/6*5, getHeight()/7);
        connectionPoint.x += this.getX();
        connectionPoint.y += this.getY();
        return connectionPoint;
    }
    public enum Type{
        IF, IF_N
    }  
    
    
    @Override
    public String getMnemonic() {
        return type.toString();
    }
}

