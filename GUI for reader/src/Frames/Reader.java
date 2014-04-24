package Frames;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class Reader {
    JTextArea output;
    JScrollPane scrollPane;
    JButton button;
    static int WIDTH = 1000;
    static int HEIGHT = 500;
 
    public JMenuBar createMenuBar() {
        
        JMenuBar menuBar = new JMenuBar();
 
        //BOOK DATA
        JButton menuBookData = new JButton("Данные о книге");     
        menuBookData.setMnemonic(KeyEvent.VK_A);
        
        menuBookData.addActionListener(new ActionListeners.DataEventListener());

        menuBar.add(menuBookData);
        
        //READING SETTINGS
        JButton menuReadSet = new JButton("Настройки чтения");     
        menuReadSet.setMnemonic(KeyEvent.VK_B);
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
        menuItemSearch.addActionListener(new ActionListeners.DataEventListener());

        
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
        
        //LIBRARY NAVIGATION
        JMenu menuLibNav = new JMenu("Навигация по библиотеке");     
        menuLibNav.setMnemonic(KeyEvent.VK_E);
        menuBar.add(menuLibNav);
        
        JMenuItem menuItemBack = new JMenuItem("Назад");
        menuLibNav.add(menuItemBack);
        
        JMenuItem menuItemAuthor = new JMenuItem("В папку автора");
        menuLibNav.add(menuItemAuthor);
        
        JMenuItem menuItemLib = new JMenuItem("В библиотеку");
        menuLibNav.add(menuItemLib);
        
        JMenuItem menuItemStart = new JMenuItem("На стартовую страницу");
        menuLibNav.add(menuItemStart);
 
        return menuBar;
    }
 
    public Container createContentPane() throws IOException {

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
 
        output = new JTextArea(5, 30);
//        output.setText(ReadFromFile.ReadTextFromFile.read("TextForReading.txt"));
        output.setEditable(false);
        output.setLineWrap(true);
        scrollPane = new JScrollPane(output);
        scrollPane.setSize(WIDTH, HEIGHT);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        contentPane.add(scrollPane, BorderLayout.CENTER);
 
        return contentPane;
    }
 


    public static void createAndShowGUI() throws IOException {

        JFrame frame = new JFrame("Лабиринт Мёнина");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Reader demo = new Reader();
        frame.setJMenuBar(demo.createMenuBar());
        frame.setContentPane(demo.createContentPane());
        frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}