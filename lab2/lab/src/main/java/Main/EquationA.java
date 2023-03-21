package Main;

public class EquationA extends Function{
    Sin sin = new Sin();
    Cos cos = new Cos();
    Ln ln = new Ln();
    Tan tan = new Tan();
    Sec sec = new Sec();
    Csc csc = new Csc();
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
