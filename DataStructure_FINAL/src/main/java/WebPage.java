


public class WebPage {
    public String title;
    public String url;
    public String content;
    public double score;
    public Filter filter;
    public Parser parser;

    public WebPage(String title, String url) {
        try {
            this.title = title;
            this.url = url;
            System.out.println("children: "+url);
            this.content = Scrapper.fetchContent(url);
            this.score = 0;
            this.filter = new Filter(this.content);
            this.parser = new Parser(this.content);
        } catch (Exception e) {
        	System.out.println("Encounter Exception when establishing webpage");
        	e.printStackTrace();
        }
    }

    public void setScore() {
    	if(filter != null) {
            this.score = filter.getScore();
    	} else {
    		System.out.println("Filter is null, cannot calculate score");
    	}
    }
}
