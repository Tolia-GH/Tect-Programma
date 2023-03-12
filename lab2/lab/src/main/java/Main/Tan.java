package Main;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Tan extends Function{
    @Override
    public double getValue(double x, double exc) throws IllegalArgumentException {
        x = transferHalfPi(x);
        if(Math.abs(x - Math.PI/2)<=0.000000000000001){
            if(x<0){
                return Double.NEGATIVE_INFINITY;
            }else if(x>0){
                return Double.POSITIVE_INFINITY;
            }
        }
        if(x==0){
            return 0;
        }
        Sin sin = new Sin();
        Cos cos = new Cos();
        return sin.getValue(x,exc)/cos.getValue(x,exc);
    }

}
