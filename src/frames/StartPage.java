package frames;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import library.Library;

public class StartPage extends JFrame{
	
    private int WIDTH = 375;
    private int HEIGHT = 350;
    private int GAP = 50;
    private Color lightgrey = new Color(206, 206, 206);
    public JFrame frame;
    public JButton last;
    public ActionListener lastListener;
    
    public String saveway = "data";
    
	public Library openbook = new Library();

  
    public StartPage(){

    	openbook.load(saveway);
    	openbook.check();
        openbook.find("TestLibrary");
        openbook.save(saveway);
        openbook.loadModes(saveway);
        if(openbook.getListOfModes().size() != 3) {
        	openbook.setDefaultModes(saveway);
        }
        frame = new JFrame("OpenBook Home Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(createContentPane());
        frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
    
	private void setLabelLF(JComponent component){
		component.setBackground(lightgrey);
		component.setForeground(Color.darkGray);
		component.setFont(new Font("monospaced", Font.PLAIN, 18));
	}

    public Container createContentPane() {
        
        JLabel welcome = new JLabel("Добро пожаловать в вашу домашнюю библиотеку");
        welcome.setFont(new Font("serif", Font.ITALIC, 15));
        JLabel title = new JLabel("OpenBook Home Library ver 1.0");
        title.setFont(new Font("serif", Font.ITALIC, 22));
        
        last = new JButton("К последнему чтению");
        lastListener = new actionListeners.LastEventListener(this, openbook.loadPreviousBook(saveway));
        last.addActionListener(lastListener); // StartPage to Reader (last reading)
        
        last.setBorderPainted(false);
        last.setFocusPainted(false);
        setLabelLF(last);
        
        JButton library = new JButton("В библиотеку");
        library.addActionListener(new actionListeners.ToLibraryEventListener(this)); // StartPage to Library
        library.setBorderPainted(false);
        setLabelLF(library);
        
        JButton search = new JButton("Поиск");
        search.setBorderPainted(false);
        setLabelLF(search);
        search.addActionListener(new actionListeners.SearchEventListener(this));
        
        JButton synchronize = new JButton("Синхронизация");
        synchronize.setBorderPainted(false);
        setLabelLF(synchronize);
        synchronize.addActionListener(new actionListeners.SynchronizeEventListener(this));
        
        JButton help = new JButton("Справка");
        help.setBorderPainted(false);
        setLabelLF(help);
        help.addActionListener(new actionListeners.HelpEventListener());
    	
    	JPanel contentPane = new JPanel();
    	contentPane.setBackground(lightgrey);
    	GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(
        	layout.createParallelGroup(GroupLayout.Alignment.CENTER)

        		.addComponent(welcome, GroupLayout.PREFERRED_SIZE,
        		       GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        		.addComponent(title)
        		.addGap(GAP)
        		.addComponent(last)
        		.addComponent(library)
        		.addComponent(search)
        		.addComponent(synchronize)
        		.addComponent(help));
        
        layout.linkSize(SwingConstants.HORIZONTAL,
         		  new java.awt.Component[]{last, library, search, synchronize, help});
          
         layout.setVerticalGroup(
        	 layout.createSequentialGroup()

        		.addComponent(welcome, GroupLayout.PREFERRED_SIZE,
        		        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        		.addComponent(title)
        		.addGap(GAP)
        		.addComponent(last)
        		.addComponent(library)
        		.addComponent(search)
        		.addComponent(synchronize)
        		.addComponent(help));
 
           pack();
        
        return contentPane;
    }

}