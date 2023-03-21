package Main;

public class EquationB extends Function{
    Sin sin = new Sin();
    Cos cos = new Cos();
    Ln ln = new Ln();
    Tan tan = new Tan();
    Sec sec = new Sec();
    Csc csc = new Csc();

    public double getValue(double x, double exc) throws IllegalArgumentException {
        double lnx = ln.getValue(x,exc);
        double log10x = lnx/ln.getValue(10,exc);
        double log2x = lnx/ln.getValue(2,exc);
        double log5x = lnx/ln.getValue(5,exc);
        double lnx3 = ln.getValue(Math.pow(x,3),exc);
        double ln5 = ln.getValue(5,exc);
        return Math.pow(((log10x-log2x)+(log5x-log10x)),3)/(lnx3/ln5)-(lnx-lnx3);

    }
}
