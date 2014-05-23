package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToLibraryEventListener implements ActionListener {
	
	private frames.StartPage startframe;
	private frames.LibraryFrame lframe;
	
	public ToLibraryEventListener(frames.StartPage startframe) {
		this.startframe = startframe;
	}

	public void actionPerformed(ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String[] temp = startframe.openbook.listOfSmth(0, startframe.openbook.getListOfBooks()).toArray(new String[0]); // sort by genre! "sf", "non-sf", "fantasy", ...           
                
                lframe = frames.LibraryFrame.getInstance(temp, startframe);
                lframe.frame.setVisible(true);
                lframe.displayedType = 0;
                lframe.currentlist = startframe.openbook.getListOfBooks();
                
				startframe.frame.setVisible(false);
            }
        });
	}
}