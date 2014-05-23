package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import frames.*;

public class CancelEventListener {
	
	private JFrame frame;
	
	public CancelEventListener (JFrame frame) {
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(false);
            }
        });
	}

}
