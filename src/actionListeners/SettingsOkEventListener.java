package actionListeners;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mode.*;

public class SettingsOkEventListener implements ActionListener {
	
	private frames.ReadSettings rsframe; 
	private frames.Reader rframe;
		
		public SettingsOkEventListener (frames.ReadSettings rsframe, frames.Reader rframe) {
			this.rsframe = rsframe;
			this.rframe = rframe;
		}

	public void actionPerformed (ActionEvent e) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	try{
            		String name = (String)rsframe.mode.getSelectedItem();
            		String font = (String)rsframe.font.getSelectedItem();
            		String sizestr = (String)rsframe.size.getText();
            		Mode mode = rframe.startframe.openbook.searchForMode(name);
            		mode.setFont(font);
            		if((!sizestr.equals(""))&&(sizestr != null)) {
            			mode.setSizeOfType(Integer.parseInt(sizestr));
            		}
            		rframe.startframe.openbook.saveModes(rframe.startframe.saveway);
            	
            		int modenum = 0;
            		if(name.equals("Художественный")) modenum = 0;
            		if(name.equals("Рабочий")) modenum = 1;
            		if(name.equals("Пользовательский")) modenum = 2;

            		rframe.startframe.openbook.searchForBook(rframe.bookname, rframe.startframe.openbook.getListOfBooks(), 4).get(0).setMode(modenum);
            		rframe.startframe.openbook.save(rframe.startframe.saveway);
            		rframe.contentPane.output.setFont(new Font(mode.getFont(), Font.PLAIN, mode.getSizeOfType()));
            		rframe.contentPane.output.repaint();
	
            		}catch(Exception e){
            			e.printStackTrace();
            		}
            	
            	rsframe.frame.setVisible(false);
            	
            }
        });
	}
}