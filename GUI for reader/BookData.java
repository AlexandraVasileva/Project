import java.awt.*;

import javax.swing.*;

public class BookData extends JFrame{
	
    public Container createContentPane() {	//WITHOUT LAYOUT YET
    	
        JPanel contentPane = new JPanel();
        
        JLabel authorLabel = new JLabel("Автор");
        JTextField author = new JTextField("", 25);
        contentPane.add(authorLabel);
        contentPane.add(author);
        
        JLabel titleLabel = new JLabel("Название");
        JTextField title = new JTextField("", 22);
        contentPane.add(titleLabel);
        contentPane.add(title);
        
        JLabel genreLabel = new JLabel("Жанр");
        JTextField genre = new JTextField("", 23);
        contentPane.add(genreLabel);
        contentPane.add(genre);

        JLabel seriesLabel = new JLabel("Серия");
        JTextField series = new JTextField("", 20);
        contentPane.add(seriesLabel);
        contentPane.add(series);
        
        JLabel yearLabel = new JLabel("Год выпуска");
        JTextField year = new JTextField("", 15);
        contentPane.add(yearLabel);
        contentPane.add(year);
        
        JLabel modeLabel = new JLabel("Режим чтения");
        JTextField mode = new JTextField("", 19);
        contentPane.add(modeLabel);
        contentPane.add(mode);
        
        JLabel tagsLabel = new JLabel("Тэги");
        JTextField tags = new JTextField("", 20);
        contentPane.add(tagsLabel);
        contentPane.add(tags);
        
        return contentPane;
    	
    }
	
	public static void createAndShowGUI() {

        JFrame frame = new JFrame("Данные о книге");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BookData data = new BookData();
        frame.setContentPane(data.createContentPane());
        frame.setSize(350, 220);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);

        
    }
	

}
