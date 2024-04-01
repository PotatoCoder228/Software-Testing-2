package ru.itmo.potatocoder228.tpo;

public class Ln extends Function implements Calculatable {
    
    Ln(short e){
        super(e);
    }
    
    @Override
    public double function(double x){
        if(x<=0) return 0;
        return powerSeries(x-0.00001F, x, super.ACCURACY);
    }

    @Override
    public double derivative(double x, double accuracy, long n) {
        if(x<0.0001) return 0;
        if(n==0) return Math.log(x);
        if(n==1) return 1/x;
        else{
            return -(this.fact(n))/Math.pow(x,n);
        }
    }

    public double powerSeries(double x0, double x, long power){
        if(x<=0) return 0;
        if(power <= 0 || x0>=x) return 0;
        double result = 0;
        for (long i = 0; i<=power; i++){
            if(i == 0) result += derivative(x, 1/ACCURACY, 0);
            else result += (derivative(x0, 1/Math.pow(10, power), i)*Math.pow(x-x0,i)/fact(i));
        }
        return result;
    }
}
