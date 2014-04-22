package tulip.GUI;

import java.awt.*;
import javax.swing.*;
import tulip.GUI.OperationalUnits.implementation.*;
import tulip.GUI.listeners.*;


/**
 * Global element of GUI
 * @author Wittman
 */
public class MainFrame extends JFrame{
    
    
    private JTextArea console;
    private JTabbedPane tabbedPane;
    private JScrollPane scrollConsole;
    
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
        
        this.add(getElementsPanel(), BorderLayout.WEST);
        
        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(800, 400));
        this.addNewTab();
        
        console = new JTextArea();
        console.setEditable(false);
        console.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        console.setForeground(Color.red);
        scrollConsole = new JScrollPane(console);
        
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
    
    private JButton createButton(Class instructionClass, String path, String desc ){
        JButton button = new JButton();
        button.setAction(new CreateUnitAction(instructionClass));
        button.setIcon(new ImageIcon(getClass().getResource(path)));
        button.setToolTipText(desc);
        return button;
    }
    
    private JScrollPane getElementsPanel(){
        JToolBar tools = new JToolBar();
        JScrollPane scrollPane = new JScrollPane(tools, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        tools.setRollover(true);
        tools.setLayout(new BoxLayout(tools, BoxLayout.Y_AXIS));
        
        
        tools.add(createButton(InputPin.class, 
                "/tulip/GUI/images/input.png", "Input pin for macro"));
        
        tools.add(createButton(OutputPin.class, 
                "/tulip/GUI/images/output.png", "Output pin for macro"));
        
        tools.add(createButton(ArithmeticUnit.class, 
                "/tulip/GUI/images/arithm.png", "Arithmetic operation"));
        
        tools.add(createButton(DataUnit.class, 
                "/tulip/GUI/images/data.png", "Input operation"));
        
        tools.add(createButton(LogicUnit.class, 
                "/tulip/GUI/images/logic.png", "Logic operation"));
        
        tools.add(createButton(OutUnit.class, 
                "/tulip/GUI/images/out.png", "Output operation"));
        
        tools.add(createButton(PropagatorUnit.class, 
                "/tulip/GUI/images/propagator.png", "Dublicating operation"));

        tools.add(createButton(RepeatorUnit.class, 
                "/tulip/GUI/images/repeator.png", "Repeat input operation"));
        
        tools.add(createButton(ValveUnit.class, 
                "/tulip/GUI/images/valve.png", "Choose operation"));
        

        
        return scrollPane;
    }
    
    private JMenuItem createJMenuItem(String title, Action action){
        JMenuItem item = new JMenuItem(title);
        item.addActionListener(action);
        return item;
    }
    
    private JMenuBar createMenu(){
        JMenuBar menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(createJMenuItem("New", new NewFileAction()));
        fileMenu.add(createJMenuItem("Close", new CloseFileAction()));
        fileMenu.add(createJMenuItem("Save", new SaveFileAction()));
        fileMenu.add(createJMenuItem("Save program", new SaveTextFileAction()));
        fileMenu.add(createJMenuItem("Load", new LoadFileAction()));
        
        JMenu runMenu = new JMenu("Run");
        runMenu.add(createJMenuItem("Compile", new CompileAction()));
        
        JMenu addMenu = new JMenu("Add");
        addMenu.add(createJMenuItem("Arithmetic operation", new CreateUnitAction(ArithmeticUnit.class)));
        addMenu.add(createJMenuItem("Input operation", new CreateUnitAction(DataUnit.class)));
        addMenu.add(createJMenuItem("Logic operation", new CreateUnitAction(LogicUnit.class)));
        addMenu.add(createJMenuItem("Output operation", new CreateUnitAction(OutUnit.class)));
        addMenu.add(createJMenuItem("Dublicating operation", new CreateUnitAction(PropagatorUnit.class)));
        addMenu.add(createJMenuItem("Velve operation", new CreateUnitAction(RepeatorUnit.class)));
        addMenu.add(createJMenuItem("Choose operation", new CreateUnitAction(ValveUnit.class)));
        
        menuBar.add(fileMenu);
        menuBar.add(runMenu);
        menuBar.add(addMenu);
        return menuBar;
    }

    
    public void writeConsole(String msg){
        console.setText(console.getText()+msg+"\n");
        scrollConsole.getVerticalScrollBar().setValue(scrollConsole.getVerticalScrollBar().getMinimum());
    }
}
