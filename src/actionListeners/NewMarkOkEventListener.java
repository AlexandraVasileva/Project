package actionListeners;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class NewMarkOkEventListener implements ActionListener {
	
private frames.NewMark mframe;
	
	public NewMarkOkEventListener (frames.NewMark mframe) {
		this.mframe = mframe;
	}

	public void actionPerformed (ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            	// Set new mark HERE.
            	
            	mframe.frame.setVisible(false);
            	
            }
        });
	}
}