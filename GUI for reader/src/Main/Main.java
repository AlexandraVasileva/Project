package Main;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	System.out.println("I am working!!");
                try {
					Frames.Reader.createAndShowGUI();
				} catch (IOException e) {
				}
                
            }
        });
        
    }

}
