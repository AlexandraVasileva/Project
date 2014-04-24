package Frames;

import java.awt.*;

import javax.swing.*;

public class BookData extends JFrame{

	private int PROPERTIES = 7;
	private static int WIDTH = 410;
	private static int HEIGHT = 290;

    public Container createContentPane() {
    	
        JPanel contentPane = new JPanel();
        
        JLabel authorLabel = new JLabel("Автор");
        JTextField author = new JTextField("", 25);
        
        JLabel titleLabel = new JLabel("Название");
        JTextField title = new JTextField("", 25);
        
        JLabel genreLabel = new JLabel("Жанр");
        JTextField genre = new JTextField("", 25);

        JLabel seriesLabel = new JLabel("Серия");
        JTextField series = new JTextField("", 25);
        
        JLabel yearLabel = new JLabel("Год выхода");
        JTextField year = new JTextField("", 25);
        
        JLabel modeLabel = new JLabel("Режим чтения");
        JTextField mode = new JTextField("", 25);
        
        JLabel tagsLabel = new JLabel("Тэги");
        JTextField tags = new JTextField("", 25);
        
        JButton ok = new JButton("OK");

        
        GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(
        		
        		layout.createParallelGroup(GroupLayout.Alignment.CENTER)
        			
        			.addGroup(layout.createSequentialGroup()

        				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        					.addComponent(authorLabel, GroupLayout.PREFERRED_SIZE,
        						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(titleLabel)
        					.addComponent(genreLabel)
        					.addComponent(seriesLabel)
        					.addComponent(yearLabel)
        					.addComponent(modeLabel)
        					.addComponent(tagsLabel))
        				
        				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        					.addComponent(author, GroupLayout.PREFERRED_SIZE,
                				GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                			.addComponent(title)
                			.addComponent(genre)
                			.addComponent(series)
                			.addComponent(year)
                			.addComponent(mode)
               				.addComponent(tags)))
               				
               		.addComponent(ok));

         layout.linkSize(SwingConstants.HORIZONTAL,
       		  new java.awt.Component[]{author, title, genre, series, year, mode, tags});
          
          layout.setVerticalGroup(

        	   layout.createSequentialGroup()
        		  
        		  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        				.addComponent(authorLabel, GroupLayout.PREFERRED_SIZE,
        								  GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(author))
        								 
        		  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
          				.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE,
          								  GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)			
        				.addComponent(title))
        
          		  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        				.addComponent(genreLabel, GroupLayout.PREFERRED_SIZE,
        								  GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          				.addComponent(genre))
        
          	   	 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        				.addComponent(seriesLabel, GroupLayout.PREFERRED_SIZE,
        								  GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)			
        				.addComponent(series))
        
            	 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                		.addComponent(yearLabel, GroupLayout.PREFERRED_SIZE,
                						  GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
              			.addComponent(year))
              
                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
              			.addComponent(modeLabel, GroupLayout.PREFERRED_SIZE,
              							  GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                		.addComponent(mode))
              
              	 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
              			.addComponent(tagsLabel)
              			.addComponent(tags))
          
              	 .addGap(20)

          	 	 .addComponent(ok));
          
    //      pack();

           
        return contentPane;
    }

	public static void createAndShowGUI() {

        JFrame frame = new JFrame("Данные о книге");
        BookData data = new BookData();
        frame.setContentPane(data.createContentPane());
        frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
        
    }
}