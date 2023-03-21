package Main;

public abstract class Function {
    final private double PI = Math.PI;

    public abstract double getValue(double x, double exc) throws IllegalArgumentException;

    /**
     * translate x to [-PI,PI]
     * @param x
     * @return
     */
    double transferToPi(double x){
        if(x >= 0 ){
            double result = x%(2*PI);
            if(result > PI){
                return result - 2*PI;
            }
            return result;
        }else{
            double y = -x;
            int coff = (int)(y/(2*PI));
            double result = (coff + 1)*2*PI + x ;
            if(result > PI){
                return result - 2*PI;
            }
            return result;
        }
    }
    /**
     * translate x to [-PI/2,PI/2]
     * @param x
     * @return
     */
    double transferHalfPi(double x){
        if(x >= 0 ){
            double result = x%(PI);
            if(result > PI/2){
                return result - PI;
            }
            return result;
        }else{
            double y = -x;
            int coff = (int)(y/(PI));
            double result = (coff + 1)*PI + x ;
            if(result > PI/2){
                return result - PI;
            }
            return result;
        }
    }
    int fact(int i){
        int result = 1;
        while(i>1){
            result = result * i;
            i--;
        }
        return result;
    }
}
