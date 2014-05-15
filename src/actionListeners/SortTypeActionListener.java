package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;

public class SortTypeActionListener implements ActionListener{

	    public void actionPerformed(ActionEvent e) {
	        JComboBox cb = (JComboBox)e.getSource();
	       
	        String temp = (String)cb.getSelectedItem(); // this is the type
	        
			String[] list1 = {temp, temp, temp}; // just a test
			
			frames.LibraryFrame.setList(list1);
			
			System.out.println(list1[1]);
			System.out.println("IN LIBRARY " + frames.LibraryFrame.justATest[1]);
	    }
}