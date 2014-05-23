package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;

public class SearchEventListener implements ActionListener {

	private frames.StartPage startframe;
	
	public SearchEventListener (frames.StartPage startframe) {
		this.startframe = startframe;
	}
	
	public void actionPerformed(ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
				frames.Search.getInstance(startframe).frame.setVisible(true);
            }
        });
	}
}