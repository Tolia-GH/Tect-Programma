package Main;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EquationA extends Function{
    Sin sin;
    Cos cos;
    Tan tan;
    Sec sec;
    Csc csc;
    public EquationA(){
        sin = new Sin();
        cos = new Cos();
        tan = new Tan();
        sec = new Sec();
        csc = new Csc();
    }
    @Override
    public double getValue(double x, double exc) throws IllegalArgumentException {
        double sinx = sin.getValue(x,exc);
        double cosx = cos.getValue(x,exc);
        double tanx = tan.getValue(x,exc);
        double secx = sec.getValue(x,exc);
        double cscx = csc.getValue(x,exc);
        return (((cscx*tanx/(cosx/tanx))+secx)+(tanx+cosx))-(secx*((sinx/cscx)/cscx));
    }
}
