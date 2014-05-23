package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReaderToLibraryEventListener implements ActionListener {
	
	private String[] list;
	private frames.StartPage startframe;
	private frames.Reader rframe;

	public ReaderToLibraryEventListener(String[] list, frames.StartPage startframe, frames.Reader rframe) {
		this.list = list;
		this.startframe = startframe;
		this.rframe = rframe;
	}

	public void actionPerformed(ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
				frames.LibraryFrame.getInstance(list, startframe).frame.setVisible(true);
				rframe.frame.setVisible(false);
            }
        });
	}
}