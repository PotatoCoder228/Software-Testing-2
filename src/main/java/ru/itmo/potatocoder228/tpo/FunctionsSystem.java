package ru.itmo.potatocoder228.tpo;

public class FunctionsSystem implements Calculatable {
    private Sin sin;
    private Cos cos;
    private Log2 log2;
    private Log3 log3;
    private Log10 log10;
    private Ln ln;

    FunctionsSystem(short e) {
        sin = new Sin(e);
        cos = new Cos(e);
        log2 = new Log2(e);
        log3 = new Log3(e);
        log10 = new Log10(e);
        ln = new Ln(e);
    }

    public double function(double x) {
        if (x <= 0) {
            return cos.function(x) / sin.function(x);
        } else {
            return (((((log3.function(x) - ln.function(x)) - log2.function(x)) - log3.function(x))
                    * Math.pow(log10.function(x), 3)));
        }
    }
}
