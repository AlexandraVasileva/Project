package frames;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import library.*;

public class LibraryFrame  extends JFrame{
    
	private JScrollPane scrollPane;
	private JList list;
	public static JFrame frame;
	
	private int WIDTH = 700;
	private int HEIGHT = 500;
	
	public Library temp = new Library();
	
	private String[] sortTypes = {"Жанр", "Автор", "Серия"};
	public String[] justATest;
	
	public LibraryFrame() {
		frame = new JFrame("Библиотека");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			frame.setContentPane(createContentPane());
		} catch (IOException e) {
		}
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
 
    public JToolBar createToolBar() {
        
    	JToolBar toolBar = new JToolBar();
    	toolBar.setFloatable(false);
    	toolBar.setRollover(true);
 
    	JLabel type = new JLabel("Тип сортировки:  ");
    	
    	JComboBox sortTypeList = new JComboBox(sortTypes);
    	sortTypeList.setMaximumSize(sortTypeList.getMinimumSize());
    	sortTypeList.addActionListener(new actionListeners.SortTypeActionListener());
    	
        JButton toLibrary = new JButton("На стартовую страницу");
        toLibrary.addActionListener(new actionListeners.LibraryToStartEventListener());
        toLibrary.setBorderPainted(false);
        
        JButton search = new JButton("Поиск");
        search.setBorderPainted(false);

        toolBar.addSeparator();
        toolBar.add(type);
        toolBar.add(sortTypeList);
        
        toolBar.addSeparator();
        toolBar.add(toLibrary);
        toolBar.add(search);
 
        return toolBar;
    }
 
    public Container createContentPane() throws IOException {

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
        
        temp.find("TestLibrary");
        justATest = temp.listOfSmth(0, temp.getListOfBooks()).toArray(new String[0]);
        System.out.print(justATest);
        list = new JList(justATest);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        list.setFont(new Font("serif", Font.PLAIN, 20));
        list.addListSelectionListener(new actionListeners.TypeSelectionListener());
 
        scrollPane = new JScrollPane(list);
        scrollPane.setSize(WIDTH, HEIGHT);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        
        contentPane.add(createToolBar(), BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);
 
        return contentPane;
    }

    public static void createAndShowGUI() throws IOException {
    	new LibraryFrame();
    }
}