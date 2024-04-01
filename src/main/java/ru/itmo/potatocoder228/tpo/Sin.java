package ru.itmo.potatocoder228.tpo;

public class Sin extends Function implements Calculatable {

    Sin(short e) {
        super(e);
    }

    @Override
    public double function(double x) {
        return powerSeries(x - 0.00001F, x, (long) super.ACCURACY);
    }

    private double powerSeries(double x0, double x, long power) {
        if (power <= 0 || x0 >= x)
            return 0;
        double result = 0;
        double sign = 1;
        for (long i = 0; i <= power; i++) {
            if (i == 0)
                result += x;
            else
                result += sign * (Math.pow(x, ((2 * i) + 1)) / fact((2 * i) + 1));
            sign = -sign;
        }
        return result;
    }
}
