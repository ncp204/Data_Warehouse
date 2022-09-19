package excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import test.Lottery;
import test.Lottery;

public class ExportFileExcel {
	private static XSSFCellStyle createStyleForTitle(XSSFWorkbook workbook) {
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		return style;
	}

	public static void exportExcel(String date, List<Lottery> listLotteries, String region) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Kết quả xổ số");
		sheet.setColumnWidth(0, 15 * 256);
		sheet.setColumnWidth(1, 15 * 256);
		sheet.setColumnWidth(2, 20 * 256);
		// Prize
		sheet.setColumnWidth(3, 15 * 256);
		sheet.setColumnWidth(4, 15 * 256);
		sheet.setColumnWidth(5, 15 * 256);
		sheet.setColumnWidth(6, 20 * 256);
		sheet.setColumnWidth(7, 25 * 256);
		sheet.setColumnWidth(8, 15 * 256);
		sheet.setColumnWidth(9, 20 * 256);
		sheet.setColumnWidth(10, 15 * 256);
		sheet.setColumnWidth(11, 15 * 256);

		int rownum = 0;
		Cell cell;
		Row row;
		//
		XSSFCellStyle style = createStyleForTitle(workbook);

		row = sheet.createRow(rownum);

		// Miền
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("Xổ Số Miền");
		cell.setCellStyle(style);
		// Tỉnh
		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Tỉnh");
		cell.setCellStyle(style);
		// Ngày tháng năm
		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Ngày-tháng-năm");
		cell.setCellStyle(style);
		// Giải
		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Giải đặc biệt");
		cell.setCellStyle(style);
		
		cell = row.createCell(4, CellType.STRING);
		cell.setCellValue("Giải nhất");
		cell.setCellStyle(style);
		
		cell = row.createCell(5, CellType.STRING);
		cell.setCellValue("Giải nhì");
		cell.setCellStyle(style);
		
		cell = row.createCell(6, CellType.STRING);
		cell.setCellValue("Giải ba");
		cell.setCellStyle(style);

		cell = row.createCell(7, CellType.STRING);
		cell.setCellValue("Giải bốn");
		cell.setCellStyle(style);

		cell = row.createCell(8, CellType.STRING);
		cell.setCellValue("Giải năm");
		cell.setCellStyle(style);

		cell = row.createCell(9, CellType.STRING);
		cell.setCellValue("Giải sáu");
		cell.setCellStyle(style);

		cell = row.createCell(10, CellType.STRING);
		cell.setCellValue("Giải bảy");
		cell.setCellStyle(style);

		cell = row.createCell(11, CellType.STRING);
		cell.setCellValue("Giải tám");
		cell.setCellStyle(style);

		// Data
		for (Lottery lottery : listLotteries) {
			rownum++;
			row = sheet.createRow(rownum);

			// Miền
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue(region);
			// Tỉnh
			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(lottery.getProvince());
			// Ngày tháng năm
			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue(lottery.getDate());
			// Giải
			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue(lottery.getPrizeDB());
			
			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue(lottery.getPrize1());

			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue(lottery.getPrize2());

			cell = row.createCell(6, CellType.STRING);
			cell.setCellValue(lottery.getPrize3());

			cell = row.createCell(7, CellType.STRING);
			cell.setCellValue(lottery.getPrize4());

			cell = row.createCell(8, CellType.STRING);
			cell.setCellValue(lottery.getPrize5());

			cell = row.createCell(9, CellType.STRING);
			cell.setCellValue(lottery.getPrize6());

			cell = row.createCell(10, CellType.STRING);
			cell.setCellValue(lottery.getPrize7());

			cell = row.createCell(11, CellType.STRING);
			cell.setCellValue(lottery.getPrize8());
		}
		switch (region.toUpperCase()) {
		case "BẮC":
			region = "XSMB";
			break;
		case "TRUNG":
			region = "XSMT";
			break;
		case "NAM":
			region = "XSMN";
			break;
		default:
			region = "KQXS";
			break;
		}
		File file = new File("fileCSV/" + region + "-" + date + ".xlsx");
		file.getParentFile().mkdirs();

		FileOutputStream outFile = new FileOutputStream(file);
		workbook.write(outFile);
		workbook.close();
		outFile.close();
		System.out.println("Created file: " + file.getAbsolutePath());
	}
}
