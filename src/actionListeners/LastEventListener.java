package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;

import frames.StartPage;

public class LastEventListener implements ActionListener {
	
	private frames.StartPage startframe;
	String bookname;

	public LastEventListener (frames.StartPage startframe, String bookname) {
		this.startframe = startframe;
		this.bookname = bookname;
	}

	public void actionPerformed(ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new frames.Reader(bookname, startframe);
				startframe.frame.setVisible(false);
            }
        });
	}
}