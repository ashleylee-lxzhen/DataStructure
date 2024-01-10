

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestProject
 */
@WebServlet("/TestProject")
public class TestProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if(request.getParameter("keyword")== null) {
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("Search.jsp").forward(request, response);
			return;
		}
		//GoogleQuery google = new GoogleQuery(request.getParameter("keyword"));
		//HashMap<String, String> query = google.query();
		HashMap<String, String> query = callGoogle(request.getParameter("keyword"));
		//HashMap<String, String> query = Application.callGoogle(request.getParameter("keyword"));
		
		String[][] s = new String[query.size()][2];
		request.setAttribute("query", s);
		int num = 0;
		for(Entry<String, String> entry : query.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    s[num][0] = key;
		    s[num][1] = value;
		    num++;
		}
		request.getRequestDispatcher("googleitem.jsp")
		 .forward(request, response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	public static HashMap<String, String> callGoogle(String keyword) throws IOException {
		//關鍵字加上google後搜尋
		keyword += " 書籍";
		GoogleQuery googleQuery = new GoogleQuery(keyword);
		//Title和網址都先存在HashMap
		HashMap<String, String> baseUrls = googleQuery.query();
		
//		測試是否有正確存到 baseUrls：有！
  		
  		for(Entry<String, String> entry : baseUrls.entrySet()) {
  		System.out.println("Title is: " + entry.getKey() + " - URL is: " + entry.getValue());
  		}
  		
		Filter.trees.clear(); // 清除樹列表
		Filter.keywordsList = Filter.initKeywordsList(); // 重新初始化關鍵字列表

		
		//把每個HashMap的元素都翻出來（一個元素包含 title 和 url）
		for(Entry<String, String> entry : baseUrls.entrySet()) {
			if(!(entry.getKey().equals("") || entry.getValue().equals(""))) {
				//System.out.println("Test Title is: " + entry.getKey() + " - Test URL is: " + entry.getValue());
		    
				//把這個元素建立成 webPage，並做成一個 Node，這個 Node 預計成為 Tree 的 root
				//System.out.println("Entry~:    " + entry.getValue());
				WebNode root = new WebNode(new WebPage(entry.getKey(), entry.getValue()));
			
				//建立一個 tree，而 root 就是剛剛那個 node
				WebTree tree = new WebTree(root);
				//讀這個網頁裡面的前四個網址，並把這四個網址建立成 webPage 並塞到 Node，再加到 Tree 內
				tree.createTree(root, 0);
				//把 root 和他四個小孩的 score 都算出來並設定在內
				tree.setPostOrderScore(root);
				Filter.trees.add(tree);
			}
		}
		

/*
		for (String webTitle: baseUrls.keySet()) {
			
			System.out.printf("Web title is : %s, Web URL is : %s", webTitle, baseUrls.get(webTitle));
			
			//把這個元素建立成 webPage，並做成一個 Node，這個 Node 預計成為 Tree 的 root
			WebNode root = new WebNode(new WebPage(webTitle, baseUrls.get(webTitle)));
			
			//建立一個 tree，而 root 就是剛剛那個 node
			WebTree tree = new WebTree(root);
			//讀這個網頁裡面的前四個網址，並把這四個網址建立成 webPage 並塞到 Node，再加到 Tree 內
			tree.createTree(root, 0);
			//把 root 和他四個小孩的 score 都算出來並設定在內
			tree.setPostOrderScore(root);
			Filter.trees.add(tree);
		}
*/		
		
		
		//用 quicksort 排序每個 node (搜尋結果）
		Filter.quickSort(0, Filter.trees.size()-1);
		//建立新的 HashMap：sortedHashMap
		HashMap<String, String> sortedHashMap = new LinkedHashMap<>();
		//把 Filter 裡面每個 Tree 都放到 SortedHashMap 內並回傳
		for (WebTree tree: Filter.trees) {

			tree.eularPrintTree(tree.root);
			sortedHashMap.put(tree.root.page.title, tree.root.page.url);
		}
		return sortedHashMap;
	}
}
