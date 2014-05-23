package readFromFile;

import java.io.*;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class ReadTextFromFile {

	private String[] massivOfImages;

	public String getFileExtention(String filename) {
		int sepPos = filename.lastIndexOf(File.separator);
		String nameAndExt = filename.substring(sepPos + 1);
		int dotPos = nameAndExt.lastIndexOf(".");
		String fileExtention = "";
		if (dotPos != -1) {
			fileExtention = nameAndExt.substring(dotPos + 1);
		}
		return (fileExtention);
	}

	public String readTxt(String filename) throws IOException {
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String s;
			StringBuilder sb = new StringBuilder();

			while ((s = in.readLine()) != null)
				sb.append(s + "\n");
			in.close();
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String readFb2(String filename) throws IOException,
			ParserConfigurationException, SAXException {
		try {
			FileInputStream stream = new FileInputStream(filename);
			String declaration = WorkWithFb2.setDeclaration(filename);
			InputStreamReader reader = new InputStreamReader(stream,
					declaration);
			BufferedReader buffered_reader = new BufferedReader(reader);

			String s;
			StringBuilder sb = new StringBuilder();

			while (((s = buffered_reader.readLine()) != null))
				sb.append(s + "\n");

			String d = sb.toString();
			int num = 0;
			int k = 0;
			WorkWithFb2 worker = new WorkWithFb2();

			int numOfPictures = worker.numberOfPictures(filename);

			massivOfImages = new String[numOfPictures];
			for (int i = 0; i < numOfPictures; i++) {
				massivOfImages[i] = "null";
			}
			for (int i = 0; i < numOfPictures; i++) {
				int begin = sb.toString().indexOf("<image ", k);
				if (begin >= 0) {
					k = begin + 2;
					StringBuilder copy = new StringBuilder();
					copy = sb;
					StringBuilder forEnd = new StringBuilder(copy.toString()
							.substring(begin + 1));

					int end = forEnd.toString().indexOf(">");

					String path = worker.setImage(filename, num);

					int temp = numOfPictures--;
					while (massivOfImages[temp].equals(null)) {
						temp--;
					}
					String HTML = "<p> <img src=\"file:images/" + path
							+ "\">\n</p>";

					d = (sb.replace(begin, end + begin + 2, HTML)).toString();
					num++;
				} else {
					d = sb.toString();
				}
				stream.close();
				// Save massiv!!
			}
			return d;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}