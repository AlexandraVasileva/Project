import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class MenuLookDemo {
    JTextArea output;
    JScrollPane scrollPane;
    JButton button;
    static int WIDTH = 1000;
    static int HEIGHT = 500;
 
    public JMenuBar createMenuBar() {
        
        JMenuBar menuBar = new JMenuBar();
 
        //BOOK DATA
        JMenuItem menuBookData = new JMenu("Данные о книге");     
        menuBookData.setMnemonic(KeyEvent.VK_A);
        
//      DataAction dataAction = new DataAction();
//      menuBookData.addActionListener(new DataEventListener());
        menuBookData.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        BookData.createAndShowGUI();
                    }
                });
        	}
        });

        
        menuBar.add(menuBookData);
        
        //READING SETTINGS
        JMenu menuReadSet = new JMenu("Настройки чтения");     
        menuReadSet.setMnemonic(KeyEvent.VK_B);
        menuBar.add(menuReadSet);
        
        //BOOK TOOLS
        JMenu menuBookTools = new JMenu("Инструменты книги");     
        menuBookTools.setMnemonic(KeyEvent.VK_C);
        menuBar.add(menuBookTools);
        
        JMenuItem menuItemBookmark = new JMenuItem("Добавить закладку");
        menuBookTools.add(menuItemBookmark);
        
        JMenuItem menuItemNote = new JMenuItem("Добавить заметку");
        menuBookTools.add(menuItemNote);
        
        menuBookTools.addSeparator();
        
        JMenuItem menuItemSearch = new JMenuItem("Поиск по тексту");
        menuItemSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.ALT_MASK));
        menuItemSearch.addActionListener(new DataEventListener());

        
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
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
 
        //Create a scrolled text area.
        output = new JTextArea(5, 30);
        output.setText(ReadTextFromFile.read("TextForReading.txt"));
        output.setEditable(false);
        output.setLineWrap(true);
        scrollPane = new JScrollPane(output);
        scrollPane.setSize(WIDTH, HEIGHT);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
 
        //Add the text area to the content pane.
        contentPane.add(scrollPane, BorderLayout.CENTER);
 
        return contentPane;
    }
 


    private static void createAndShowGUI() throws IOException {
        //Create and set up the window.
        JFrame frame = new JFrame("Текущая книга");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        MenuLookDemo demo = new MenuLookDemo();
        frame.setJMenuBar(demo.createMenuBar());
        frame.setContentPane(demo.createContentPane());
        frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
					createAndShowGUI();
				} catch (IOException e) {
					
				}
            }
        });
        
    }
}