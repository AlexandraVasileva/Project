package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataEventListener implements ActionListener {
	
	private frames.StartPage startframe;
	private frames.Reader rframe;
	
	public DataEventListener(frames.StartPage startframe, frames.Reader rframe) {
		this.startframe = startframe;
		this.rframe = rframe;
	}

	public void actionPerformed(ActionEvent e){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new frames.BookData(rframe);
            }
        });
	}
}