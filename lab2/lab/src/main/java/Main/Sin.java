package Main;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Sin extends Function{
    @Override
    public double getValue(double x, double exc) throws IllegalArgumentException{
        x = transferToPi(x);
        if(exc <= 0){
            throw new IllegalArgumentException("Accuracy should be bigger than 0\n");
        }
        if(x==Math.PI||x==0){
            return 0;
        }
        if(x==Math.PI/2){
            return 1;
        }
        if(x==Math.PI*3/2){
            return -1;
        }
        double lastResult = x;
        double a = -1;
        double b = fact(3);
        double c = Math.pow(x,3);
        int k = 1;
        double currentResult = a*c/b + x;
        while(Math.abs(currentResult - lastResult) >= exc/1000){
            k++;
            a = Math.pow(-1,k);
            b = fact(2*k+1);
            c = Math.pow(x,(double) 2*k+1);
            lastResult = currentResult;
            currentResult = currentResult + a*c/b;
        }
        return currentResult;
    }
}
