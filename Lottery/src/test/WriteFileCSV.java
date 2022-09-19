package test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class WriteFileCSV {
	public static void init(Path path) {
        try {
            Files.createDirectory(path);
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
    public static void write(Path path, String dirSource, ArrayList<Lottery> lotteries) throws IOException {
       // init(path);     
        try (BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(new FileOutputStream(dirSource)))) {
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
            bw.write(",");
            bw.write("Info Prize");
            bw.newLine();
            for (Lottery lottery : lotteries) {
                bw.write("");
                bw.write(",");
                bw.write(lottery.getProvince());
                bw.write(",");
                bw.write(lottery.getDate());
                bw.write(",");
                bw.write("");
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
        System.out.println("Write file to "+dirSource+" success");
    }
}

