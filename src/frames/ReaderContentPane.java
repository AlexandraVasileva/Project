package frames;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import mode.Mode;
import workWithInternet.WorkWithWeb;
import readFromFile.ReadTextFromFile;

public class ReaderContentPane extends JPanel {

	private int WIDTH = 1000;
	private int HEIGHT = 500;
	public String selectedText = null;
	public JTextPane output;
	private JScrollPane scrollPane;
	public JPanel contentPane;
	public frames.Reader rframe;
	public int nummode;

	public ReaderContentPane(frames.Reader rframe, String bookname) throws IOException,
			ParserConfigurationException, SAXException {
		this.rframe = rframe;
		contentPane = new JPanel(new BorderLayout());
		contentPane.setOpaque(true);
		output = new JTextPane();
		contentPane.setFocusable(true);
	
		output.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
		Mode mode;
		nummode = rframe.startframe.openbook.searchForBook(rframe.bookname, rframe.startframe.openbook.getListOfBooks(), 4).get(0).getMode();
		mode = rframe.startframe.openbook.getListOfModes().get(nummode);

		output.setFont(new Font(mode.getFont(), Font.PLAIN, mode.getSizeOfType() ));
		add(BorderLayout.CENTER, output);

		output.addKeyListener(new actionListeners.OutputKeyListener(this));

		output.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent me) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
				String Text = output.getSelectedText();
				selectedText = Text;
			}

			public void mouseExited(MouseEvent e) {
			}
		});
		
		ReadTextFromFile reader = new ReadTextFromFile();
		String text = "";
		if (reader.getFileExtention(bookname).equals("txt")) {
			text = reader.readTxt(bookname);
		} else {
			if (reader.getFileExtention(bookname).equals("fb2")) {
				output.setContentType("text/html");
				text = reader.readFb2(bookname);
			} else {
				text = "This format is not supported";
			}
		}
		
		output.setText(text);

		output.setCaretPosition(0);
		output.setEditable(false);

		scrollPane = new JScrollPane(output);
		scrollPane.setSize(WIDTH, HEIGHT);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		
	}
	
}
