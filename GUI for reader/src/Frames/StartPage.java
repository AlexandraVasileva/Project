package Frames;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class StartPage extends JFrame{
	
    public static int WIDTH = 500;
    public static int HEIGHT = 300;

    public Container createContentPane() {
        
        JLabel welcome = new JLabel("Добро пожаловать в вашу домашнюю библиотеку");
        
        JLabel title = new JLabel("OpenBook Home Library ver 0.0");
        JButton library = new JButton("В библиотеку");
        JButton search = new JButton("Поиск");
        JButton synchronize = new JButton("Синхронизация");
        JButton help = new JButton("Справка");
    	
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
        		.addComponent(library)
        		.addComponent(search)
        		.addComponent(synchronize)
        		.addComponent(help));
          
         layout.setVerticalGroup(
        	 layout.createSequentialGroup()

        		.addComponent(welcome, GroupLayout.PREFERRED_SIZE,
        		        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        		.addComponent(title)
        		.addComponent(library)
        		.addComponent(search)
        		.addComponent(synchronize)
        		.addComponent(help));
 
           pack();
        
        return contentPane;
    }
    
	public static void createAndShowGUI() throws IOException{
		
        JFrame frame = new JFrame("OpenBook Home Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        StartPage demo = new StartPage();

        frame.setContentPane(demo.createContentPane());
    //    frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	

}
