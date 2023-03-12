package Main;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Cos extends Function{
    @Override
    public double getValue(double x, double exc) {
        x = transferToPi(x);
        if(exc <= 0){
            throw new IllegalArgumentException("Accuracy should be bigger than 0\n");
        }
        if(x==Math.PI/2||x==Math.PI*3/2){
            return 0;
        }
        if(x==0){
            return 1;
        }
        if(x==Math.PI){
            return -1;
        }
        double lastResult = 1;
        double a = -1;
        double b = fact(2);
        double c = Math.pow(x,2);
        int k = 1;
        double currentResult = a*c/b + 1;
        while(Math.abs(currentResult - lastResult) >= exc/100000){
            k++;
            a = Math.pow(-1,k);
            b = fact(2*k);
            c = Math.pow(x,(double) 2*k);
            lastResult = currentResult;
            currentResult = currentResult + a*c/b;
        }
        return currentResult;
    }
}
