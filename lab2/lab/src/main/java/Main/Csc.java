package Main;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Csc extends Function{
    @Override
    public double getValue(double x, double exc) throws IllegalArgumentException {
        x = transferToPi(x);
        double sin = new Sin().getValue(x,exc);
        if(sin == 0){
            return Double.POSITIVE_INFINITY;
        }else {
            return 1/sin;
        }
    }
}
