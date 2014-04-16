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
public class RepeatorUnit extends InputOutputUnit{

    private Type type;

    public RepeatorUnit() {
        type = Type.UNSPECIFIED;
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
        
        g.drawLine(getWidth()/2, getHeight()/2, getWidth()/2, getHeight());
        g.drawLine(getWidth()/2+3, getHeight()-10, getWidth()/2, getHeight());
        g.drawLine(getWidth()/2-3, getHeight()-10, getWidth()/2, getHeight());
        switch(type){
        case UNSPECIFIED:
            g.drawLine(getWidth()/2, getHeight()/2, getWidth()/3*2, getHeight()/8);
            break;
        case EQ1:
            g.drawLine(getWidth()/2, getHeight()/2, getWidth()/2, 0);
            break;
        case EQ2:
            g.drawLine(getWidth()/2, getHeight()/2, getWidth()/6*5, getHeight()/7);
            break;
        }
    }
    
    
    @Override
    public Point getLeftConnectionPoint() {
        Point connectionPoint = new Point(getWidth()/2, 0);
        connectionPoint.x += this.getX();
        connectionPoint.y += this.getY();
        return connectionPoint;
    }

    @Override
    public Point getRightConnectionPoint() {
        Point connectionPoint = new Point(getWidth()/6*5, getHeight()/7);
        connectionPoint.x += this.getX();
        connectionPoint.y += this.getY();
        return connectionPoint;
    }
    public enum Type{
        EQ1, EQ2, UNSPECIFIED 
    }  
    
    @Override
    public String getMnemonic() {
        return type.toString();
    }
}
