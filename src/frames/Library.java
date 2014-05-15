package frames;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class Library  extends JFrame{
    
	private JTextArea output;
	private JScrollPane scrollPane;
	private JList list;
	public static JFrame frame;
	
	private int WIDTH = 700;
	private int HEIGHT = 500;
	
	private String[] sortTypes = {"Жанр", "Автор", "Серия"};
	private String[] justATest = {"Green", "Red", "Blue", "Yellow", "Emerald", "Hazel", "Violet", "Orange", "Lilac", "Brown", "White", "Ochre", "Black", "Chestnut", "Bronze", "Green", "Red", "Blue", "Yellow", "Emerald", "Hazel", "Violet", "Orange", "Lilac", "Brown", "White", "Ochre", "Black", "Chestnut", "Bronze"};
	
	public Library() {
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
 //   	sortTypeList.setSelectedIndex(0);
    	
        JButton toLibrary = new JButton("На стартовую страницу");
        toLibrary.addActionListener(new actionListeners.LibraryToStartEventListener());
        toLibrary.setBorderPainted(false);
        
        JButton search = new JButton("Поиск");
        search.setBorderPainted(false);

        toolBar.addSeparator();
        toolBar.add(type);
        toolBar.add(sortTypeList);
        Dimension sep = new Dimension();
        sep = toolBar.getSize();
        
        toolBar.addSeparator();
        toolBar.add(toLibrary);
        toolBar.add(search);
 
        return toolBar;
    }
 
    public Container createContentPane() throws IOException {

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
        
        list = new JList(justATest); //data has type Object[]
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        list.setFont(new Font("serif", Font.PLAIN, 20));

 
        scrollPane = new JScrollPane(list);
        scrollPane.setSize(WIDTH, HEIGHT);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0,200,0,0));
        
        contentPane.add(createToolBar(), BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);
 
        return contentPane;
    }

    public static void createAndShowGUI() throws IOException {
    	new Library();
    }
}