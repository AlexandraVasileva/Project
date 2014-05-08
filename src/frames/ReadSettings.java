package frames;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class ReadSettings extends JFrame{

	private int PROPERTIES = 7;
	private int WIDTH = 420;
	private int HEIGHT = 290;
	private int FIELD = 20;
	private int GAP = 30;
	
	public ReadSettings(){
		JFrame frame = new JFrame("Настройки чтения");
		frame.setContentPane(createContentPane());
        frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
	}

    public Container createContentPane() {
    	
        JPanel contentPane = new JPanel();
        
        JLabel modeLabel = new JLabel("Режим");
        JTextField mode = new JTextField("", FIELD);
        
        JLabel sizeLabel = new JLabel("Кегль");
        JTextField size = new JTextField("", FIELD);
        
        JLabel fontLabel = new JLabel("Шрифт");
        JTextField font = new JTextField("", FIELD);
        
        JLabel operationLabel = new JLabel("Действие при выделении");
        JTextField operation = new JTextField("", FIELD);
        
        JButton ok = new JButton("OK");

        GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(
        		
        		layout.createParallelGroup(GroupLayout.Alignment.CENTER)
        			
        			.addGroup(layout.createSequentialGroup()

        				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        					.addComponent(modeLabel, GroupLayout.PREFERRED_SIZE,
        						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(GAP)
        					.addComponent(sizeLabel)
        					.addComponent(fontLabel)
        					.addComponent(operationLabel))
        				
        				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        					.addComponent(mode, GroupLayout.PREFERRED_SIZE,
                				GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                			.addGap(GAP)
                			.addComponent(size)
                			.addComponent(font)
                			.addComponent(operation)))
               				
               		.addGap(GAP)
               		.addComponent(ok));

         layout.linkSize(SwingConstants.HORIZONTAL,
       		  new java.awt.Component[]{mode, size, font, operation});
          
          layout.setVerticalGroup(

        	   layout.createSequentialGroup()
        		  
        		  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        				.addComponent(modeLabel, GroupLayout.PREFERRED_SIZE,
        								  GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(mode))
        				
        		  .addGap(GAP)
        								 
        		  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
          				.addComponent(sizeLabel, GroupLayout.PREFERRED_SIZE,
          								  GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)			
        				.addComponent(size))
        
          		  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        				.addComponent(fontLabel, GroupLayout.PREFERRED_SIZE,
        								  GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          				.addComponent(font))
        
          	   	 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        				.addComponent(operationLabel, GroupLayout.PREFERRED_SIZE,
        								  GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)			
        				.addComponent(operation))
          
              	 .addGap(GAP)
          	 	 .addComponent(ok));
          
  //        pack();
           
        return contentPane;
    }

	public static void createAndShowGUI() throws IOException {
        new ReadSettings();
    }
}