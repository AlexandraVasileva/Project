import java.io.*; 
import javax.swing.text.rtf.*;
import javax.swing.JEditorPane;

public class ReadTextFromFile {
	public static String read(String filename) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		    
		while( (s = in.readLine())!= null) sb.append(s + "\n");
		    
		in.close();
		return sb.toString();
		
	}
}  