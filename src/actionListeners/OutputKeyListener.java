package actionListeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import workWithInternet.WorkWithWeb;


public class OutputKeyListener implements KeyListener{
	
	private frames.ReaderContentPane pane;
	
	int MAX = 500;
	
	public OutputKeyListener(frames.ReaderContentPane pane){
		this.pane = pane;
	}
	public void keyPressed(KeyEvent e) {
			WorkWithWeb workerWithWeb = new WorkWithWeb();
			int key = e.getKeyCode();
			try {
				if (key == KeyEvent.VK_D) {
					
					// Add a translation window

					//System.out.println(workerWithWeb.dictionary("ru", "en", pane.selectedText));
					String translate = pane.selectedText;
					
					if((translate.length() > MAX)) {
						JOptionPane.showMessageDialog(pane.rframe, "—лишком длинный текст дл€ перевода");
					}else{
						if(translate.contains("\n")){
							JOptionPane.showMessageDialog(pane.rframe, "“екст не должен содержать переноса строки");
						}else{
						new frames.Dictionary(workerWithWeb.dictionary("ru", "en", translate));
					}
				}
					
					pane.selectedText = null;
				} else {
					if (key == KeyEvent.VK_W) {
						workerWithWeb.searchInfo(pane.selectedText);
						pane.selectedText = null;
					} else {
						if (key == KeyEvent.VK_G) {
							workerWithWeb.google(pane.selectedText);
						}
					}
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			} catch (ParserConfigurationException e1) {
				e1.printStackTrace();
			} catch (SAXException e1) {
				e1.printStackTrace();
			}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	};

	
}
