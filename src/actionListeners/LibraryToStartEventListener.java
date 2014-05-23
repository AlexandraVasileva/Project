package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;

import frames.LibraryFrame;

public class LibraryToStartEventListener implements ActionListener {
	
	private frames.LibraryFrame lframe;
	private frames.StartPage sframe;

	public LibraryToStartEventListener (frames.LibraryFrame lframe, frames.StartPage sframe) {
		this.lframe = lframe;
		this.sframe = sframe;
	}

	public void actionPerformed(ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                lframe.frame.setVisible(false);
                
                sframe.last.removeActionListener(sframe.lastListener);
                sframe.lastListener = new actionListeners.LastEventListener(sframe, sframe.openbook.loadPreviousBook(sframe.saveway));
                sframe.last.addActionListener(sframe.lastListener);
                
				sframe.frame.setVisible(true);
            }
        });
	}
}