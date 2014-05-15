package frames;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import WorkWithInternet.WorkWithWeb;
import readFromFile.ReadTextFromFile;

public class ReaderContentPane extends JFrame {
		
		private int WIDTH = 1000;
		private int HEIGHT = 500;
		private String selectedText= null;
		private JTextPane output;
		private JScrollPane scrollPane;		
		public JPanel contentPane;
	
		public ReaderContentPane() throws IOException, ParserConfigurationException, SAXException{
	        contentPane = new JPanel(new BorderLayout());
	        contentPane.setOpaque(true);        
			output = new JTextPane();
			 contentPane.setFocusable(true);
	        output.setContentType("text/html");
	        
	        add(BorderLayout.CENTER, output);
	        
	        output.addKeyListener(new KeyAdapter() {
	            public void keyPressed(KeyEvent e) {
	                int key = e.getKeyCode();
	                try {
	                	if (key == KeyEvent.VK_D) {
	              		
	                		//окно с переводом!!!
	                		
	                		System.out.println(WorkWithWeb.dictionary("ru", "en", selectedText));		          		
	                		selectedText=null;
						} 
	                	else{
	                		if (key == KeyEvent.VK_W) {
		                		WorkWithWeb.SearchInfo(selectedText);		          		
		                		selectedText=null;
	                		}            		
	                	}
						
	                } catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
	                }
	            }
	        });
	        
	        output.setText((ReadTextFromFile.read("Человек толпы.fb2")) );
	     
	        output.addMouseListener(new MouseListener() {
	            public void mouseClicked(MouseEvent me) {
	            }
	            public void mouseEntered(MouseEvent e) {
	            }
	            public void mousePressed(MouseEvent e) {
	            }
	            public void mouseReleased(MouseEvent e) {
	                String Text = output.getSelectedText();   
	                selectedText = Text;          
	            }	            
	            public void mouseExited(MouseEvent e){
	            }
	        });
	        
	    
	        
	        output.setEditable(false);
	        
	        
	        scrollPane = new JScrollPane(output);
	        scrollPane.setSize(WIDTH, HEIGHT);
	        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	        
	        contentPane.add(scrollPane, BorderLayout.CENTER);
		}
		
	    public static Container createContentPane() throws IOException, ParserConfigurationException, SAXException {
	        return (new ReaderContentPane().contentPane);
	    }
	}
	
	
	
  