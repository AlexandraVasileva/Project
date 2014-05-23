package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ReadSettingsEventListener implements ActionListener {

	private frames.StartPage startframe;
	private frames.Reader rframe;
	
	public ReadSettingsEventListener(frames.Reader rframe) {
		this.rframe = rframe;
	}
	
	public void actionPerformed(ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new frames.ReadSettings(rframe);
            }
        });
	}
}