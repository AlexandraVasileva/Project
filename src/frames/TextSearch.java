package frames;

import java.awt.*;
import javax.swing.*;

public class TextSearch extends JFrame{
	
    private int WIDTH = 250;
    private int HEIGHT = 150;
	
	public TextSearch(){
		JFrame frame = new JFrame("Поиск по тексту");
		frame.setContentPane(createContentPane());
        frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
	}
	
	private Container createContentPane() {
    	
        JPanel contentPane = new JPanel();
        
        GridLayout dataLayout = new GridLayout(0,1);
        contentPane.setLayout(dataLayout);
        
        JLabel goToMarkLabel = new JLabel("Поиск по тексту:");
        contentPane.add(goToMarkLabel);
        
        JTextField goToMark = new JTextField("", 10);
        contentPane.add(goToMark);
        
        JButton toMark = new JButton("OK");
        contentPane.add(toMark);
        
        return contentPane;
	
    }
    
	public static void createAndShowGUI() {
        new TextSearch();
    }
	
}
