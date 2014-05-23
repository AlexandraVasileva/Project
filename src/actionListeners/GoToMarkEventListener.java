package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoToMarkEventListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new frames.GoToMark();
            }
        });
	}
	
}