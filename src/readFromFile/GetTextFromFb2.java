package readFromFile;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import sun.text.normalizer.RangeValueIterator.Element;



public class GetTextFromFb2 extends Element{
	public static String getText(String path) throws IOException, ParserConfigurationException, SAXException{
		String s="";
		try{
			File fXmlFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			Node  body = doc.getElementsByTagName("body").item(0);
			Element eElement = (Element) body;
		
		
				
		System.out.println(s);	
			
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
		return d3;

	}

}
