package frames;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

public class NewNote  extends JFrame{
	
	private int WIDTH = 300;
	private int HEIGHT = 150;
	private Color lightgrey = new Color(206, 206, 206);
	private Color lightlightgrey = new Color(224, 218, 230);
	public JFrame frame;
	
	public NewNote(){
		frame = new JFrame("Новая заметка");
		frame.setContentPane(createContentPane());
        frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
	}
	
	private void setLabelLF(JComponent component){
		component.setBackground(lightgrey);
		component.setForeground(Color.darkGray);
		component.setFont(new Font("monospaced", Font.PLAIN, 14));
	}
	
	private void setFieldLF(JComponent component){
		component.setBackground(lightlightgrey);
		component.setForeground(Color.darkGray);
		component.setFont(new Font("sansserif", Font.PLAIN, 12));
	}
	
	private Container createContentPane() {
    	
        JPanel contentPane = new JPanel();
        contentPane.setBackground(lightgrey);
        
        GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        JLabel newLabel = new JLabel("Заметка:");
        setLabelLF(newLabel);
        
        JTextField newNote = new JTextField("", 20);
        setFieldLF(newNote);
        
        JButton ok = new JButton("OK");
        setLabelLF(ok);
        ok.addActionListener(new actionListeners.NewNoteOkEventListener(this));

        
layout.setHorizontalGroup(
        		
        layout.createParallelGroup(GroupLayout.Alignment.CENTER)
        
        			 .addGroup(layout.createSequentialGroup()
        				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        					.addComponent(newLabel, GroupLayout.PREFERRED_SIZE,
                				GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                			.addComponent(ok))
               			
               				.addComponent(newNote)));

         
         layout.linkSize(SwingConstants.VERTICAL,
          		  new java.awt.Component[]{newLabel, newNote, ok});
          
          layout.setVerticalGroup(

        	   layout.createSequentialGroup()
        		  
        		  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        					.addComponent(newLabel, GroupLayout.PREFERRED_SIZE,
                				GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                			.addComponent(newNote))
               			
                			.addGap(20)
               				.addComponent(ok));
        
        return contentPane;
	
    }
	
}

