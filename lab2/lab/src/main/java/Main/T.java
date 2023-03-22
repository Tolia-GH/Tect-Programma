package Main;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class T {
    public static void main(String[] args) throws IOException {
        Sin sin = new Sin();
        Cos cos = new Cos();
        Ln ln = new Ln();
        Tan tan = new Tan();
        Sec sec = new Sec();
        Csc csc = new Csc();
        double[] array = {1,2,3,-1,0,-2,-3,100,3.1415926,-3.14};
        for(double i : array){
            sin.writeResultToCSV(i,sin.getValue(i,0.01),"src/main/java/Test/Resources/sin.csv");
            sin.writeResultToCSV(i,cos.getValue(i,0.01),"src/main/java/Test/Resources/cos.csv");
            sin.writeResultToCSV(i,tan.getValue(i,0.01),"src/main/java/Test/Resources/tan.csv");
            if(i<=0){
                String fileName = "src/main/java/Test/Resources/ln.csv";
                CSVWriter writer = new CSVWriter(new FileWriter(fileName,true));
                //Create record
                String []record ={Double.toString(i),"NaN"};
                //Write the record to file
                writer.writeNext(record);
                //close the writer
                writer.close();
            }else {
                sin.writeResultToCSV(i, ln.getValue(i, 0.01), "src/main/java/Test/Resources/ln.csv");
            }
            sin.writeResultToCSV(i,sec.getValue(i,0.01),"src/main/java/Test/Resources/sec.csv");
            sin.writeResultToCSV(i,csc.getValue(i,0.01),"src/main/java/Test/Resources/csc.csv");
        }
    }
}
