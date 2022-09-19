package test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import excel.ExportFileExcel;

public class WebScrape {
	public static final String BAC = "BAC";
	public static final String TRUNG = "TRUNG";
	public static final String NAM = "NAM";

	public static final String DB = "ĐB";
	public static final String G1 = "G.1";
	public static final String G2 = "G.2";
	public static final String G3 = "G.3";
	public static final String G4 = "G.4";
	public static final String G5 = "G.5";
	public static final String G6 = "G.6";
	public static final String G7 = "G.7";
	public static final String G8 = "G.8";

	private static List<String> listDate = new ArrayList<String>();
	private static String fromDate = "14-09-2022";
	private static String toDate = "15-09-2022";

	private static InputStream input;

	private static Lottery test;
	private static List<Lottery> listLottery = new ArrayList<Lottery>();

	public static String getURL(String region) {
		if (region.equals(BAC)) {
			return "https://ketqua.me/xsmb-xo-so-mien-bac-ngay-";
		}
		if (region.equals(TRUNG)) {
			return "https://ketqua.me/xsmt-xo-so-mien-trung-ngay-";
		}
		if (region.equals(NAM)) {
			return "https://ketqua.me/xsmn-xo-so-mien-nam-ngay-";
		}
		return null;
	}

	public void setCurrentDate() {
		listDate.clear();
		listDate.add(GetDate.getCurrentDate());
	}

	public void setDateFromTo(String fromDate, String toDate) {
		listDate.clear();
		listDate = GetDate.getDate(fromDate, toDate);
	}

	public void setDateRandom(String date) {
		listDate.clear();
		listDate.add(date);
	}

	public static void handleScrape(String region) {
		if (listDate == null) {
			System.out.println("Chua chon ngay lay ket qua xo so");
		} else {
			try {
				for (String dmy : listDate) {
					input = new URL(getURL(region) + dmy).openStream();
					Document doc = Jsoup.parse(input, "utf-8", getURL(region) + dmy);

					// Lấy bảng danh sách kết quả
					Elements table = doc.getElementsByClass("table-tructiep").select("table");
					if (table.html().equals("")) {
						table = doc.getElementsByClass("result-box").select("table");
					}
					// Lấy các tỉnh
					Elements provinces = table.select("thead tr th:not(:first-child)");
					if (provinces.html().equals("") || provinces.html() == null) {
						test = new Lottery();
						test.setProvince("");
						listLottery.add(test);
					} else {
						provinces.forEach(element -> {
							test = new Lottery();
							test.setProvince(element.html());
							listLottery.add(test);
						});
					}

					Elements elements = table.select("tbody tr");
					handleExecuteData(listLottery, elements, dmy);

					ExportFileExcel.exportExcel(dmy, listLottery, region);
					listLottery.clear();
					input.close();
				}

			} catch (IOException e) {
				System.out.println("Lỗi khi truy cập đường dẫn url");
				e.printStackTrace();
			}
		}
	}

	public static void handleExecuteData(List<Lottery> listLottery, Elements elements, String date) {
		elements.forEach(e -> {
			setPrize(e, listLottery);
		});
		for (Lottery o : listLottery) {
			o.setDate(date);
			o.replaceSpaceToMinus();
		}
	}

	public static void setPrize(Element element, List<Lottery> listLottery) {
		Elements elements = element.select("tr td:not(:first-child)");
		boolean sample = (elements.size() == listLottery.size());
		if (sample) {
			String prize = element.select("tr td:first-child").html();
			switch (prize) {
			case DB:
				executeSetPrize(elements, DB);
				break;
			case G1:
				executeSetPrize(elements, G1);
				break;
			case G2:
				executeSetPrize(elements, G2);
				break;
			case G3:
				executeSetPrize(elements, G3);
				break;
			case G4:
				executeSetPrize(elements, G4);
				break;
			case G5:
				executeSetPrize(elements, G5);
				break;
			case G6:
				executeSetPrize(elements, G6);
				break;
			case G7:
				executeSetPrize(elements, G7);
				break;
			case G8:
				executeSetPrize(elements, G8);
				break;
			default:
				break;
			}
		}
	}

	public static void executeSetPrize(Elements elements, String prizeName) {
		for (int i = 0; i < listLottery.size(); i++) {
			String value = elements.get(i).text();
			switch (prizeName) {
			case DB:
				listLottery.get(i).setPrizeDB(value);
				break;
			case G1:
				listLottery.get(i).setPrize1(value);
				break;
			case G2:
				listLottery.get(i).setPrize2(value);
				break;
			case G3:
				listLottery.get(i).setPrize3(value);
				break;
			case G4:
				listLottery.get(i).setPrize4(value);
				break;
			case G5:
				listLottery.get(i).setPrize5(value);
				break;
			case G6:
				listLottery.get(i).setPrize6(value);
				break;
			case G7:
				listLottery.get(i).setPrize7(value);
				break;
			case G8:
				listLottery.get(i).setPrize8(value);
				break;
			default:
				break;
			}
		}
	}
}
