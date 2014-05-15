package actionListeners;

import java.io.IOException;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TypeSelectionListener implements ListSelectionListener{

	public void valueChanged(ListSelectionEvent e) {
		JList list = (JList<String>)e.getSource();
		
		if (e.getValueIsAdjusting() == false) {
			// if depending on displayed type
			
			if (frames.LibraryFrame.displayedType == 0){
				//Reader(book)
			}
			
			if (frames.LibraryFrame.displayedType == 1){		//if author is displayed, return list of books
				frames.LibraryFrame.currentlist = frames.LibraryFrame.temp.shortList(1, (String)list.getSelectedValue(), frames.LibraryFrame.currentlist);
				frames.LibraryFrame.setList(frames.LibraryFrame.temp.listOfSmth(0, frames.LibraryFrame.currentlist).toArray(new String[0]));
			}
			
			if (frames.LibraryFrame.displayedType == 2){		//if series is displayed, return list of books as well
				frames.LibraryFrame.currentlist = frames.LibraryFrame.temp.shortList(2, (String)list.getSelectedValue(), frames.LibraryFrame.currentlist);
				frames.LibraryFrame.setList(frames.LibraryFrame.temp.listOfSmth(0, frames.LibraryFrame.currentlist).toArray(new String[0]));
			}
			
			if (frames.LibraryFrame.displayedType == 3){		//if genre is displayed, return list of authors
				frames.LibraryFrame.currentlist = frames.LibraryFrame.temp.shortList(3, (String)list.getSelectedValue(), frames.LibraryFrame.currentlist);
				frames.LibraryFrame.setList(frames.LibraryFrame.temp.listOfSmth(1, frames.LibraryFrame.currentlist).toArray(new String[0]));
			}
		}
	}

}