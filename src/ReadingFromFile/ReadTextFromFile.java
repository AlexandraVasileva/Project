package ReadingFromFile;

import java.awt.print.PrinterException;
import java.io.*; 

import org.apache.pdfbox.pdmodel.PDDocument;

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
	//печать на принтере
	private void printPdf(String filename) throws IOException, PrinterException {
		try{
		    PDDocument doc = PDDocument.load(filename);
		    doc.print();
		}catch(IOException ex){
			ex.printStackTrace();
		}catch(PrinterException ex1){
			ex1.printStackTrace();
		}
		}

	
		 //checking
		 public static void main(String[] args) throws IOException, PrinterException {
			ReadTextFromFile reader = new ReadTextFromFile();
		    System.out.print("I'm from txt:   " + reader.read("TextForReading.txt"));
		    reader.printPdf("file.pdf");
		    		    
		 }
}  