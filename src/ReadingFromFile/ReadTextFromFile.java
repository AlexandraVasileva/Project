package ReadingFromFile;

import java.io.*; 

public class ReadTextFromFile {
	private String read(String filename) throws IOException{
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
			ReadTextFromFile reader = new ReadTextFromFile();
		    System.out.print("I'm from txt:   " + reader.read("TextForReading.txt"));
		    
		    //It is stupid version
		    System.out.print("I'm from fb2:   " + reader.read("TextFb2.fb2"));
		    System.out.print( reader.read("text.rtf"));
		    
		 }
}  