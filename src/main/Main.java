package main;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
					frames.StartPage.createAndShowGUI();
				} catch (IOException e) {
				}
            }
        });
    }
}