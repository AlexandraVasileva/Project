package frames;

import java.awt.*;
import java.awt.event.*;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.*;

import ebook.*;
import ebook.parser.*;

public class Reader  extends JFrame{
    
	public static JFrame frame;
	
	private int WIDTH = 1000;
	private int HEIGHT = 500;
	
	public Reader(String bookname) {
		frame = new JFrame("Текущая книга");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setJMenuBar(createMenuBar());
		try {
			frame.setContentPane(frames.ReaderContentPane.createContentPane(bookname));
		} catch (IOException e) {
		}
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
 
    public JMenuBar createMenuBar() {
        
        JMenuBar menuBar = new JMenuBar();
 
        //BOOK DATA
        JButton menuBookData = new JButton("Данные о книге");     
        menuBookData.setMnemonic(KeyEvent.VK_A);
        
        menuBookData.addActionListener(new actionListeners.DataEventListener());
        menuBookData.setBorderPainted(false);
        menuBookData.setFocusPainted(false);
        menuBar.add(menuBookData);
        
        //READING SETTINGS
        JButton menuReadSet = new JButton("Настройки чтения");     
        menuReadSet.setMnemonic(KeyEvent.VK_B);
        menuReadSet.addActionListener(new actionListeners.ReadSettingsEventListener());
        menuReadSet.setBorderPainted(false);
        menuBar.add(menuReadSet);
        
        //BOOK TOOLS
        JMenu menuBookTools = new JMenu("Инструменты чтения");     
        menuBookTools.setMnemonic(KeyEvent.VK_C);
        menuBar.add(menuBookTools);
        
        JMenuItem menuItemBookmark = new JMenuItem("Добавить закладку");
        menuBookTools.add(menuItemBookmark);
        
        JMenuItem menuItemNote = new JMenuItem("Добавить заметку");
        menuBookTools.add(menuItemNote);
        
        menuBookTools.addSeparator();
        
        JMenuItem menuItemSearch = new JMenuItem("Поиск по книге");
        menuItemSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.ALT_MASK));
        menuItemSearch.addActionListener(new actionListeners.TextSearchEventListener());

        
        menuBookTools.add(menuItemSearch);

        //BOOK NAVIGATION
        JMenu menuBookNav = new JMenu("Навигация по книге");     
        menuBookNav.setMnemonic(KeyEvent.VK_D);
        menuBar.add(menuBookNav);
        
        JMenuItem menuItemBeginning = new JMenuItem("В начало");
        menuBookNav.add(menuItemBeginning);
        
        JMenuItem menuItemEnd = new JMenuItem("В конец");
        menuBookNav.add(menuItemEnd);
        
        JMenuItem menuItemBookmarkGo = new JMenuItem("Перейти к закладке...");
        menuBookNav.add(menuItemBookmarkGo);
        menuItemBookmarkGo.addActionListener(new actionListeners.GoToMarkEventListener());
        
        //LIBRARY NAVIGATION
        JMenu menuLibNav = new JMenu("Навигация по библиотеке");     
        menuLibNav.setMnemonic(KeyEvent.VK_E);
        menuBar.add(menuLibNav);
        
        JMenuItem menuItemAuthor = new JMenuItem("В папку автора");
        menuLibNav.add(menuItemAuthor);
        
        JMenuItem menuItemLib = new JMenuItem("В библиотеку");
        menuLibNav.add(menuItemLib);
        
        JMenuItem menuItemStart = new JMenuItem("На стартовую страницу");
        menuItemStart.addActionListener(new actionListeners.ReaderToStartEventListener());
        menuLibNav.add(menuItemStart);
 
        return menuBar;
    }
 

    public static void createAndShowGUI(String bookname) throws IOException {
    	new Reader(bookname);
    }
}