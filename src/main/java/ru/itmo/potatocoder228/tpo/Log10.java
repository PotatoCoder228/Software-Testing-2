package ru.itmo.potatocoder228.tpo;

public class Log10 extends Function implements Calculatable{
    private Ln ln;

    Log10(short e){
        super(e);
        ln = new Ln(e);
    }
    @Override
    public double derivative(double x, double accuracy, long n){
        if(x<0.0001) return 0;
        if(accuracy >= 1 || accuracy <= 0){
            return 0;
        }
        if(n==0) return function(x);
        else{
            double dx = accuracy;
            return (derivative(x+dx, accuracy, n-1) - derivative(x-dx, accuracy, n-1))/(2*dx);
        }
    }

    @Override
    public double function(double x){
        if(x<=0) return 0;
        return ln.function(x)/ln.function(10);
    } 
}
