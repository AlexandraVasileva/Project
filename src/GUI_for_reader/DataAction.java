package GUI_for_reader;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class DataAction extends AbstractAction {

	public void actionPerformed(ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BookData.createAndShowGUI();
            }
        });
	}

}
