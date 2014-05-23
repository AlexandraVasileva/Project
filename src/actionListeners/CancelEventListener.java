package actionListeners;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

public class CancelEventListener {
	
	private JFrame frame;
	
	public CancelEventListener (JFrame frame) {
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) throws Exception{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(false);
            }
        });
	}

}
