package ru.itmo.potatocoder228.tpo;

public abstract class Function {

    protected short ACCURACY = 6;

    Function(short e){
        ACCURACY = e;
    }

    public double function(double x){
        return 0;
    }
    public double derivative(double x, double accuracy, long n){
        if(accuracy >= 1 || accuracy <= 0){
            return 0;
        }
        if(n==0) return function(x);
        else{
            double dx = accuracy;
            return (derivative(x+dx, accuracy, n-1) - derivative(x-dx, accuracy, n-1))/(2*dx);
        }
    }

    public long fact(long x){
        if(x <= 0) return 1;
        long result = 1;
        for(int i = 1; i<=x; i++){
            result *= i;
        } 
        return result;
    } 
}
