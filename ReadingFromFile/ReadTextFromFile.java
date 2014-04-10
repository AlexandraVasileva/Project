import java.io.*; 
import javax.swing.text.rtf.*;
import javax.swing.JEditorPane;
public class ReadTextFromFile {
	public static String read(String filename) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(filename));
		    String s;
		    StringBuilder sb = new StringBuilder();
		    
		    while( (s = in.readLine())!= null)
		      sb.append(s + "\n");
		      in.close();
		      return sb.toString();
	}

	
	
		 //checking
		 public static void main(String[] args) throws IOException {
		    System.out.print("I'm from txt:   " + read("TextForReading.txt"));
		    
		    //It is stupid version
		    System.out.print("I'm from fb2:   " + read("TextFb2.fb2"));
		    System.out.print( read("text.rtf"));
		    
		 }
}  