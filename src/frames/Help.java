package frames;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

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
			try {
				ReadTextFromFile reader=new ReadTextFromFile();
				output.setText(reader.read(help));
			} catch (ParserConfigurationException | SAXException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
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
