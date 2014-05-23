package readFromFile;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WorkWithFb2 {

	// Return Genre
	public static String setGenre(String path) throws SAXException,
			IOException, ParserConfigurationException {
		String genre = "";
		try {
			File fXmlFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			NodeList genreList = doc.getElementsByTagName("genre");
			for (int temp = 0; temp < genreList.getLength(); temp++) {
				if (temp > 0)
					genre = genre + ", ";
				Node nNode = genreList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					genre = genre + eElement.getTextContent();
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return genre;
	}
	
	public int numberOfPictures(String path) throws SAXException, IOException, ParserConfigurationException{
		try{
		File fXmlFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);		
		NodeList imageList = doc.getElementsByTagName("image");
		
		int numPictures = imageList.getLength();
		return numPictures;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}

	public String setImage(String path, int count) throws SAXException,
			IOException, ParserConfigurationException {
		String id = "";
		try {
			File fXmlFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			
			NodeList imageList = doc.getElementsByTagName("image");	
			NamedNodeMap attribut = imageList.item(count).getAttributes();
			Attr attr = (Attr) attribut.item(0);
			String attrImage = attr.getNodeValue();
			String attrValueImage = attrImage.substring(1);
			String attrFormat = "";
			String binaryCode = "";
			NodeList Bynary = doc.getElementsByTagName("binary");
			int numBin = Bynary.getLength();

			for (int temp = 0; temp < numBin; temp++) {
				NamedNodeMap attributB = Bynary.item(temp).getAttributes();
				int numAttrs = attributB.getLength();

				for (int i = 0; i < numAttrs; i++) {
					Attr attrB = (Attr) attributB.item(i);
					String attrValueB = attrB.getNodeValue();
					if (attrValueImage.equals(attrValueB)) {
						String attrFormatB = attr.getNodeValue();
						int dotPos = attrFormatB.lastIndexOf(".");
						attrFormat = attrFormatB.substring(dotPos + 1);
						Element eElement = (Element) Bynary.item(temp);
						binaryCode = eElement.getTextContent();
					}
				}
			}
		
			byte[] tmp = javax.xml.bind.DatatypeConverter
					.parseBase64Binary(binaryCode);
			FileOutputStream pw = new FileOutputStream("images/"+attrValueImage);
			
			pw.write(tmp);
			pw.flush();
			pw.close();
			id=attrValueImage;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
		return id;
	}

	// Return Author
	private String setAuthor(String path) throws SAXException, IOException,
			ParserConfigurationException {
		String author = "";
		try {
			File fXmlFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			Node bookAuthor = doc.getElementsByTagName("author").item(0);
			Element eElement = (Element) bookAuthor;

			if (eElement.getElementsByTagName("first-nyhame").equals(null))
	
			author = author
					+ eElement.getElementsByTagName("last-name").item(0)
							.getTextContent() + " ";
			author = author
					+ eElement.getElementsByTagName("first-name").item(0)
							.getTextContent() + " ";
			author = author
					+ eElement.getElementsByTagName("middle-name").item(0)
							.getTextContent() + " ";
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (java.lang.NullPointerException ex) {
			return author;
		}
		return author;
	}

	private String setTitle(String path) throws SAXException, IOException,
			ParserConfigurationException {
		String title = "";
		try {
			File fXmlFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			Node description = doc.getElementsByTagName("book-title").item(0);
			title = description.getTextContent();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return title;
	}

	
	public static String setDeclaration(String path) throws SAXException,
			IOException, ParserConfigurationException {
		String declaration = "";
		try {
			File fXmlFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			declaration = doc.getXmlEncoding();
			// doc.getXmlEncoding()
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return declaration;

	}

}
