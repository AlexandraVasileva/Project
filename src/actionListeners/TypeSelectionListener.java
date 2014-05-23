package actionListeners;

import java.io.IOException;
import java.util.*;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import frames.LibraryFrame;
import books.*;

public class TypeSelectionListener implements ListSelectionListener{
	
	private frames.LibraryFrame frame;
	private frames.StartPage sframe;

	public TypeSelectionListener (frames.LibraryFrame frame, frames.StartPage sframe) {
		this.frame = frame;
		this.sframe = sframe;
	}
	
	public void valueChanged(ListSelectionEvent e) {
		JList list = (JList<String>)e.getSource();
		
		if ((e.getValueIsAdjusting() == false) && (list.getSelectedIndex() >= 0)) {
			
			if (frame.displayedType == 0){
				ArrayList<Book> temp = new ArrayList<>();
				temp = sframe.openbook.searchForBook((String)list.getSelectedValue(), frame.currentlist, 0);
				new frames.Reader(temp.get(0).getAdress(), sframe);
				frame.frame.setVisible(false);
			}
			
			if (frame.displayedType == 1){		//if author is displayed, return list of books
				frame.currentlist = sframe.openbook.shortList(1, (String)list.getSelectedValue(), frame.currentlist);
				frame.setList(sframe.openbook.listOfSmth(0, frame.currentlist).toArray(new String[0]));
				frame.displayedType = 0;
			}
			
			if (frame.displayedType == 2){		//if series is displayed, return list of books as well
				frame.currentlist = sframe.openbook.shortList(2, (String)list.getSelectedValue(), frame.currentlist);
				frame.setList(sframe.openbook.listOfSmth(0, frame.currentlist).toArray(new String[0]));
				frame.displayedType = 0;
			}
			
			if (frame.displayedType == 3){		//if genre is displayed, return list of authors
				frame.currentlist = sframe.openbook.shortList(3, (String)list.getSelectedValue(), frame.currentlist);
				frame.setList(sframe.openbook.listOfSmth(1, frame.currentlist).toArray(new String[0]));
				frame.displayedType = 1;
			}
			
			list.clearSelection();
			
		}
	}

}