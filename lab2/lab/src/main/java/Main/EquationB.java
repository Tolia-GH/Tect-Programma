package Main;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EquationB extends Function{
    Ln ln;

    public EquationB(){
        ln = new Ln();
    }
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
