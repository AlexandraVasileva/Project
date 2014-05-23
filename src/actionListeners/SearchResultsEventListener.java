package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import books.*;

import javax.swing.JOptionPane;

public class SearchResultsEventListener implements ActionListener {
	
	private frames.StartPage startframe;
	private frames.LibraryFrame lframe;
	
	public SearchResultsEventListener (frames.StartPage startframe) {
		this.startframe = startframe;
	}
	
	public void actionPerformed(ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            	String how = (String)frames.Search.getInstance(startframe).howToSearch.getSelectedItem();
            	String what = (String)frames.Search.getInstance(startframe).whatToSearch.getText();
            	ArrayList<Book> listofbook;
            	String[] list;
            	
            	if(how.equals("Поиск по автору")) {
            		listofbook = startframe.openbook.searchForBook(what, startframe.openbook.getListOfBooks(), 1);
            		if(listofbook.size() == 0) {
                    	JOptionPane.showMessageDialog(frames.Search.getInstance(startframe), "Ничего не найдено");
            		} else {
            			list = startframe.openbook.listOfSmth(0, listofbook).toArray(new String[0]);
            			
            			lframe = frames.LibraryFrame.getInstance(list, startframe);
                        lframe.frame.setVisible(true);
                        lframe.displayedType = 0;
                        lframe.currentlist = listofbook;
                        frames.Search.getInstance(startframe).frame.setVisible(false);
                        startframe.frame.setVisible(false);
                        
            		}
            	}
            	if(how.equals("Поиск по названию")) {
            		listofbook = startframe.openbook.searchForBook(what, startframe.openbook.getListOfBooks(), 0);
            		if(listofbook.size() == 0) {
                    	JOptionPane.showMessageDialog(frames.Search.getInstance(startframe), "Ничего не найдено");
            		} else {
            			list = startframe.openbook.listOfSmth(0, listofbook).toArray(new String[0]);
            			
            			lframe = frames.LibraryFrame.getInstance(list, startframe);
                        lframe.frame.setVisible(true);
                        lframe.displayedType = 0;
                        lframe.currentlist = listofbook;
                        frames.Search.getInstance(startframe).frame.setVisible(false);
                        startframe.frame.setVisible(false);
                        
            		}
            	}
            	if(how.equals("Поиск по серии")) {
            		listofbook = startframe.openbook.searchForBook(what, startframe.openbook.getListOfBooks(), 2);
            		if(listofbook.size() == 0) {
                    	JOptionPane.showMessageDialog(frames.Search.getInstance(startframe), "Ничего не найдено");
            		} else {
            			list = startframe.openbook.listOfSmth(0, listofbook).toArray(new String[0]);
            			
            			lframe = frames.LibraryFrame.getInstance(list, startframe);
                        lframe.frame.setVisible(true);
                        lframe.displayedType = 0;
                        lframe.currentlist = listofbook;
                        frames.Search.getInstance(startframe).frame.setVisible(false);
                        startframe.frame.setVisible(false);
                        
            		}
            	}
				if(how.equals("Общий поиск")) {
					listofbook = startframe.openbook.searchForBook(what, startframe.openbook.getListOfBooks());
            		if(listofbook.size() == 0) {
                    	JOptionPane.showMessageDialog(frames.Search.getInstance(startframe), "Ничего не найдено");
            		} else {
            			list = startframe.openbook.listOfSmth(0, listofbook).toArray(new String[0]);
            			
            			lframe = frames.LibraryFrame.getInstance(list, startframe);
                        lframe.frame.setVisible(true);
                        lframe.displayedType = 0;
                        lframe.currentlist = listofbook;
                        frames.Search.getInstance(startframe).frame.setVisible(false);
                        startframe.frame.setVisible(false);
                        
            		}
				}
            }
        });
	}
}