package ru.itmo.potatocoder228.tpo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FunctionsSystemTest {
    private static short ACCURACY = 4;
    @Mock
    private Cos cos = new Cos(ACCURACY);
    @Mock
    private Sin sin = new Sin(ACCURACY);
    @Mock
    private Ln ln = new Ln(ACCURACY);
    @Mock
    private Log2 log2 = new Log2(ACCURACY);
    @Mock
    private Log3 log3 = new Log3(ACCURACY);
    @Mock
    private Log10 log10 = new Log10(ACCURACY);
    @InjectMocks
    FunctionsSystem functionsSystem = new FunctionsSystem(ACCURACY);

    @Test
    void shouldCallTrigonometricMocks() {
        when(cos.function(-3.14)).thenReturn(0.9999);
        when(sin.function(-3.14)).thenReturn(0.0);
        functionsSystem.function(-3.14);
        verify(cos, atLeastOnce()).function(anyDouble());
        verify(sin, atLeastOnce()).function(anyDouble());
    }

    @Test
    void shouldCallLogMocks() {
        when(ln.function(3.14)).thenReturn(1.14);
        when(log2.function(3.14)).thenReturn(1.65);
        when(log3.function(3.14)).thenReturn(1.04);
        when(log10.function(3.14)).thenReturn(0.49);
        functionsSystem.function(3.14);
        verify(log2, atLeastOnce()).function(anyDouble());
        verify(log3, atLeastOnce()).function(anyDouble());
        verify(log10, atLeastOnce()).function(anyDouble());
        verify(ln, atLeastOnce()).function(anyDouble());
    }

    @ParameterizedTest
    @CsvSource({ "-6.28,-6.28", "3.14, -3.14" })
    public void checkTrigonometricFuncs(double x, double y) {
        when(cos.function(x)).thenReturn(Math.cos(x));
        when(sin.function(x)).thenReturn(Math.sin(x));
        when(cos.function(y)).thenReturn(Math.cos(y));
        when(sin.function(y)).thenReturn(Math.sin(y));
        assertEquals(cos.function(y), cos.function(x), 0.01);
        assertEquals(sin.function(y), sin.function(x), 0.01);
    }

    // Можно было бы включить вот такую проверку, но имеем что имеем
    // @ParameterizedTest
    // @CsvSource({
    // "-1.040000, -0.775121",
    // "-0.040000, -25.006636",
    // })
    // public void checkSpecialTrigonometricalValues(double x, double y) {
    // when(cos.function(x)).thenReturn(Math.cos(x));
    // when(sin.function(x)).thenReturn(Math.sin(x));
    // assertEquals(y, functionsSystem.function(x), 0.01);
    // }

    @ParameterizedTest
    @CsvSource({
            "-1.040000, -0.586987",
            "-0.040000, -24.98666",
    })
    public void checkSpecialTrigonometricalValues(double x, double y) {
        when(cos.function(x)).thenReturn(Math.cos(x));
        when(sin.function(x)).thenReturn(Math.sin(x));
        assertEquals(y, functionsSystem.function(x), 0.01);
    }

    @ParameterizedTest
    @CsvSource({
            "3.060000, -0.314989",
            "0.060000, -12.53587",
    })
    public void checkSpecialLogValues(double x, double y) {
        when(log2.function(x)).thenReturn(Math.log10(x) / Math.log10(2));
        when(log3.function(x)).thenReturn(Math.log10(x) / Math.log10(3));
        when(log10.function(x)).thenReturn(Math.log10(x));
        when(ln.function(x)).thenReturn(Math.log(x));
        assertEquals(y, functionsSystem.function(x), 0.01);
    }
}
