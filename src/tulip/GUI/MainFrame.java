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
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import tulip.GUI.OperationalUnits.implementation.ArithmeticUnit;
import tulip.GUI.OperationalUnits.implementation.DataUnit;
import tulip.GUI.OperationalUnits.implementation.LogicUnit;
import tulip.GUI.OperationalUnits.implementation.OutUnit;
import tulip.GUI.OperationalUnits.implementation.PropagatorUnit;
import tulip.GUI.OperationalUnits.implementation.RepeatorUnit;
import tulip.GUI.OperationalUnits.implementation.ValveUnit;
import tulip.GUI.OperationalUnits.interfaces.AbstractUnit;
import tulip.GUI.listeners.CloseFileAction;
import tulip.GUI.listeners.CompileAction;
import tulip.GUI.listeners.CreateUnitAction;
import tulip.GUI.listeners.LoadFileAction;
import tulip.GUI.listeners.NewFileAction;
import tulip.GUI.listeners.SaveFileAction;
import tulip.GUI.listeners.SaveTextFileAction;

/**
 *
 * @author Wittman
 */
public class MainFrame extends JFrame{
    
    
    private JTextArea console;
    private JTabbedPane tabbedPane;
    
    public JTextArea getConsole(){
        return console;
    }
   
    
    public GraphPanel getGrapPanel() {
        if(tabbedPane.getSelectedComponent()instanceof GraphPanel){
            return (GraphPanel) tabbedPane.getSelectedComponent();
        }
        return null;
    }

    public MainFrame() {
        
        this.setLayout(new BorderLayout());
        
        this.setJMenuBar(createMenu());
        
        this.add(ElementsPanel(), BorderLayout.WEST);
        
        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(800, 400));
        this.addNewTab();
        
        console = new JTextArea();
        console.setEditable(false);
        console.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        console.setForeground(Color.red);
        JScrollPane scrollConsole = new JScrollPane(console);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tabbedPane, scrollConsole);
        this.add(splitPane);
        
        this.setPreferredSize(new Dimension(800, 600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
    
    public void addNewTab(){
        tabbedPane.add("untitled", new GraphPanel());
    }
    
    public void deleteTab(){
        tabbedPane.removeTabAt(tabbedPane.getSelectedIndex());
    }
    
    public String getTabName(){
        return tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
    }
    
    public void setTabName(String s){
        tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), s);
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
        JMenuItem newFile = new JMenuItem("New");
        newFile.addActionListener(new NewFileAction());
        JMenuItem closeFile = new JMenuItem("Close");
        closeFile.addActionListener(new CloseFileAction());
        JMenuItem saveFile = new JMenuItem("Save");
        saveFile.addActionListener(new SaveFileAction());
        JMenuItem saveTextFile = new JMenuItem("Save program");
        saveTextFile.addActionListener(new SaveTextFileAction());
        JMenuItem loadFile = new JMenuItem("Load");
        loadFile.addActionListener(new LoadFileAction());
        fileMenu.add(newFile);
        fileMenu.add(closeFile);
        fileMenu.add(saveFile);
        fileMenu.add(saveTextFile);
        fileMenu.add(loadFile);
        
        
        JMenu runMenu = new JMenu("Run");
        JMenuItem compile = new JMenuItem("Compile");
        compile.addActionListener(new CompileAction());
        runMenu.add(compile);
        
        JMenu addMenu = new JMenu("Add");
        
        menuBar.add(fileMenu);
        menuBar.add(runMenu);
        menuBar.add(addMenu);
        return menuBar;
    }

    
    public void writeConsole(String msg){
        console.setText(msg+"\n"+console.getText());
    }
}
