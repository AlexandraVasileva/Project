package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpEventListener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		
		new frames.Help();
		
	}
}