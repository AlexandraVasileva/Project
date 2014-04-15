import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
public class web {
	//проверка наличия интернет соединения(возвращает true если есть)
	private static boolean checkInternetConnection() {
	    Boolean result = false;
	    HttpURLConnection con = null;
	    try {
	        // HttpURLConnection.setFollowRedirects(false);
	        // HttpURLConnection.setInstanceFollowRedirects(false)
	        con = (HttpURLConnection) new URL("http://www.ya.ru").openConnection();
	        con.setRequestMethod("HEAD");
	        result = (con.getResponseCode() == HttpURLConnection.HTTP_OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (con != null) {
	            try {
	                con.disconnect();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return result;
	}
	
	
	//на вход: язык оригинала, язык результата, текст
	//возвращает строку с переводом

	private static String Dictionary(String langFrom, String langTo, String word) throws IOException{
				
		 String apiKey = "dict.1.1.20140414T172607Z.6cad0b1fa8774b03.9d84439e1beec9dfeb458389b6fc158f5fcac873"; 
	     String stringRequest = "https://dictionary.yandex.net/api/v1/dicservice/lookup?key="+apiKey + "&lang=" + langFrom+"-"+langTo+ "&text=" +URLEncoder.encode(word, "UTF-8");
		 
		 CloseableHttpClient httpclient = HttpClients.createDefault();
		 HttpGet httpget = new HttpGet(stringRequest);
		 CloseableHttpResponse response = httpclient.execute(httpget);
		 StringBuilder result = new StringBuilder();
		   
		 try{
	        	HttpEntity entity = response.getEntity();
		    	BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
		    	
		    	String first;    
		    	first = in.readLine();	
		    	String input = new String();
		    	while((first = in.readLine()) != null){
		    		input=new String(first);
		    	}
		    	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			        DocumentBuilder db = dbf.newDocumentBuilder();
			        InputSource is = new InputSource();
			        is.setCharacterStream(new StringReader(input));
			        Document doc = db.parse(is);
			    
			        NodeList text = doc.getElementsByTagName("text");
			   
			        Element line = (Element) text.item(1);
			        result.append(line.getTextContent());
			        result.append(" ");
			 
			        NodeList nList = doc.getElementsByTagName("syn");      
				    for(int i=0; i< nList.getLength(); i++){
				        	Element element = (Element)nList.item(i);
				        	NodeList syn = element.getElementsByTagName("text");
				        	Element line1 = (Element) syn.item(0);
				        	result.append(line1.getTextContent());
				        	result.append(" ");	        	
				        }
			        
		    	EntityUtils.consume(entity);
		    }
		    catch (Exception e) {
		    	e.printStackTrace();
		    }
		 finally{
		    	response.close();
		 }
		 return result.toString();
	}
		 //checking
		 public static void main(String[] args) throws IOException {
		   if(checkInternetConnection()){
			   System.out.println(Dictionary("en", "ru", "happy"));
		   }
		   else{
			   System.out.println("no Internet Connection");
		   }
		   
		 }
}  























