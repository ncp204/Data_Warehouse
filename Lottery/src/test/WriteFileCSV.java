package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WriteFileCSV {
	public static void init(Path path) {
        try {
            Files.createDirectory(path);
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
    public static void write(List<Lottery> listLottery, String region, String date) throws IOException {
    	switch (region.toUpperCase()) {
		case "BAC":
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
    	
    	String dest = "fileCSV/data_lotteries_" + region + "." + date + "_datawarehouse-localhost.csv";
    	File file = new File(dest);
       // init(path);   
    	
        try (BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(new FileOutputStream(file)))) {
            bw.write("Company");
            bw.write(",");
            bw.write("Province");
            bw.write(",");
            bw.write("Issue Date");
            bw.write(",");
            bw.write("Prize 0");
            bw.write(",");
            bw.write("Prize 1");
            bw.write(",");
            bw.write("Prize 2");
            bw.write(",");
            bw.write("Prize 3");
            bw.write(",");
            bw.write("Prize 4");
            bw.write(",");
            bw.write("Prize 5");
            bw.write(",");
            bw.write("Prize 6");
            bw.write(",");
            bw.write("Prize 7");
            bw.write(",");
            bw.write("Prize 8");
            bw.newLine();
            for (Lottery lottery : listLottery) {
                bw.write(region);
                bw.write(",");
                bw.write(lottery.getProvince());
                bw.write(",");
                bw.write(lottery.getDate());
                bw.write(",");
                bw.write(lottery.getPrizeDB());
                bw.write(",");
                bw.write(lottery.getPrize1());
                bw.write(",");
                bw.write(lottery.getPrize2());
                bw.write(",");
                bw.write(lottery.getPrize3());
                bw.write(",");
                bw.write(lottery.getPrize4());
                bw.write(",");
                bw.write(lottery.getPrize5());
                bw.write(",");
                bw.write(lottery.getPrize6());
                bw.write(",");
                bw.write(lottery.getPrize7());
                bw.write(",");
                bw.write(lottery.getPrize8());
                bw.newLine();
                ;
            }
        }
        System.out.println("Tao file thanh cong voi duong dan: "+file.getAbsolutePath());
    }
}