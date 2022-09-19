package test;

public class MainTest {
	public static void main(String[] args) {
		WebScrape scrape = new WebScrape();
		scrape.setDateRandom("15-09-2022");
//		scrape.handleScrape(scrape.BAC);
//		scrape.handleScrape(scrape.TRUNG);
		//scrape.handleScrape(scrape.NAM);
		scrape.handleScrape2(scrape.NAM);
	}
}
