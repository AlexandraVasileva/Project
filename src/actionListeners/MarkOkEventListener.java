package actionListeners;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class MarkOkEventListener implements ActionListener {
	
private frames.GoToMark mframe;
	
	public MarkOkEventListener (frames.GoToMark mframe) {
		this.mframe = mframe;
	}

	public void actionPerformed (ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            	// Check the mark and go HERE.
            	
            	mframe.frame.setVisible(false);
            	
            }
        });
	}
}