package ru.itmo.potatocoder228.tpo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TrigTest {
    Sin sin = new Sin((short) 6);
    Cos cos = new Cos((short) 6);

    @ParameterizedTest
    @ValueSource(doubles = { 3.14, 1, 0.01 })
    void SinFunctionTest(double x) {
        assertEquals(Math.sin(x), sin.function(x), 0.1);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0, -1, -3 })
    void SinFunctionNegativeTest(double x) {
        assertEquals(Math.sin(x), sin.function(x), 0.1);
    }

    // @ParameterizedTest
    // @ValueSource(doubles = { 0, -1, -3 })
    // void SinDerivativeNegativeTest(double x) {
    //     assertEquals(0, sin.derivative(sin.function(x), 0.0001, 1), 0.1);
    // }

    @ParameterizedTest
    @ValueSource(doubles = { 3.14, 1, 0.01 })
    void CosFunctionTest(double x) {
        assertEquals(Math.cos(x), cos.function(x), 0.4);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0, -1, -3 })
    void CosFunctionNegativeTest(double x) {
        assertEquals(Math.cos(x), cos.function(x), 0.4);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0, -1, -3 })
    void CosDerivativeNegativeTest(double x) {
        assertEquals(0, cos.derivative(cos.function(x), 0.0001, 2), 1);
    }
}
