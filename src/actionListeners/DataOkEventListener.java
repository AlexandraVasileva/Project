package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import books.*;

public class DataOkEventListener implements ActionListener {
	
private frames.BookData dframe; 
private frames.Reader rframe;
	
	public DataOkEventListener (frames.BookData dframe, frames.Reader rframe) {
		this.dframe = dframe;
		this.rframe = rframe;

	}

	public void actionPerformed (ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

            	//Saving the book data
            	
            	Book curbook = rframe.startframe.openbook.searchForBook(rframe.bookname, rframe.startframe.openbook.getListOfBooks(), 4).get(0);
            	String temp;
            	temp = dframe.author.getText();
            	if((!temp.equals(""))&&(temp != null)) curbook.setAuthor(temp);
            	temp = dframe.title.getText();
            	if((!temp.equals(""))&&(temp != null)) curbook.setName(temp);
            	temp = dframe.genre.getText();
            	if((!temp.equals(""))&&(temp != null)) curbook.setGenre(temp);
            	temp = dframe.series.getText();
            	if((!temp.equals(""))&&(temp != null)) curbook.setSeries(temp);
            	rframe.startframe.openbook.save(rframe.startframe.saveway);

            	dframe.frame.setVisible(false);
            	
            }
        });
	}
}