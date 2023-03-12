package Main;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Sec extends Function{
    public double getValue(double x, double exc) {
        double currentResult = new Cos().getValue(transferToPi(x),exc);
        if(currentResult == 0.0){
            return Double.POSITIVE_INFINITY;
        }
        return 1/currentResult;
    }
}
