import java.awt.*;

import javax.swing.*;

public class BookData extends JFrame{
	
	int PROPERTIES = 7;
	
    public Container createContentPane() {
    	
        JPanel contentPane = new JPanel();
        
        GridLayout dataLayout = new GridLayout(PROPERTIES,2);
        contentPane.setLayout(dataLayout);
        
        JLabel authorLabel = new JLabel("Автор");
        JTextField author = new JTextField("", 25);
  //      contentPane.add(authorLabel);
  //      contentPane.add(author);
        
        JLabel titleLabel = new JLabel("Название");
        JTextField title = new JTextField("", 25);
  //      contentPane.add(titleLabel);
  //      contentPane.add(title);
        
        JLabel genreLabel = new JLabel("Жанр");
        JTextField genre = new JTextField("", 25);
  //      contentPane.add(genreLabel);
  //      contentPane.add(genre);

        JLabel seriesLabel = new JLabel("Серия");
        JTextField series = new JTextField("", 25);
  //      contentPane.add(seriesLabel);
  //      contentPane.add(series);
        
        JLabel yearLabel = new JLabel("Год выпуска");
        JTextField year = new JTextField("", 25);
  //      contentPane.add(yearLabel);
  //      contentPane.add(year);
        
        JLabel modeLabel = new JLabel("Режим чтения");
        JTextField mode = new JTextField("", 25);
  //      contentPane.add(modeLabel);
  //      contentPane.add(mode);
        
        JLabel tagsLabel = new JLabel("Тэги");
        JTextField tags = new JTextField("", 25);
  //      contentPane.add(tagsLabel);
  //      contentPane.add(tags);

        
        GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(
        		
        		layout.createSequentialGroup()

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
               				.addComponent(tags)));

 //        layout.linkSize(SwingConstants.HORIZONTAL,
 //      		  new java.awt.Component[]{authorLabel, author});
          
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
              			.addComponent(tagsLabel, GroupLayout.PREFERRED_SIZE,
              						  GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
              			.addComponent(tagsLabel)));
        
           pack();
           
        return contentPane;
    }
	
	public static void createAndShowGUI() {

        JFrame frame = new JFrame("Данные о книге");
        BookData data = new BookData();
        frame.setContentPane(data.createContentPane());
        frame.setSize(350, 220);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
        
    }

}
