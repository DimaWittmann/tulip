package tulip.GUI.OperationalUnits.listeners;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tulip.GUI.OperationalUnits.AbstractUnit;
import tulip.GUI.OperationalUnits.IOutputUnit;
import tulip.GUI.OperationalUnits.ITwoInputUnit;

/**
 *
 * @author Wittman
 */
public class UnitListener  implements MouseListener, MouseMotionListener, KeyListener {

    private static AbstractUnit selected;
    private Point oldP;

    public UnitListener() {
    
    }

    @Override
    public void mouseDragged(MouseEvent e) {

            JPanel panel = ((JPanel) e.getSource());
            panel.setLocation(panel.getX()-(oldP.x-e.getX()), panel.getY() - (oldP.y - e.getY()));
            tulip.Tulip.mainFrame.getGrapPanel().repaint();
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        switch(e.getModifiers()){


        case 0x10: //left mouse button
            if(e.getClickCount() == 2){
                AbstractUnit unit = (AbstractUnit) e.getSource();
                unit.showCustomizedDialog();
            }
            
            if(e.getClickCount() == 1){
                if(selected == e.getSource()){
                    selected.color = Color.BLACK;
                    selected = null;
                    tulip.Tulip.mainFrame.getGrapPanel().repaint();
                    return;
                }
                
                if(selected != null){
                    selected.color = Color.BLACK;
                }
                selected = (AbstractUnit) e.getSource();
                selected.color = Color.RED;

                tulip.Tulip.mainFrame.getGrapPanel().repaint();
            }

            break;

        case 0x4: //right mouse button
            if(selected != e.getSource()){
                AbstractUnit next = (AbstractUnit) e.getSource();
                if( next instanceof ITwoInputUnit && 
                        selected instanceof IOutputUnit){
                    
                    Object[] options = AbstractUnit.Operand.values();
                    int i = JOptionPane.showOptionDialog(
                            tulip.Tulip.mainFrame,
                            "Choose input position",
                            "Cutomized Connection",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,     //do not use a custom Icon
                            options,  //the titles of buttons
                            AbstractUnit.Operand.values()[0]); //default button title
                    
                    ((IOutputUnit)selected).setNextUnit(next, AbstractUnit.Operand.values()[i]);
                    tulip.Tulip.mainFrame.getGrapPanel().repaint();
                }
                
            }
            break;

        case 0x12: //left mouse button + ctrl

            break;

        case 0x11:  //left mouse button + shift

            break;
        }
        
        

    }
        

    

    @Override
    public void mousePressed(MouseEvent e) {
        
        ((JPanel)e.getSource()).requestFocusInWindow();
        oldP = new Point(e.getX(), e.getY());
        
        tulip.Tulip.mainFrame.getGrapPanel().setComponentZOrder((JPanel)e.getSource(), 0);
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        

        JPanel panel = ((JPanel) e.getSource());
        
        
        int x = panel.getX()-(oldP.x-e.getX());
        int y = panel.getY() - (oldP.y - e.getY());
        panel.setLocation(x, y);
        oldP = null;
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == 127){      //DELETE
            AbstractUnit unit = (AbstractUnit) e.getSource();
            tulip.Tulip.mainFrame.getGrapPanel().removeUnit(unit);
        }
        
    }
}

    