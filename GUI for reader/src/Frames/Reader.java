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
        JButton menuBookData = new JButton("������ � �����");     
        menuBookData.setMnemonic(KeyEvent.VK_A);
        
        menuBookData.addActionListener(new ActionListeners.DataEventListener());

        menuBar.add(menuBookData);
        
        //READING SETTINGS
        JButton menuReadSet = new JButton("��������� ������");     
        menuReadSet.setMnemonic(KeyEvent.VK_B);
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
        menuItemSearch.addActionListener(new ActionListeners.DataEventListener());

        
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
        
        //LIBRARY NAVIGATION
        JMenu menuLibNav = new JMenu("��������� �� ����������");     
        menuLibNav.setMnemonic(KeyEvent.VK_E);
        menuBar.add(menuLibNav);
        
        JMenuItem menuItemBack = new JMenuItem("�����");
        menuLibNav.add(menuItemBack);
        
        JMenuItem menuItemAuthor = new JMenuItem("� ����� ������");
        menuLibNav.add(menuItemAuthor);
        
        JMenuItem menuItemLib = new JMenuItem("� ����������");
        menuLibNav.add(menuItemLib);
        
        JMenuItem menuItemStart = new JMenuItem("�� ��������� ��������");
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

        JFrame frame = new JFrame("�������� ̸����");
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