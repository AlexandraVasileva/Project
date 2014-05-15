package readFromFile;

import java.io.*;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class ReadTextFromFile {
	
	public static String getFileExtention(String filename){ 
		int sepPos = filename.lastIndexOf(File.separator); 
		String nameAndExt = filename.substring(sepPos + 1); 
		int dotPos = nameAndExt.lastIndexOf("."); 
		String fileExtention="";
		if(dotPos!=-1){
			fileExtention = nameAndExt.substring(dotPos + 1);
		}
		return(fileExtention);
	}
	public static String readTxt(String filename) throws IOException
	{	BufferedReader in = new BufferedReader(new FileReader(filename));
    	String s;
    	StringBuilder sb = new StringBuilder();

    	while( (s = in.readLine())!= null)
    		sb.append(s + "\n");
    	in.close();
    	return sb.toString();	
	}
	
	public static String readFb2(String filename) throws IOException, ParserConfigurationException, SAXException{		
		FileInputStream stream = new FileInputStream ( filename );
		String declaration = WorkWithFb2.setDeclaration(filename);	
		InputStreamReader reader = new InputStreamReader ( stream ,declaration);
		BufferedReader buffered_reader = new BufferedReader ( reader );
		
		String s;
		StringBuilder sb = new StringBuilder();

		while( (s = buffered_reader.readLine())!= null) sb.append(s + "\n");
		
		int begin = sb.toString().indexOf("<body>");

		String d="";
		if(begin>=0)
		{
		d=sb.toString().substring(begin+6);
		}
		else{
			d = sb.toString();
		}
		stream.close();
			String d2 = d.replace ("<v>", "<p>");
			String d3 = d2.replaceAll("</v>", "</p>");
		return d3;

	}
	public static String read(String filename) throws IOException, ParserConfigurationException, SAXException{
		String text="";
		//File file = new File(filename);
		//boolean exists = file.exists();
		if(getFileExtention(filename).equals("txt")){
			text = readTxt(filename);
		}
		else{
			if(getFileExtention(filename).equals("fb2")){
				text = readFb2(filename);				
			}
			else{
				text = "This format is not supported";
			}
		}
	//	System.out.println(text);
		return text;

	}
	
}