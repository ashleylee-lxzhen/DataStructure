import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Filter {
	public static ArrayList<WebTree> trees = new ArrayList<>();

	public static Set<Keyword> keywordsList = initKeywordsList();
	String content;

	public Filter(String content) {
		this.content = content;
	}

	public static Set<Keyword> initKeywordsList() {
        Set<Keyword> keywordsList = new HashSet<>();
       
        // ISBN號碼
        keywordsList.add(new Keyword("ISBN", 30));
        // 書名
        keywordsList.add(new Keyword("書名", 10));
        keywordsList.add(new Keyword("書籍", 10));
        // 作者
        keywordsList.add(new Keyword("作者", 8));
        keywordsList.add(new Keyword("作家", 8));
        keywordsList.add(new Keyword("譯者", 8));
        // 網路書城
        keywordsList.add(new Keyword("博客來", 3));
        keywordsList.add(new Keyword("誠品線上", 3));
        keywordsList.add(new Keyword("金石堂網路書店", 3));
        keywordsList.add(new Keyword("讀冊生活網路書店", 3));
        keywordsList.add(new Keyword("Readmoo讀墨電子書", 3));
        keywordsList.add(new Keyword("墊腳石", 3));
        keywordsList.add(new Keyword("Hami書城", 3));
        keywordsList.add(new Keyword("Rakuten Kobo", 3));
        keywordsList.add(new Keyword("全國新書資訊網", 10));
        // 出版資訊
        keywordsList.add(new Keyword("publisher", 6));
        keywordsList.add(new Keyword("出版社", 6));
        keywordsList.add(new Keyword("出版商", 6));
        keywordsList.add(new Keyword("出版日期", 4));
        keywordsList.add(new Keyword("publication date", 4));
        keywordsList.add(new Keyword("release date", 4));
        //書籍類型
        keywordsList.add(new Keyword("電子書", 4));
        keywordsList.add(new Keyword("平裝書", 4));
        keywordsList.add(new Keyword("精裝書", 4));
        //內容摘要
        keywordsList.add(new Keyword("摘要", 5));
        keywordsList.add(new Keyword("簡介", 5));
        //負權重關鍵字
        keywordsList.add(new Keyword("booking", -10)); 	//避免出現餐廳預約網站
        keywordsList.add(new Keyword("預約", -10));
        keywordsList.add(new Keyword("訂位", -10)); 
        keywordsList.add(new Keyword("inline", -10)); 
        keywordsList.add(new Keyword("地址", -10)); 
        keywordsList.add(new Keyword("餐廳", -5)); 
        keywordsList.add(new Keyword("菜單", -5)); 
        keywordsList.add(new Keyword("購物", -5)); 	 	//避免出現無關購物網站
        keywordsList.add(new Keyword("article", -5));	//避免出現部落格文章

        return keywordsList;
    }

	public int getScore() {
		int score = 0;
		for (Keyword k : keywordsList) {
			score += countKeyword(k.getName()) * k.getWeight();
		}
		return score;
	}

	public int countKeyword(String keyword) {
		// To do a case-insensitive search, we turn the whole content and keyword into
		// upper-case:
		content = content.toUpperCase();
		keyword = keyword.toUpperCase();

		int retVal = 0;
		int fromIdx = 0;
		int found = -1;

		while ((found = content.indexOf(keyword, fromIdx)) != -1) {
			retVal++;
			fromIdx = found + keyword.length();
		}

		return retVal;
	}

	private static void swap(int aIndex, int bIndex) {
		WebTree temp = trees.get(aIndex);
		trees.set(aIndex, trees.get(bIndex));
		trees.set(bIndex, temp);
	}

	public static void quickSort(int left, int right) {
		if (left < right) {
			int q = partition(left, right);
			quickSort(left, q - 1);
			quickSort(q + 1, right);
		}
	}

	private static int partition(int left, int right) {
		int i = left - 1;
		for (int j = left; j < right; j++) {
			if (trees.get(j).root.score >= trees.get(right).root.score) {
				i++;
				swap(i, j);
			}
		}
		swap(i + 1, right);
		return i + 1;
	}

}