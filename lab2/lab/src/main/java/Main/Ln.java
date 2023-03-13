package Main;

public class Ln extends Function{
    @Override
    public double getValue(double x, double exc) {
        if(exc<=0){
            throw new IllegalArgumentException("Accuracy should be bigger than 0\n");
        }
        if(x <= 0){
            throw new IllegalArgumentException("x should be > 0\n");
        }
        if(x==Double.MAX_VALUE){
            return Double.NEGATIVE_INFINITY;
        }else if(x==1){
            return 0;
        }
        int k = 1;
        double y = (x-1)/(x+1);
        double currentResult = 2*y*(Math.pow(y,2)/3+1);
        double exp = currentResult;
        while(Math.abs(exp) >= exc/100000){
            k++;
            exp =  2*y*((Math.pow(y,2*k))/(double)(2*k+1));
            currentResult = currentResult + exp;
        }
        return currentResult;
    }
}
