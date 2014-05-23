package frames;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import readFromFile.ReadTextFromFile;

public class Dictionary extends JFrame{
	
	public JFrame frame;
	
	private int WIDTH = 500;
	private int HEIGHT = 300;
	
	public Dictionary (String translation) {

		frame = new JFrame("Перевод");
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		
		JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
        
		JTextPane output = new JTextPane();

        output.setText(translation);
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