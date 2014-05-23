package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SynchronizeEventListener implements ActionListener{

	public frames.StartPage sframe;
	
	public SynchronizeEventListener(frames.StartPage sframe){
		this.sframe = sframe;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		new frames.Synchronize(sframe);
		
	}
}