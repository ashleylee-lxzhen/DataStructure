import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		System.out.print(callGoogle("資科"));
		
		}
	public static HashMap<String, String> callGoogle(String keyword) throws IOException {
		keyword += " book";
		GoogleQuery googleQuery = new GoogleQuery(keyword);
		HashMap<String, String> baseUrls = googleQuery.query();
		for (String webTitle: baseUrls.keySet()) {
			WebNode root = new WebNode(new WebPage(webTitle, baseUrls.get(webTitle)));
			WebTree tree = new WebTree(root);
			tree.createTree(root, 0);
			tree.setPostOrderScore(root);
			Filter.trees.add(tree);
		}

		Filter.quickSort(0, Filter.trees.size()-1);
		HashMap<String, String> sortedHashMap = new LinkedHashMap<>();
		for (WebTree tree: Filter.trees) {
			sortedHashMap.put(tree.root.page.title, tree.root.page.url);
		}
		return sortedHashMap;
	}

}
