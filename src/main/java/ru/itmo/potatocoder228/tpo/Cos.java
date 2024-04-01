package ru.itmo.potatocoder228.tpo;

public class Cos extends Function implements Calculatable {
    private Sin sin;

    Cos(short e) {
        super(e);
        sin = new Sin(e);
    }

    @Override
    public double function(double x) {
        if (x >= 0) {
            if (Math.toDegrees(x) % 360 >= 90 && Math.toDegrees(x) % 360 <= 270)
                return -Math.sqrt(1 - Math.pow(sin.function(x), 2));
            else
                return +Math.sqrt(1 - Math.pow(sin.function(x), 2));
        }
        else{
            if (Math.toDegrees(x) % 360 <= -90 && Math.toDegrees(x) % 360 >= -270)
                return -Math.sqrt(1 - Math.pow(sin.function(x), 2));
            else
                return Math.sqrt(1 - Math.pow(sin.function(x), 2));
        }
    }
}
