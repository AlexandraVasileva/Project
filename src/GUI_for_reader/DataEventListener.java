package GUI_for_reader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataEventListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BookData.createAndShowGUI();
            }
        });
	}
	
}
