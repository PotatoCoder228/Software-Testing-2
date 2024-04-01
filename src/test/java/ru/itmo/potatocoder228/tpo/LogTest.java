package ru.itmo.potatocoder228.tpo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LogTest {
    Log2 log2 = new Log2((short) 6);
    Log3 log3 = new Log3((short) 6);
    Log10 log10 = new Log10((short) 6);
    Ln ln = new Ln((short) 6);
    // @ParameterizedTest
    // @ValueSource(doubles = {3.14, 1, 0.01})
    // void Log2FunctionTest(double x){
    //     assertEquals(Math.log10(x)/Math.log10(2), log2.function(x), 0.01);
    // }

    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -3})
    void Log2FunctionNegativeTest(double x){
        assertTrue(log2.function(x)==0);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -3})
    void Log2DerivativeNegativeTest(double x){
        assertTrue(log2.derivative(x,0.0001,1) == 0);
    }

    // @ParameterizedTest
    // @ValueSource(doubles = {3.14, 1, 0.01})
    // void Log3FunctionTest(double x){
    //     assertTrue(log3.function(x)>0);
    // }

    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -3})
    void Log3FunctionNegativeTest(double x){
        assertTrue(log3.function(x)==0);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -3})
    void Log3DerivativeNegativeTest(double x){
        assertTrue(log3.derivative(x,0.0001,1) == 0);
    }


    @ParameterizedTest
    @ValueSource(doubles = {3.14, 1, 0.01})
    void Log10FunctionTest(double x){
        assertEquals(Math.log10(x), log10.function(x), 0.1);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -3})
    void Log10FunctionNegativeTest(double x){
        assertTrue(log10.function(x)==0);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -3})
    void Log10DerivativeNegativeTest(double x){
        assertTrue(log10.derivative(x,0.0001,1) == 0);
    }

    @ParameterizedTest
    @ValueSource(doubles = {3.14, 1, 0.01})
    void LnFunctionTest(double x){
        assertEquals(Math.log(x), ln.function(x), 0.1);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -3})
    void LnFunctionNegativeTest(double x){
        assertTrue(ln.function(x)==0);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -3})
    void LnDerivativeNegativeTest(double x){
        assertEquals(0, ln.derivative(x,0.0001,1), 0.1);
    }
}
