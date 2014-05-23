package WorkWithInternet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.apache.http.*;

public class WorkWithWeb {
	static java.net.URI uriGoogle;
	static java.net.URI uriWiki;
	final String api = "trnsl.1.1.20140521T064319Z.7524773d92415a00.028ddcaa51bb9968d5b67ae1b646e891309d319a";

	// проверка наличия интернет соединения(возвращает true если есть)
	private boolean checkInternetConnection()
			throws java.net.UnknownHostException {
		Boolean result = false;
		HttpURLConnection con = null;
		try {
			con = (HttpURLConnection) new URL("http://www.ya.ru")
					.openConnection();
			con.setRequestMethod("HEAD");
			result = (con.getResponseCode() == HttpURLConnection.HTTP_OK);
		} catch (java.net.UnknownHostException e) {
			result = false;
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

	// на вход: язык оригинала, язык результата, текст
	// возвращает строку с переводом

	public String dictionary(String langFrom, String langTo, String word)
			throws IOException, ParserConfigurationException, SAXException {
		StringBuilder result = new StringBuilder();
		try {
			if (checkInternetConnection()) {
				String stringRequest = "https://translate.yandex.net/api/v1.5/tr/translate?key="
						+ api
						+ "&lang="
						+ langFrom
						+ "-"
						+ langTo
						+ "&text="
						+ URLEncoder.encode(word, "UTF-8");

				CloseableHttpClient httpclient = HttpClients.createDefault();
				HttpGet httpget = new HttpGet(stringRequest);
				CloseableHttpResponse response = httpclient.execute(httpget);

				HttpEntity entity = response.getEntity();
				BufferedReader in = new BufferedReader(new InputStreamReader(
						entity.getContent(), "UTF-8"));

				String first;
				first = in.readLine();
				String input = new String();
				while ((first = in.readLine()) != null) {
					input = new String(first);
				}
				DocumentBuilderFactory dbf = DocumentBuilderFactory
						.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				InputSource is = new InputSource();
				is.setCharacterStream(new StringReader(input));
				Document doc = db.parse(is);

				NodeList text = doc.getElementsByTagName("text");

				Element line = (Element) text.item(0);
				result.append(line.getTextContent());
				EntityUtils.consume(entity);
				response.close();

			} else {
				System.out.println("No Internet connection");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {

			return result.toString();

		}
	}

	public void google(String forSearching) throws ClientProtocolException,
			IOException, URISyntaxException {
		try {
			if (checkInternetConnection()) {
				uriGoogle = new URI(
						("http://www.google.com/search?q=" + URLEncoder.encode(
								forSearching, "UTF-8")));
				java.awt.Desktop.getDesktop().browse(uriGoogle);
			} else {
				System.out.println("No Internet connection");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchInfo(String forSearching)
			throws ClientProtocolException, IOException, URISyntaxException {
		try {
			if(checkInternetConnection()){
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(
					("http://ru.wikipedia.org/wiki/" + URLEncoder.encode(
							forSearching, "UTF-8")));
			CloseableHttpResponse response = httpclient.execute(httpget);

			StatusLine status = response.getStatusLine();
			int st = status.getStatusCode();
			if (st == 404) {
				uriGoogle = new URI(
						("http://www.google.com/search?q=" + URLEncoder.encode(
								forSearching, "UTF-8")));
				java.awt.Desktop.getDesktop().browse(uriGoogle);
			} else {
				uriWiki = new URI(
						("http://ru.wikipedia.org/wiki/" + URLEncoder.encode(
								forSearching, "UTF-8")));
				java.awt.Desktop.getDesktop().browse(uriWiki);
			}
			}
			else{
				System.out.println("No Internet connection");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
