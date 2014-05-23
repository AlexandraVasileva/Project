package actionListeners;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class TextSearchOkEventListener implements ActionListener {
	
private frames.TextSearch tframe;
	
	public TextSearchOkEventListener (frames.TextSearch tframe) {
		this.tframe = tframe;
	}

	public void actionPerformed (ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            	// Search HERE.
            	
            	tframe.frame.setVisible(false);
            	
            }
        });
	}
}