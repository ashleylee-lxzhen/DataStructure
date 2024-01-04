import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;

public class GoogleQuery 
{
	public String searchKeyword;
	public String url;
	public String content;
	
	public GoogleQuery(String searchKeyword)
	{
		this.searchKeyword = searchKeyword;
		try 
		{

			// This part has been specially handled for Chinese keyword processing. 
			// You can comment out the following two lines 
			// and use the line of code in the lower section. 
			// Also, consider why the results might be incorrect 
			// when entering Chinese keywords.
			String encodeKeyword = java.net.URLEncoder.encode(searchKeyword,"utf-8");
			this.url = "https://www.google.com/search?q="+encodeKeyword+"&oe=utf8&num=20";
			
			// this.url = "https://www.google.com/search?q="+searchKeyword+"&oe=utf8&num=20";

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	private String fetchContent() throws IOException
	{
		String retVal = "";

		URL u = new URL(url);
		URLConnection conn = u.openConnection();
		//set HTTP header
		conn.setRequestProperty("User-agent", "Chrome/107.0.5304.107");
		InputStream in = conn.getInputStream();

		InputStreamReader inReader = new InputStreamReader(in, "utf-8");
		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;

		while((line = bufReader.readLine()) != null)
		{
			retVal += line;
		}
		return retVal;
	}
	
	public HashMap<String, String> query() throws IOException
	{
		if(content == null)
		{
			content = fetchContent();
		}

		HashMap<String, String> retVal = new HashMap<String, String>();
		
		
		//using Jsoup analyze html string
		Document doc = Jsoup.parse(content);
		
		//select particular element(tag) which you want 
		Elements lis = doc.select("div");
		lis = lis.select(".kCrYT");
		
		for(Element li : lis)
		{
			try 
			{
				String citeUrl = li.select("a").get(0).attr("href");
				String title = li.select("a").get(0).select(".vvjwJb").text();
				
				String target = "&sa=U&ved=";

				int index = citeUrl.indexOf(target);
				if (index != -1) {
				    // 如果找到了目標字符串，截取它之前的部分
				    citeUrl = citeUrl.substring(0, index);
				    //System.out.println(result); // 輸出: 這是一個示例
				} 
				
				if(title.equals("")) 
				{
					continue;
				}
				
				//System.out.println("Title: " + title + " , url: " + citeUrl);

		        //String cleanedURL = cleanURL(citeUrl);
				
				//put title and pair into HashMap
				retVal.put(title, citeUrl);

			} catch (IndexOutOfBoundsException e) 
			{
				//e.printStackTrace();
			}
		}
		
//		for(Entry<String, String> entry : retVal.entrySet()) {
//		    System.out.println("G Title is: " + entry.getKey() + " - G URL is: " + entry.getValue());
//		}

		
		return retVal;
	}
	public List<String> getRelatedKeyword() throws IOException {
		ArrayList<String> result = new ArrayList<>();
		if (content == null) {
			content = Scrapper.fetchContent(this.url);
		}
		Document doc = Jsoup.parse(content);
		Elements elements = doc.select("div.BNeawe.s3v9rd.AP7Wnd.lRVwie");
		for (Element element: elements) {
			result.add(element.getAllElements().first().text());
		}
		return result;
	}
	
    public static String cleanURL(String originalURL) {
        try {
            // 删除前缀 "/url?q="
            String prefix = "/url?q=";
            int prefixIndex = originalURL.indexOf(prefix);
            if (prefixIndex != -1) {
                originalURL = originalURL.substring(prefixIndex + prefix.length());
            }

            // 查找可能的额外参数，如 "&sa="，并删除它及其后的部分
            int extraParamIndex = originalURL.indexOf("&sa=");
            if (extraParamIndex != -1) {
                originalURL = originalURL.substring(0, extraParamIndex);
            }

            // URL 解码
            return URLDecoder.decode(originalURL, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}