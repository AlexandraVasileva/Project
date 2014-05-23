package frames;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Search extends JFrame{
	
	private static Search instance;
	
	private int WIDTH = 400;
	private int HEIGHT = 150;
	private Color lightgrey = new Color(206, 206, 206);
	private Color lightlightgrey = new Color(224, 218, 230);
	
	private String[] variants = {"Поиск по автору", "Поиск по названию", "Поиск по серии", "Общий поиск"};
	
	public JFrame frame;
	public frames.StartPage startframe;
	public JTextField whatToSearch;
	public JComboBox howToSearch;
	
	private Search(frames.StartPage startframe){
		this.startframe = startframe;
		frame = new JFrame("");
		frame.setContentPane(createContentPane());
        frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
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
		
    	whatToSearch = new JTextField("", 20);
    	setFieldLF(whatToSearch);
    	
		howToSearch = new JComboBox(variants);
    	setFieldLF(howToSearch);
		
		JButton search = new JButton("Искать");
		setLabelLF(search);
		search.addActionListener(new actionListeners.SearchResultsEventListener(this.startframe));
		
		GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(
        		
        	layout.createParallelGroup(GroupLayout.Alignment.CENTER)
        			
        		.addGroup(layout.createSequentialGroup()		
        							
        				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        						.addComponent(whatToSearch, GroupLayout.PREFERRED_SIZE,
        								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(search))
          				.addComponent(howToSearch)));
        
        layout.linkSize(SwingConstants.VERTICAL,
         		  new java.awt.Component[]{whatToSearch, howToSearch});
        	
         layout.setVerticalGroup(

        	 layout.createSequentialGroup()
        		  
        		 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        				.addComponent(whatToSearch, GroupLayout.PREFERRED_SIZE,
        								  GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(howToSearch))
        		  .addGap(40)
        		 .addComponent(search));
         
         return contentPane;
	}
	
    public static synchronized Search getInstance(frames.StartPage startframe) {
    	if (instance == null){
    		instance = new Search(startframe);
    	}
    	return instance;
    }
	
}
