package frames;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Reader  extends JFrame{
    
	public JFrame frame;
	public frames.StartPage startframe;
	public frames.ReaderContentPane contentPane;
	private int WIDTH = 1000;
	private int HEIGHT = 500;
	private Color lightgrey = new Color(206, 206, 206);
	private Color lightlightgrey = new Color(224, 218, 230);
	
	public String bookname;
	
	public Reader(String bookname, frames.StartPage startframe) {
		this.bookname = bookname;
		this.startframe = startframe;
		startframe.openbook.savePreviousBook(startframe.saveway, bookname);
		frame = new JFrame(startframe.openbook.searchForBook(bookname, startframe.openbook.getListOfBooks(), 4).get(0).getName());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setJMenuBar(createMenuBar());
		try {
			contentPane = new frames.ReaderContentPane(this, bookname);
			frame.setContentPane(contentPane.contentPane);
		} catch (IOException | ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}
	
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void setLabelLF(JComponent component){
		component.setBackground(lightgrey);
		component.setForeground(Color.darkGray);
		component.setFont(new Font("sansserif", Font.PLAIN, 14));
	}
	
	private void setFieldLF(JComponent component){
		component.setBackground(lightlightgrey);
		component.setForeground(Color.darkGray);
		component.setFont(new Font("sansserif", Font.PLAIN, 12));
	}

 
    public JMenuBar createMenuBar() {
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(lightgrey);
 
        //BOOK DATA
        JButton menuBookData = new JButton("Данные о книге");     
        menuBookData.setMnemonic(KeyEvent.VK_A);   
        menuBookData.addActionListener(new actionListeners.DataEventListener(startframe, this));
        menuBookData.setBorderPainted(false);
        menuBookData.setFocusPainted(false);
        setLabelLF(menuBookData);
        menuBar.add(menuBookData);
        
        //READING SETTINGS
        JButton menuReadSet = new JButton("Настройки чтения");     
        menuReadSet.setMnemonic(KeyEvent.VK_B);
        menuReadSet.addActionListener(new actionListeners.ReadSettingsEventListener(this
        		));
        menuReadSet.setBorderPainted(false);
        setLabelLF(menuReadSet);
        menuBar.add(menuReadSet);

        
        //LIBRARY NAVIGATION
        JMenu menuLibNav = new JMenu("Навигация по библиотеке");     
        menuLibNav.setMnemonic(KeyEvent.VK_E);
        menuLibNav.setMnemonic(KeyEvent.VK_D);
        setLabelLF(menuLibNav);
        menuBar.add(menuLibNav);
        
        JMenuItem menuItemLib = new JMenuItem("В библиотеку");
        setFieldLF(menuItemLib);
        String[] defaultlist = startframe.openbook.listOfSmth(0, startframe.openbook.getListOfBooks()).toArray(new String[0]);
        
        menuItemLib.addActionListener(new actionListeners.ReaderToLibraryEventListener(defaultlist, startframe, this));
        menuLibNav.add(menuItemLib);
        
        JMenuItem menuItemStart = new JMenuItem("На стартовую страницу");
        setFieldLF(menuItemStart);
        menuItemStart.addActionListener(new actionListeners.ReaderToStartEventListener(this, this.startframe));
        menuLibNav.add(menuItemStart);
 
        return menuBar;
    }

}