package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ToLibraryEventListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
					frames.Library.createAndShowGUI();
					frames.StartPage.frame.setVisible(false);
				} catch (IOException e) {
				}
            }
        });
	}
}