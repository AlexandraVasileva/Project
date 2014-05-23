package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

import books.*;
import static java.nio.file.StandardCopyOption.*;


public class Synchronize extends JFrame implements ActionListener {

	private int WIDTH = 600;
	private int HEIGHT = 450;
	private Color lightlightgrey = new Color(224, 218, 230);
	
	JButton sync;
	JFileChooser directoryChoose;
	
	public frames.StartPage sframe;
	
	public Synchronize(frames.StartPage sframe){
		
		this.sframe = sframe;
		
		JFrame frame = new JFrame("Синхронизация");
        frame.setContentPane(createContentPane());
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
		
	}
	
	public JPanel createContentPane() {
		
		JPanel contentPane = new JPanel();
    	BorderLayout layout = new BorderLayout();
        contentPane.setLayout(layout);
        
        LookAndFeel previousLF = UIManager.getLookAndFeel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            directoryChoose = new JFileChooser();
            sync = new JButton("Добавить книги из библиотеки в указанную папку");
            UIManager.setLookAndFeel(previousLF);
        } catch (Exception e) {
        	e.printStackTrace();
        }

        directoryChoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        directoryChoose.setControlButtonsAreShown(false);     
        
        sync.addActionListener(this);

        
        JPanel buttons = new JPanel();
        buttons.add(sync);
        contentPane.add(buttons, BorderLayout.SOUTH);
        contentPane.add(directoryChoose, BorderLayout.CENTER);
        
        return contentPane;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
        if (e.getSource() == sync) {
        	
        	try{
                File dir = directoryChoose.getSelectedFile();

                int i;
                Book one;
                File authorDir;
                for(i = 0; i < sframe.openbook.getListOfBooks().size(); i++) {
                	one = sframe.openbook.getListOfBooks().get(i);
                	
                	Path source = Paths.get(one.getAdress());
                	Path dest = Paths.get(dir.getAbsolutePath() + "\\" + one.getAuthor() + "\\" + one.getName() + one.getAdress().substring(one.getAdress().lastIndexOf('.')));
                	
                	authorDir = new File(dir.getAbsolutePath() + "\\" + one.getAuthor());
                	authorDir.mkdir();
             
                	
						Files.copy(source, dest, REPLACE_EXISTING);
				
                }
        	}catch(Exception e1){
                e1.printStackTrace();
            }
            }

        } 
    }