package ru.itmo.potatocoder228.tpo;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Locale;

public class CsvWriter {
    private String filePathPrefix = "src/";
    private char CSV_SEPARATOR = ';';

    public void setFilePathPrefix(String prefix){
        filePathPrefix = prefix;
    }

    public void write(String fileName, Calculatable calculator, double from, double to, double step) {
        String filePath = filePathPrefix + fileName;
        double y;
        try (PrintStream printStream = new PrintStream(new FileOutputStream(filePath, true))) {
            for (double x = from; x <= to; x += step) {
                try {
                    y = calculator.function(x);
                } catch (IllegalArgumentException | ArithmeticException e) {
                    System.err.println(e.getMessage() + ", x=" + x);
                    continue;
                }
                printStream.printf(Locale.US, "%f%c %f\n", x, CSV_SEPARATOR, y);
            }
        } catch (Exception e) {
            System.err.println("Can't write to file: " + e.getMessage());
        }
    }
}
