package ru.itmo.potatocoder228.tpo;

public class Main {
    public static void main(String[] args) {
        try {
            CsvWriter csvWriter = new CsvWriter();
            csvWriter.setFilePathPrefix("./");
            Sin sin = new Sin((short) 2);
            Cos cos = new Cos((short) 2);
            Log2 log2 = new Log2((short) 2);
            Log3 log3 = new Log3((short) 2);
            Log10 log10 = new Log10((short) 2);
            Ln ln = new Ln((short) 2);
            FunctionsSystem system = new FunctionsSystem((short)4);
            csvWriter.write("sin.csv", sin, -3.14, 3.14, 0.1);
            csvWriter.write("cos.csv", cos, -3.14, 3.14, 0.1);
            csvWriter.write("log2.csv", log2, 3, 3.14, 0.1);
            csvWriter.write("log3.csv", log3, 3, 3.14, 0.1);
            csvWriter.write("log10.csv", log10, 3, 3.14, 0.1);
            csvWriter.write("ln.csv", ln, 3, 3.14, 0.1);
            csvWriter.write("system.csv", system, -3.14, 3.14, 0.1);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }
}