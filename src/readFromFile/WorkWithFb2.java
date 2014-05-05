package readFromFile;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class WorkWithFb2{

	//Return Genre
	private String setGenre(String path) throws SAXException, IOException, ParserConfigurationException{
		String genre="";
		try{
			File fXmlFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
		//	Node  description = doc.getElementsByTagName("description").item(0);
		//	Node title_info =doc.getElementsByTagName("title-info").item(0);
			
			NodeList genreList = doc.getElementsByTagName("genre");		
			for (int temp = 0; temp < genreList.getLength(); temp++){
				if(temp>0) genre = genre+", ";
				Node nNode = genreList.item(temp);			
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {					 
					Element eElement = (Element) nNode;
					genre=genre+eElement.getTextContent();			
				}
		 
			}
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		return genre;
	}
	
	
	//Return Author
	private String setAuthor(String path) throws SAXException, IOException, ParserConfigurationException{
		String author="";
		try{
			File fXmlFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
					
			Node bookAuthor = doc.getElementsByTagName("author").item(0);				
					Element eElement = (Element) bookAuthor;	  
					
					if(eElement.getElementsByTagName("first-nyhame").equals(null)) System.out.println("gg");
					author=author+eElement.getElementsByTagName("last-name").item(0).getTextContent()+" ";
					author=author+eElement.getElementsByTagName("first-name").item(0).getTextContent()+" ";
					author=author+eElement.getElementsByTagName("middle-name").item(0).getTextContent()+" ";	
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		catch (java.lang.NullPointerException ex) {
			return author;
		}
		return author;
	}
	
	private String setTitle(String path) throws SAXException, IOException, ParserConfigurationException{
		String title = "";
		try{
			File fXmlFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
		
			Node  description = doc.getElementsByTagName("book-title").item(0);		
			title=description.getTextContent();			

		}catch (IOException ex) {
			ex.printStackTrace();
		}
		return title;
	}
	
	//coverpage
	
	//NOT READY
	private String setCover(String path) throws SAXException, IOException, ParserConfigurationException{
		String title = "";
		try{
			File fXmlFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
		
			Node  description = doc.getElementsByTagName("coverpage").item(0);		
			title=description.getTextContent();			

		}catch (IOException ex) {
			ex.printStackTrace();
		}
		return title;
	}
	
	
	
	
	
	private String getFieldFromBook(String path) throws IOException, ParserConfigurationException, SAXException{
		String s="";
		try{
			File fXmlFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			Node  description = doc.getElementsByTagName("description").item(0);
			Node title_info =doc.getElementsByTagName("title-info").item(0);
			NodeList genreList = doc.getElementsByTagName("");
			for (int temp = 0; temp < genreList.getLength(); temp++) {
				
			}
			
			
			System.out.println("\nCurrent Element :" + title_info.getNodeName());
			
		
			
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		return s;

	}
	
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		WorkWithFb2 worker = new WorkWithFb2();
		System.out.println(( worker.setGenre("Onegin.fb2")));
		System.out.println(( worker.setAuthor("Onegin.fb2")));
		System.out.println(( worker.setTitle("Onegin.fb2")));
		
	
	   
	 }
}
