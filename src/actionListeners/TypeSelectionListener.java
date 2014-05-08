package actionListeners;

import java.io.IOException;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TypeSelectionListener implements ListSelectionListener{

	public void valueChanged(ListSelectionEvent e) {
		JList list = (JList<String>)e.getSource();
		if (e.getValueIsAdjusting() == false) {
			System.out.println(list.getSelectedValue());
			try {
				frames.Reader.createAndShowGUI("TestLibrary/"+(String)list.getSelectedValue()+ ".txt");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}