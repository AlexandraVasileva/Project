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
		frame = new JFrame("������� �����");
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
        JButton menuBookData = new JButton("������ � �����");     
        menuBookData.setMnemonic(KeyEvent.VK_A);
        
        menuBookData.addActionListener(new actionListeners.DataEventListener());
        menuBookData.setBorderPainted(false);
        menuBookData.setFocusPainted(false);
        menuBar.add(menuBookData);
        
        //READING SETTINGS
        JButton menuReadSet = new JButton("��������� ������");     
        menuReadSet.setMnemonic(KeyEvent.VK_B);
        menuReadSet.addActionListener(new actionListeners.ReadSettingsEventListener());
        menuReadSet.setBorderPainted(false);
        menuBar.add(menuReadSet);
        
        //BOOK TOOLS
        JMenu menuBookTools = new JMenu("����������� ������");     
        menuBookTools.setMnemonic(KeyEvent.VK_C);
        menuBar.add(menuBookTools);
        
        JMenuItem menuItemBookmark = new JMenuItem("�������� ��������");
        menuBookTools.add(menuItemBookmark);
        
        JMenuItem menuItemNote = new JMenuItem("�������� �������");
        menuBookTools.add(menuItemNote);
        
        menuBookTools.addSeparator();
        
        JMenuItem menuItemSearch = new JMenuItem("����� �� �����");
        menuItemSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.ALT_MASK));
        menuItemSearch.addActionListener(new actionListeners.TextSearchEventListener());

        
        menuBookTools.add(menuItemSearch);

        //BOOK NAVIGATION
        JMenu menuBookNav = new JMenu("��������� �� �����");     
        menuBookNav.setMnemonic(KeyEvent.VK_D);
        menuBar.add(menuBookNav);
        
        JMenuItem menuItemBeginning = new JMenuItem("� ������");
        menuBookNav.add(menuItemBeginning);
        
        JMenuItem menuItemEnd = new JMenuItem("� �����");
        menuBookNav.add(menuItemEnd);
        
        JMenuItem menuItemBookmarkGo = new JMenuItem("������� � ��������...");
        menuBookNav.add(menuItemBookmarkGo);
        menuItemBookmarkGo.addActionListener(new actionListeners.GoToMarkEventListener());
        
        //LIBRARY NAVIGATION
        JMenu menuLibNav = new JMenu("��������� �� ����������");     
        menuLibNav.setMnemonic(KeyEvent.VK_E);
        menuBar.add(menuLibNav);
        
        JMenuItem menuItemAuthor = new JMenuItem("� ����� ������");
        menuLibNav.add(menuItemAuthor);
        
        JMenuItem menuItemLib = new JMenuItem("� ����������");
        menuLibNav.add(menuItemLib);
        
        JMenuItem menuItemStart = new JMenuItem("�� ��������� ��������");
        menuItemStart.addActionListener(new actionListeners.ReaderToStartEventListener());
        menuLibNav.add(menuItemStart);
 
        return menuBar;
    }
 

    public static void createAndShowGUI(String bookname) throws IOException {
    	new Reader(bookname);
    }
}