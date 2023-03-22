package Test;

import Main.*;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class FunctionTest {
    @Nested
    class IntegrationWithMock{
        final static Double ACC = 0.1;
        static Csc cscMock = mock(Csc.class);
        static Cos cosMock = mock(Cos.class);
        static Sin sinMock = mock(Sin.class);
        static Ln lnMock = mock(Ln.class);
        static Tan tanMock = mock(Tan.class);
        static Sec secMock = mock(Sec.class);

        @BeforeAll
        static void initAll(){
            String fileSin = "src/main/java/Test/Resources/sin.csv";
            String fileCos = "src/main/java/Test/Resources/cos.csv";
            String fileTan = "src/main/java/Test/Resources/tan.csv";
            String fileLn = "src/main/java/Test/Resources/ln.csv";
            String fileCsc = "src/main/java/Test/Resources/csc.csv";
            String fileSec = "src/main/java/Test/Resources/sec.csv";
            List<String> files = new ArrayList<>();
            files.add(fileSin);
            files.add(fileCos);
            files.add(fileTan);
            files.add(fileLn);
            files.add(fileCsc);
            files.add(fileSec);
            int i = 0;
            while(i < 6){
                try (FileInputStream fis = new FileInputStream(files.get(i));
                     InputStreamReader isr = new InputStreamReader(fis,
                             StandardCharsets.UTF_8);
                     CSVReader reader = new CSVReader(isr)) {
                    String[] nextLine;

                    while ((nextLine = reader.readNext()) != null) {
                        switch(i){
                            case 0:
                                Mockito.when(sinMock.getValue(Double.parseDouble(nextLine[0]),ACC)).thenReturn(Double.parseDouble(nextLine[1]));
                                break;
                            case 1:
                                Mockito.when(cosMock.getValue(Double.parseDouble(nextLine[0]),ACC)).thenReturn(Double.parseDouble(nextLine[1]));
                                break;
                            case 2:
                                Mockito.when(tanMock.getValue(Double.parseDouble(nextLine[0]),ACC)).thenReturn(Double.parseDouble(nextLine[1]));
                                break;
                            case 3:
                                Mockito.when(lnMock.getValue(Double.parseDouble(nextLine[0]),ACC)).thenReturn(Double.parseDouble(nextLine[1]));
                                break;
                            case 4:
                                Mockito.when(cscMock.getValue(Double.parseDouble(nextLine[0]),ACC)).thenReturn(Double.parseDouble(nextLine[1]));
                                break;
                            case 5:
                                Mockito.when(secMock.getValue(Double.parseDouble(nextLine[0]),ACC)).thenReturn(Double.parseDouble(nextLine[1]));
                                break;
                            default:
                                return;
                        }
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                i++;
            }
        }

        @ParameterizedTest
        @CsvFileSource(resources = "/resource.csv")
        void testSystem(double x){
            EquationA a = new EquationA(sinMock,cosMock,tanMock,secMock,cscMock);
            EquationB b = new EquationB(lnMock);
            Equations equations = new Equations(b,a);
            assertEquals(equations.answer(x),equations.getValue(x,ACC),ACC);
        }

        @ParameterizedTest
        @CsvFileSource(resources = "/resource.csv")
        void testSin(double x){
            EquationA a = new EquationA(new Sin(),cosMock,tanMock,secMock,cscMock);
            EquationB b = new EquationB(lnMock);
            Equations equations = new Equations(b,a);
            assertEquals(equations.answer(x),equations.getValue(x,ACC),ACC);
        }

        @ParameterizedTest
        @CsvFileSource(resources = "/resource.csv")
        void testCos(double x){
            EquationA a = new EquationA(sinMock,new Cos(),tanMock,secMock,cscMock);
            EquationB b = new EquationB(lnMock);
            Equations equations = new Equations(b,a);
            assertEquals(equations.answer(x),equations.getValue(x,ACC),ACC);
        }

        @ParameterizedTest
        @CsvFileSource(resources = "/resource.csv")
        void testTan(double x){
            EquationA a = new EquationA(sinMock,cosMock,new Tan(),secMock,cscMock);
            EquationB b = new EquationB(lnMock);
            Equations equations = new Equations(b,a);
            assertEquals(equations.answer(x),equations.getValue(x,ACC),ACC);
        }
        @ParameterizedTest
        @CsvFileSource(resources = "/resource.csv")
        void testCsc(double x){
            EquationA a = new EquationA(sinMock,cosMock,tanMock,secMock,new Csc());
            EquationB b = new EquationB(lnMock);
            Equations equations = new Equations(b,a);
            assertEquals(equations.answer(x),equations.getValue(x,ACC),ACC);
        }
        @ParameterizedTest
        @CsvFileSource(resources = "/resource.csv")
        void testSec(double x){
            EquationA a = new EquationA(sinMock,cosMock,tanMock,new Sec(),cscMock);
            EquationB b = new EquationB(lnMock);
            Equations equations = new Equations(b,a);
            assertEquals(equations.answer(x),equations.getValue(x,ACC),ACC);
        }
        @ParameterizedTest
        @CsvFileSource(resources = "/resource.csv")
        void testLn(double x){
            EquationA a = new EquationA(sinMock,cosMock,tanMock,secMock,cscMock);
            EquationB b = new EquationB(new Ln());
            Equations equations = new Equations(b,a);
            assertEquals(equations.answer(x),equations.getValue(x,ACC),ACC);
        }
    }
    @Nested
    class Integration{
        Equations equations = new Equations();
        final Double ACC = 0.1;
        @ParameterizedTest
        @ValueSource(doubles ={5,7,10,-100,0,55})
        void testEqutions(double x){
            try {
                equations.writeResultToCSV(x, equations.getValue(x, ACC), "src/main/java/Test/Resources/equations.csv");
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
            assertEquals(equations.answer(x), equations.getValue(x,ACC),ACC);
        }
    }
    @Nested
    class BasicFuntionsTest {
        Sin sin = new Sin();
        Cos cos = new Cos();
        Ln ln = new Ln();
        Tan tan = new Tan();
        Sec sec = new Sec();
        Csc csc = new Csc();
        final double PI = Math.PI;
        final Double ACC = 0.01;

        @ParameterizedTest
        @ValueSource(doubles = {-1000,-10*PI,-2*PI,-1.5*PI,-0.5*PI,0,0.5*PI,1.5*PI,2*PI,10*PI,1000})
        void testSin(double x) {
            try {
                sin.writeResultToCSV(x, sin.getValue(x, ACC), "src/main/java/Test/Resources/sin.csv");
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
            assertEquals(Math.sin(x), sin.getValue(x, ACC), ACC);
            /*try {
                sin.writeResultToCSV(x, sin.getValue(x, ACC), "./Resources/sin.csv");
            }catch (IOException e){
                System.out.println(e.getMessage());
            }*/
        }

        @ParameterizedTest
        @ValueSource(doubles = {-1000,-10*PI,-2*PI,-1.5*PI,-0.5*PI,0,0.5*PI,1.5*PI,2*PI,10*PI,1000})
        void testCos(double x) {
            try {
                cos.writeResultToCSV(x, cos.getValue(x, ACC), "src/main/java/Test/Resources/cos.csv");
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
            assertEquals(Math.cos(x), cos.getValue(x, ACC), ACC);
        }

        @ParameterizedTest
        @ValueSource(doubles = {1,23,44,55,0.5*PI,1.5*PI,2*PI,10*PI,1000})
        void testLn(double x) {
            assertEquals(Math.log(x), ln.getValue(x, ACC), ACC);
        }

        @ParameterizedTest
        @ValueSource(doubles = {-12,-PI,-1,0,1,PI,12})
        void testTan(double x) {
            assertEquals(Math.tan(x), tan.getValue(x, ACC), ACC);
        }

        @ParameterizedTest
        @ValueSource(doubles = {-1000,-10*PI,-2*PI,0,2*PI,10*PI,1000})
        void testSec(double x) {
            assertEquals(1 / Math.cos(x), sec.getValue(x, ACC), ACC);
        }
        @ParameterizedTest
        @ValueSource(doubles = {-1000,-1.5*PI,-0.5*PI,0,0.5*PI,1.5*PI,1000})
        void testCsc(double x) {
            assertEquals(1 / Math.sin(x), csc.getValue(x, ACC), ACC);
        }

        @ParameterizedTest
        @ValueSource(doubles = {-1,0,-21,-PI})
        @DisplayName("Check IllegalArgumentException when accuracy <= 0. Parameter is accuracy")
        void testSinAccuracy(double x) {
            Exception e = assertThrows(IllegalArgumentException.class, ()->sin.getValue(1,x));
            assertEquals("Accuracy should be bigger than 0\n", e.getMessage());
        }

        @ParameterizedTest
        @ValueSource(doubles = {-1,0,-21,-PI})
        @DisplayName("Check IllegalArgumentException when accuracy <= 0. Parameter is accuracy")
        void testCosAccuracy(double x) {
            Exception e = assertThrows(IllegalArgumentException.class, ()->cos.getValue(1,x));
            assertEquals("Accuracy should be bigger than 0\n", e.getMessage());
        }

        @ParameterizedTest
        @ValueSource(doubles = {-1,0,-21,-PI})
        @DisplayName("Check IllegalArgumentException when accuracy <= 0. Parameter is accuracy")
        void testLnAccuracy(double x) {
            Exception e = assertThrows(IllegalArgumentException.class, ()->ln.getValue(1,x));
            assertEquals("Accuracy should be bigger than 0\n", e.getMessage());
        }

        @ParameterizedTest
        @ValueSource(doubles = {0,-21,-PI})
        @DisplayName("Check IllegalArgumentException when accuracy <= 0. Parameter is accuracy")
        void testLnScope(double x) {
            Exception e = assertThrows(IllegalArgumentException.class, ()->ln.getValue(x,ACC));
            assertEquals("x should be > 0\n", e.getMessage());
        }
    }

}
