package Test;

import Main.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class FunctionTest {
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
            assertEquals(Math.sin(x), sin.getValue(x, ACC), ACC);
        }

        @ParameterizedTest
        @ValueSource(doubles = {-1000,-10*PI,-2*PI,-1.5*PI,-0.5*PI,0,0.5*PI,1.5*PI,2*PI,10*PI,1000})
        void testCos(double x) {
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
    }
    @Nested
    class Integration{
        Equtions equtions = new Equtions();
        final Double ACC = 1.0;
        @ParameterizedTest
        @ValueSource(doubles ={5,7,10,-100,0,55})
        void testEqutions(double x){
            assertEquals(equtions.answer(x),equtions.run(x,ACC),ACC);
        }
    }

}
