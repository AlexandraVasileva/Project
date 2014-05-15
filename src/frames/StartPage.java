package frames;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

public class StartPage extends JFrame{
	
    private int WIDTH = 375;
    private int HEIGHT = 300;
    private int GAP = 30;
    public static JFrame frame; // NB Cannot make the LastEventListener to hide it otherwise, what do I do?
    
    
    public StartPage(){
        frame = new JFrame("OpenBook Home Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(createContentPane());
        frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public Container createContentPane() {
        
        JLabel welcome = new JLabel("Добро пожаловать в вашу домашнюю библиотеку");
        welcome.setFont(new Font("sansserif", Font.PLAIN, 15));
        JLabel title = new JLabel("OpenBook Home Library ver 05.05");
        title.setFont(new Font("serif", Font.PLAIN, 22));
        
        JButton last = new JButton("К последнему чтению");
        last.addActionListener(new actionListeners.LastEventListener());
        last.setBorderPainted(false);
        last.setFocusPainted(false);
        
        JButton library = new JButton("В библиотеку");
        library.addActionListener(new actionListeners.ToLibraryEventListener());
        library.setBorderPainted(false);
        
        JButton search = new JButton("Поиск");
        search.setBorderPainted(false);
        
        JButton synchronize = new JButton("Синхронизация");
        synchronize.setBorderPainted(false);
        
        JButton help = new JButton("Справка");
        help.setBorderPainted(false);
        
    	
    	JPanel contentPane = new JPanel();
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
    
	public static void createAndShowGUI() throws IOException{
        new StartPage();
	}

}
