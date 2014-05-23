package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReaderToStartEventListener implements ActionListener {

		private frames.Reader rframe;
		private frames.StartPage sframe;

		public ReaderToStartEventListener (frames.Reader rframe, frames.StartPage sframe) {
			this.rframe = rframe;
			this.sframe = sframe;
		}

	public void actionPerformed(ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                rframe.frame.setVisible(false);
                
                sframe.last.removeActionListener(sframe.lastListener);
                sframe.lastListener = new actionListeners.LastEventListener(sframe, sframe.openbook.loadPreviousBook(sframe.saveway));
                sframe.last.addActionListener(sframe.lastListener);
                
				sframe.frame.setVisible(true);
            }
        });
	}
}