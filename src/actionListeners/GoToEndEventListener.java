package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoToEndEventListener implements ActionListener {
	private frames.ReaderContentPane contentPane;
	public GoToEndEventListener(frames.ReaderContentPane contentPane){
		this.contentPane = contentPane;
	}
	public void actionPerformed(ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	contentPane.output.setCaretPosition(contentPane.output.getText().length());
            }
        });
	}
}