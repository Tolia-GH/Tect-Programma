package Main;

import java.io.*;
import java.nio.charset.StandardCharsets;
import com.opencsv.CSVWriter;

public abstract class Function {
    final private double PI = Math.PI;

    /**
     * Some mathematical problem. If number of iterations too big, we will get NAN during the iteration.
     * Because double can't represent such a big or small number.
     *  If number of iterations too small. Then the result maybe can't get the answer with the accuracy we want.
     *  So it's pretty hard to deal with accuracy and the reliability of system.
     * @param x
     * @param exc
     * @return
     * @throws IllegalArgumentException
     */
    public abstract double getValue(double x, double exc) throws IllegalArgumentException;


    public void writeResultToCSV(double x,double result, String fileName) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(fileName,true));
        //Create record
        String []record ={Double.toString(x),Double.toString(result)};
        //Write the record to file
        writer.writeNext(record);
        //close the writer
        writer.close();
    }
    /**
     * translate x to (-PI,PI]
     * @param x
     * @return
     */
    double transferToPi(double x){
        if(x >= 0 ){
            double result = x%(2*PI);
            if(result >= PI){
                return result - 2*PI;
            }
            return result;
        }else{
            double y = -x;
            int coff = (int)(y/(2*PI));
            double result = (coff + 1)*2*PI + x ;
            if(result >= PI){
                return result - 2*PI;
            }
            return result;
        }
    }
    /**
     * translate x to (-PI/2,PI/2]
     * @param x
     * @return
     */
    double transferHalfPi(double x){
        if(x >= 0 ){
            double result = x%(PI);
            if(result >= PI/2){
                return result - PI;
            }
            return result;
        }else{
            double y = -x;
            int coff = (int)(y/(PI));
            double result = (coff + 1)*PI + x ;
            if(result >= PI/2){
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
