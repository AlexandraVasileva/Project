package frames;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import readFromFile.ReadTextFromFile;

public class Help extends JFrame{
	
	public JFrame frame;
	
	private int WIDTH = 1000;
	private int HEIGHT = 500;
	
	private String help = "Help.txt";
	
	public Help () {

		frame = new JFrame("Справка");
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		
		JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
        
		JTextPane output = new JTextPane();

        try {
			ReadTextFromFile reader=new ReadTextFromFile();
			output.setText(reader.readTxt(help));
		} catch (IOException e) {
			e.printStackTrace();
		}
        output.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(output);
        scrollPane.setSize(WIDTH, HEIGHT);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        contentPane.add(scrollPane, BorderLayout.CENTER);
		
		frame.setContentPane(contentPane);
		frame.setVisible(true);
	}
	
}
