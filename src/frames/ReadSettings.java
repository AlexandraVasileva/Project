package frames;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class ReadSettings extends JFrame{

	private int PROPERTIES = 7;
	private int WIDTH = 270;
	private int HEIGHT = 260;
	private int FIELD = 5;
	private int GAP = 30;
	private Color lightgrey = new Color(206, 206, 206);
	private Color lightlightgrey = new Color(224, 218, 230);
	public JFrame frame = new JFrame("Настройки чтения");
	
	public JComboBox mode;
	public JTextField size;
	public JComboBox font;
	
	public frames.Reader rframe;
	
	private String[] modes = {"Художественный", "Рабочий", "Пользовательский"};
	private String[] fonts = {"serif", "sansserif", "monospaced"};
	
	public ReadSettings(frames.Reader rframe){
		this.rframe = rframe;
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
		component.setFont(new Font("monospaced", Font.PLAIN, 16));
	}
	
	private void setFieldLF(JComponent component){
		component.setBackground(lightlightgrey);
		component.setForeground(Color.darkGray);
		component.setFont(new Font("sansserif", Font.PLAIN, 12));
	}

    public Container createContentPane() {
    	
        JPanel contentPane = new JPanel();
        contentPane.setBackground(lightgrey);
        
        JLabel modeLabel = new JLabel("Режим");
        setLabelLF(modeLabel);
		
        mode = new JComboBox(modes);
        setFieldLF(mode);
        
        JLabel sizeLabel = new JLabel("Кегль");
        setLabelLF(sizeLabel);
		
        size = new JTextField("", FIELD);
        setFieldLF(size);
        
        JLabel fontLabel = new JLabel("Шрифт");
        setLabelLF(fontLabel);
		
        font = new JComboBox(fonts);
        setFieldLF(font);
        
        JButton ok = new JButton("OK");
        setLabelLF(ok);
        ok.addActionListener(new actionListeners.SettingsOkEventListener(this, rframe));

        GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(
        		
        		layout.createParallelGroup(GroupLayout.Alignment.CENTER)
        			
        			.addGroup(layout.createSequentialGroup()
        					
        				.addGap(GAP)

        				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        					.addComponent(modeLabel, GroupLayout.PREFERRED_SIZE,
        						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(GAP)
        					.addComponent(sizeLabel)
        					.addComponent(fontLabel))
        				
        				.addGap(GAP)
        				
        				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        					.addComponent(mode, GroupLayout.PREFERRED_SIZE,
                				GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                			.addGap(GAP)
                			.addComponent(size)
                			.addComponent(font))
                		
                		 .addGap(GAP))
               				
               		.addGap(GAP)
               		.addComponent(ok));

         layout.linkSize(SwingConstants.HORIZONTAL,
       		  new java.awt.Component[]{mode, size, font});
         layout.linkSize(SwingConstants.VERTICAL,
          		  new java.awt.Component[]{mode, size, font, modeLabel, sizeLabel, fontLabel});
          
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
          
              	 .addGap(GAP)
              	 .addGap(GAP)
          	 	 .addComponent(ok));
          
          //pack();
           
        return contentPane;
    }

}