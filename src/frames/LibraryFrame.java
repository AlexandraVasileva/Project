package frames;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;

import javax.swing.*;

import library.*;
import books.*;
import frames.*;

public class LibraryFrame  extends JFrame{
	
	private static LibraryFrame instance;
    
	private JScrollPane scrollPane;
	public JList list;
	public JFrame frame;
	public frames.StartPage srartframe;
	
	private int WIDTH = 700;
	private int HEIGHT = 500;
	private Color lightgrey = new Color(206, 206, 206);
	private Color lightlightgrey = new Color(224, 218, 230);
	
	public int displayedType; // current displayed type
	
	public ArrayList<Book> currentlist = new ArrayList<>();
	
	private String[] sortTypes = {"Жанр", "Автор", "Серия"};
	public static String[] justATest;
	
	
	public void setList(String[] newList){
		justATest = newList;
		//list.setModel(); = new JList(justATest);
		//list.setSelectedValue(null, false);
		frame.repaint();
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
	
	private LibraryFrame(String[] defaultList, frames.StartPage startframe) {
		this.srartframe = startframe;
		displayedType = 0;
		currentlist = startframe.openbook.getListOfBooks();
		justATest = defaultList;
		//list = new JList(justATest);
		list = new JList(new AbstractListModel<String>() {
                public int getSize() { return justATest.length; }
                public String getElementAt(int i) { return justATest[i]; }
            });
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
    	toolBar.setBackground(lightgrey);
 
    	JLabel type = new JLabel("Тип сортировки:  ");
    	setLabelLF(type);
    	
    	JComboBox sortTypeList = new JComboBox(sortTypes);
    	sortTypeList.setMaximumSize(sortTypeList.getMinimumSize());
    	setFieldLF(sortTypeList);
    	sortTypeList.addActionListener(new actionListeners.SortTypeActionListener(this, this.srartframe));
    	
        JButton toLibrary = new JButton("На стартовую страницу");
        toLibrary.addActionListener(new actionListeners.LibraryToStartEventListener(this, this.srartframe)); // Library to StartPage
        toLibrary.setBorderPainted(false);
        setLabelLF(toLibrary);
        
        JButton reset = new JButton("В корень библиотеки");
        //toLibrary.addActionListener(new actionListeners.LibraryToStartEventListener(this, this.startframe));
        reset.setBorderPainted(false);
        setLabelLF(reset);
        reset.addActionListener(new actionListeners.ResetEventListener(this, this.srartframe));
        
        JButton search = new JButton("Поиск");
        search.setBorderPainted(false);
        setLabelLF(search);
        search.addActionListener(new actionListeners.SearchEventListener(this.srartframe));

        toolBar.addSeparator();
        toolBar.add(type);
        toolBar.add(sortTypeList);
        
        toolBar.addSeparator();
        toolBar.add(toLibrary);
        toolBar.add(reset);
        toolBar.add(search);
 
        return toolBar;
    }
 
    public Container createContentPane() throws IOException {

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
        

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        list.setFont(new Font("serif", Font.PLAIN, 20));
        list.setBackground(lightlightgrey);
        list.addListSelectionListener(new actionListeners.TypeSelectionListener(this, this.srartframe));
 
        scrollPane = new JScrollPane(list);
        scrollPane.setSize(WIDTH, HEIGHT);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        scrollPane.setBackground(lightlightgrey);
        
        contentPane.add(createToolBar(), BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);
 
        return contentPane;
    }

    public static synchronized LibraryFrame getInstance(String[] defaultList, frames.StartPage startframe) {
    	if (instance == null){
    		instance = new LibraryFrame(defaultList, startframe);
    	} else {
    		instance.setList(defaultList);
    	}
    	return instance;
    }
}