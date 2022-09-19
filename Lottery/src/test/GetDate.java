package test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class GetDate {
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private static LocalDate now = LocalDate.now();

	// Lấy ngày theo tháng, bắt đầu từ ngày hiện tại
	public static List<String> getDate(int month) {
		List<String> list = new ArrayList<>();
		LocalDate startDate = now.minusMonths(month);
		List<LocalDate> listOfDates = startDate.datesUntil(now).collect(Collectors.toList());
		for (LocalDate localDate : listOfDates) {
			list.add(localDate.format(formatter));
		}
		return list;
	}
	
	// Lay ngay hien tai
	public static String getCurrentDate() {
		LocalDate current = LocalDate.now();
		return current.format(formatter);
	}
	
	public static List<String> getDate(String from, String to) {
		List<String> list = new ArrayList<>();
		String dateFrom[] = getDateArray(from);
		String dateTo[] = getDateArray(to);
		LocalDate startDate = LocalDate.of(Integer.parseInt(dateFrom[2]), Integer.parseInt(dateFrom[1]), Integer.parseInt(dateFrom[0]));
		LocalDate endDate = LocalDate.of(Integer.parseInt(dateTo[2]), Integer.parseInt(dateTo[1]), Integer.parseInt(dateTo[0]));
		
		List<LocalDate> listOfDates = startDate.datesUntil(endDate.plusDays(1)).collect(Collectors.toList());
		for (LocalDate localDate : listOfDates) {
			list.add(localDate.format(formatter));
		}
		return list;
	}
	
	public static String[] getDateArray(String date) {
		String[] value = date.split("-");
		return value;
	}
	
	public static void main(String[] args) {
		String from = "01-09-2022";
		String to = "10-09-2022";
		
		List<String> list = getDate(from, to);
		for(String str: list) {
			System.out.println(str);
		}
		
		System.out.println(getCurrentDate());
	}
}
