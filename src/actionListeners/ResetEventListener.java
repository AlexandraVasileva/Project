package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;

import frames.LibraryFrame;

public class ResetEventListener implements ActionListener{
	
	private frames.LibraryFrame lframe;
	private frames.StartPage sframe;

	public ResetEventListener (LibraryFrame lframe, frames.StartPage sframe) {
		this.lframe = lframe;
		this.sframe = sframe;
	}
	
	public void actionPerformed(ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String[] temp = sframe.openbook.listOfSmth(0, sframe.openbook.getListOfBooks()).toArray(new String[0]); // sort by genre! "sf", "non-sf", "fantasy", ...           
                
                lframe = frames.LibraryFrame.getInstance(temp, sframe);
                
                lframe.displayedType = 0;
                lframe.currentlist = sframe.openbook.getListOfBooks();

                lframe.setList(sframe.openbook.listOfSmth(0, lframe.currentlist).toArray(new String[0]));
                lframe.frame.setVisible(true);
				sframe.frame.setVisible(false);
            }
        });
		
	}
}
