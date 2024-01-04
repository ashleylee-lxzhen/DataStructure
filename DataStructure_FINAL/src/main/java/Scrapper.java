
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Scrapper {

	public Scrapper() {
	}

	public static String fetchContent(String Url) throws IOException {
		String retVal = "";
		
		try {
			URL url = new URL(Url);
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
	
			String line = null;
		
			while ((line = br.readLine()) != null){
				retVal = retVal + line + "\n";
			}
		}catch(Exception e) {
			//System.out.println("Exception in Scrapper");
			//e.printStackTrace();
		}
			
	
		return retVal;
	}
/*
		String retVal = "";
		try {
			URL u = new URL(url);
			URLConnection conn = u.openConnection();
			// set HTTP header
			conn.setRequestProperty("User-agent", "Chrome/107.0.5304.107");
			InputStream in = conn.getInputStream();

			InputStreamReader inReader = new InputStreamReader(in, "utf-8");
			BufferedReader bufReader = new BufferedReader(inReader);
			String line = null;

			while ((line = bufReader.readLine()) != null) {
				retVal += line;
			}
		} catch (Exception e){
			System.out.println("Exception in Scrapper");
			e.printStackTrace();
		}
		return retVal;
	}
*/

}
