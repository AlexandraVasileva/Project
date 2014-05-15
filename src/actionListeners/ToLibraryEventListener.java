package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ToLibraryEventListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                	String[] temp = {"default", "default", "default"}; // sort by genre! "sf", "non-sf", "fantasy", ...
                	frames.LibraryFrame.createAndShowGUI(temp);
    				//frames.LibraryFrame.setList(temp);
					frames.StartPage.frame.setVisible(false);
				} catch (IOException e) {
				}
            }
        });
	}
}