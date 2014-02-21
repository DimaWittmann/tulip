package tulip.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import tulip.GUI.OperationalUnits.implementation.ArithmeticUnit;
import tulip.GUI.OperationalUnits.implementation.DataUnit;
import tulip.GUI.OperationalUnits.implementation.LogicUnit;
import tulip.GUI.OperationalUnits.implementation.OutUnit;
import tulip.GUI.OperationalUnits.implementation.PropagatorUnit;
import tulip.GUI.OperationalUnits.implementation.RepeatorUnit;
import tulip.GUI.OperationalUnits.implementation.ValveUnit;
import tulip.GUI.listeners.CreateUnitAction;

/**
 *
 * @author Wittman
 */
public class MainFrame extends JFrame{
    
    
    private  GraphPanel grapPanel;
    private JTextArea console;
    
    public JTextArea getConsole(){
        return console;
    }
    public GraphPanel getGrapPanel() {
        return grapPanel;
    }

    public MainFrame() {
        
        this.setLayout(new BorderLayout());
        
        this.setJMenuBar(createMenu());
        
        this.add(ElementsPanel(), BorderLayout.WEST);
        
        grapPanel = new GraphPanel();
        grapPanel.setLayout(null);
        grapPanel.setPreferredSize(new Dimension(800, 400));
        
        console = new JTextArea();
        console.setEditable(false);
        console.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        console.setForeground(Color.red);
        JScrollPane scrollConsole = new JScrollPane(console);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, grapPanel, scrollConsole);
        this.add(splitPane);
        
        this.setPreferredSize(new Dimension(800, 600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
    
    
    private JScrollPane ElementsPanel(){
        JToolBar tools = new JToolBar();
        JScrollPane scrollPane = new JScrollPane(tools, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        tools.setRollover(true);
        tools.setLayout(new BoxLayout(tools, BoxLayout.Y_AXIS));
        
        JButton button = new JButton();
        button.setAction(new CreateUnitAction(ArithmeticUnit.class));
        button.setIcon(new ImageIcon(getClass().getResource("/tulip/GUI/images/arithm.png")));
        button.setToolTipText("Arithmetic operation");
        
        tools.add(button);
        
        button = new JButton();
        button.setAction(new CreateUnitAction(DataUnit.class));
        button.setIcon(new ImageIcon(getClass().getResource("/tulip/GUI/images/data.png")));
        button.setToolTipText("Input operation");
        tools.add(button);
        
        button = new JButton();
        button.setAction(new CreateUnitAction(LogicUnit.class));
        button.setIcon(new ImageIcon(getClass().getResource("/tulip/GUI/images/logic.png")));
        button.setToolTipText( "Logic operation");
        tools.add(button);
        
        button = new JButton();
        button.setAction(new CreateUnitAction(OutUnit.class));
        button.setIcon(new ImageIcon(getClass().getResource("/tulip/GUI/images/out.png")));
        button.setToolTipText("Output operation");
        tools.add(button);
        
        button = new JButton();
        button.setAction(new CreateUnitAction(PropagatorUnit.class));
        button.setIcon(new ImageIcon(getClass().getResource("/tulip/GUI/images/propagator.png")));
        button.setToolTipText("Dublicating operation");
        tools.add(button);
        
        button = new JButton();
        button.setAction(new CreateUnitAction(RepeatorUnit.class));
        button.setIcon(new ImageIcon(getClass().getResource("/tulip/GUI/images/repeator.png")));
        button.setToolTipText("Repeat input operation");
        tools.add(button);
        
        button = new JButton();
        button.setAction(new CreateUnitAction(ValveUnit.class));
        button.setIcon(new ImageIcon(getClass().getResource("/tulip/GUI/images/valve.png")));
        button.setToolTipText("Choose operation");
        tools.add(button);
        
        return scrollPane;
    }
    
    private JMenuBar createMenu(){
        JMenuBar menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("File");
        
        
        JMenu runMenu = new JMenu("Run");
        JMenuItem compile = new JMenuItem("Compile");
        
        runMenu.add(compile);
        
        JMenu addMenu = new JMenu("Add");
        
        menuBar.add(fileMenu);
        menuBar.add(runMenu);
        menuBar.add(addMenu);
        return menuBar;
    }

}
