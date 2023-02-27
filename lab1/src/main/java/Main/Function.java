package Main;

public class Function {
    public final static double PI = Math.PI;

    public double arcsin(double x) {
        if (x > 1 || x < -1) {
            throw new IllegalArgumentException("The domain of arcsin is [-1,1].");
        } else {
            double i = -PI/2, j = PI/2;
            double result = (i + j) / 2;
            double judge = Math.sin(result) - x;
            double temp;
            while (Math.abs(judge) > 1e-20) {
                result = (i + j) / 2;
                temp = Math.sin(result);
                if (temp - x > 0) {
                    j = result;
                } else {
                    i = result;
                }
                judge = Math.sin(result) - x;
            }
            return result;
        }

    }
}
