package actionListeners;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class NewNoteOkEventListener implements ActionListener {
	
private frames.NewNote nframe;
	
	public NewNoteOkEventListener (frames.NewNote nframe) {
		this.nframe = nframe;
	}

	public void actionPerformed (ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            	// Set new note HERE.
            	
            	nframe.frame.setVisible(false);
            	
            }
        });
	}
}