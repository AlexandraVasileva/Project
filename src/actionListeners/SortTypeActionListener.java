package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import frames.LibraryFrame;

public class SortTypeActionListener implements ActionListener {

	private frames.LibraryFrame frame;
	private frames.StartPage sframe;


	public SortTypeActionListener(LibraryFrame frame, frames.StartPage sframe) {
		this.frame = frame;
		this.sframe = sframe;
	}

	public void actionPerformed(ActionEvent e) {
	        JComboBox cb = (JComboBox)e.getSource();
	       
	        String temp = (String)cb.getSelectedItem(); // this is the type
	        int code = 0;
	        switch (temp) {
	        	case "Жанр": code = 3; break;
	        	case "Автор": code = 1; break;
	        	case "Серия": code = 2; break;
	        }
	        
	        frame.displayedType = code;
			String[] list1 = sframe.openbook.listOfSmth(code, frame.currentlist).toArray(new String[0]); // just a test
			frame.setList(list1);
			
	    }
}