package frames;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import readFromFile.ReadTextFromFile;

public class ReaderContentPane {
	
	private int WIDTH = 1000;
	private int HEIGHT = 500;
	private JTextPane output;
	private JScrollPane scrollPane;
	
	public JPanel contentPane;
	
	public ReaderContentPane() throws IOException{

        contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
        
		output = new JTextPane();
        output.setContentType("text/html");
        output.setText("<title><p>����� �������</p><p>��������� �����</p></title>");
        output.setEditable(false);
        
        scrollPane = new JScrollPane(output);
        scrollPane.setSize(WIDTH, HEIGHT);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        contentPane.add(scrollPane, BorderLayout.CENTER);
	}
	
    public static Container createContentPane() throws IOException {
        return (new ReaderContentPane().contentPane);
    }
}
