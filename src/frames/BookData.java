package frames;

import java.awt.*;

import javax.swing.*;

public class BookData extends JFrame{

	private int WIDTH = 400;
	private int HEIGHT = 210;
	private Color lightgrey = new Color(206, 206, 206);
	private Color lightlightgrey = new Color(224, 218, 230);
	public JTextField author;
	public JTextField title;
	public JTextField genre;
	public JTextField series;
	
	public JFrame frame;
	private frames.Reader rframe;
	
	public BookData(frames.Reader rframe){
        this.rframe = rframe;
		frame = new JFrame("");
		frame.setContentPane(createContentPane());
        frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
        author.setText(rframe.startframe.openbook.searchForBook(rframe.bookname, rframe.startframe.openbook.getListOfBooks(), 4).get(0).getAuthor());
        title.setText(rframe.startframe.openbook.searchForBook(rframe.bookname, rframe.startframe.openbook.getListOfBooks(), 4).get(0).getName());
        genre.setText(rframe.startframe.openbook.searchForBook(rframe.bookname, rframe.startframe.openbook.getListOfBooks(), 4).get(0).getGenre());
        series.setText(rframe.startframe.openbook.searchForBook(rframe.bookname, rframe.startframe.openbook.getListOfBooks(), 4).get(0).getSeries());
        
        
	}

	private void setLabelLF(JComponent component){
		component.setBackground(lightgrey);
		component.setForeground(Color.darkGray);
		component.setFont(new Font("monospaced", Font.PLAIN, 16));
	}
	
	private void setFieldLF(JComponent component){
		component.setBackground(lightlightgrey);
		component.setForeground(Color.darkGray);
		component.setFont(new Font("sansserif", Font.PLAIN, 12));
	}
	
    public Container createContentPane() {
    	
        JPanel contentPane = new JPanel();
        contentPane.setBackground(lightgrey);
        
        JLabel authorLabel = new JLabel("Автор");
        setLabelLF(authorLabel);
        
        author = new JTextField("", 25);
        setFieldLF(author);
        
        JLabel titleLabel = new JLabel("Название");
        setLabelLF(titleLabel);
        
        title = new JTextField("", 25);
        setFieldLF(title);
        
        JLabel genreLabel = new JLabel("Жанр");
        setLabelLF(genreLabel);
        
        genre = new JTextField("", 25);
        setFieldLF(genre);

        JLabel seriesLabel = new JLabel("Серия");
        setLabelLF(seriesLabel);
        
        series = new JTextField("", 25);
        setFieldLF(series);
        
        JButton ok = new JButton("OK");
        setLabelLF(ok);

        ok.addActionListener(new actionListeners.DataOkEventListener(this, rframe));
        
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
        					.addComponent(seriesLabel))
        				
        				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        					.addComponent(author, GroupLayout.PREFERRED_SIZE,
                				GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                			.addComponent(title)
                			.addComponent(genre)
                			.addComponent(series)))		
               			
               				.addComponent(ok));
                        	

         layout.linkSize(SwingConstants.HORIZONTAL,
       		  new java.awt.Component[]{author, title, genre, series});
         layout.linkSize(SwingConstants.VERTICAL,
          		  new java.awt.Component[]{author, title, genre, series, authorLabel, titleLabel, genreLabel, seriesLabel});
          
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
          
              	 .addGap(20)

              	.addComponent(ok));
           
        return contentPane;
    }

}