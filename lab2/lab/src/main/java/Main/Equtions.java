package Main;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Equtions {
    Sin sin = new Sin();
    Cos cos = new Cos();
    Ln ln = new Ln();
    Tan tan = new Tan();
    Sec sec = new Sec();
    Csc csc = new Csc();
    public double run(double x,double acc) {
        double sinx = sin.getValue(x,acc);
        double cosx = cos.getValue(x,acc);
        double tanx = tan.getValue(x,acc);
        double secx = sec.getValue(x,acc);
        double cscx = csc.getValue(x,acc);
        if(x<=0){
            return (((cscx*tanx/(cosx/tanx))+secx)+(tanx+cosx))-(secx*((sinx/cscx)/cscx));
        }else {
            double lnx = ln.getValue(x,acc);
            double log10x = lnx/ln.getValue(10,acc);
            double log2x = lnx/ln.getValue(2,acc);
            double log5x = lnx/ln.getValue(5,acc);
            double lnx3 = ln.getValue(Math.pow(x,3),acc);
            double ln5 = ln.getValue(5,acc);
            return Math.pow(((log10x-log2x)+(log5x-log10x)),3)/(lnx3/ln5)-(lnx-lnx3);
        }
    }
    public double answer(double x) {
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
