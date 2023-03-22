package Main;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Equations extends Function{
    EquationB equationB;
    EquationA equationA;
    public Equations(){
        equationB = new EquationB();
        equationA = new EquationA();
    }
    public double getValue(double x,double acc) throws IllegalArgumentException{
        if(x<=0){
            return new EquationA().getValue(x,acc);
        }else {
            return new EquationB().getValue(x,acc);
        }
    }
    public double answer(double x) throws IllegalArgumentException{
        double sinx = Math.sin(x);
        double cosx = Math.cos(x);
        double tanx = Math.tan(x);
        double secx = 1/cosx;
        double cscx = 1/sinx;
        if(x<=0){
            return (((cscx*tanx/(cosx/tanx))+secx)+(tanx+cosx))-(secx*((sinx/cscx)/cscx));
        }else {
            double lnx = Math.log(x);
            double log10x = Math.log10(x);
            double log2x = lnx/Math.log(2);
            double log5x = lnx/Math.log(5);
            double lnx3 = Math.log(Math.pow(x,3));
            double ln5 = Math.log(5);
            return Math.pow(((log10x-log2x)+(log5x-log10x)),3)/(lnx3/ln5)-(lnx-lnx3);
        }
    }
}
