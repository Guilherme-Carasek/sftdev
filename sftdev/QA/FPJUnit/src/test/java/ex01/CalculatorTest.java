package ex01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator testCalculator;

    @BeforeEach
    void setUp() {
        testCalculator = new Calculator();
    }

    @Test
    public void addIntegersTest (){
        assertEquals(3,testCalculator.add(1,2));
        assertEquals(7,testCalculator.add(3,4));

    }

    @Test
    public void addNegativesTest (){
        assertEquals(1,testCalculator.add(-1,2));
        assertEquals(-1,testCalculator.add(3,-4));
        assertEquals(-11,testCalculator.add(-5, -6));

    }

    @Test
    public void addZeroTest (){
        assertEquals(1,testCalculator.add(0,1));
        assertEquals(2,testCalculator.add(2,0));
        assertEquals(0,testCalculator.add(0,0));

    }

    @Test
    public void subtractIntegersTest() {
        assertEquals(-1, testCalculator.subtract(1, 2));
        assertEquals(1, testCalculator.subtract(4,3));
    }

    @Test
    public void subtractNegativesTest() {
        assertEquals(-3,testCalculator.subtract(-1,2));
        assertEquals(7,testCalculator.subtract(3,-4));
        assertEquals(1,testCalculator.subtract(-5, -6));

    }

    @Test
    public void subtractZeroTest (){
        assertEquals(-1,testCalculator.subtract(0,1));
        assertEquals(2,testCalculator.subtract(2,0));
        assertEquals(0,testCalculator.subtract(0,0));

    }

    @Test
    public void multiplyIntegersTest (){
        assertEquals(2,testCalculator.multiply(1,2));
        assertEquals(12,testCalculator.multiply(3,4));

    }

    @Test
    public void multiplyNegativesTest() {
        assertEquals(-2,testCalculator.multiply(-1,2));
        assertEquals(-12,testCalculator.multiply(3,-4));
        assertEquals(30,testCalculator.multiply(-5, -6));

    }

    @Test
    public void multiplyZeroTest (){
        assertEquals(0,testCalculator.multiply(0,1));
        assertEquals(0,testCalculator.multiply(2,0));
        assertEquals(0,testCalculator.multiply(0,0));

    }

    @Test
    public void divideIntegersTest (){
        assertEquals(0,testCalculator.divide(1,2));
        assertEquals(1,testCalculator.divide(4,3));

    }

    @Test
    public void divideNegativesTest() {
        assertEquals(-3, testCalculator.divide(-12,4));
        assertEquals(-2, testCalculator.divide(2, -1));
        assertEquals(2, testCalculator.divide(-12, -5));

    }

    @Test
    public void divideZeroTest() {
        assertEquals(0, testCalculator.divide(0, 4));
        assertThrows(IllegalArgumentException.class, () -> {testCalculator.divide(3, 0);});
        assertThrows(IllegalArgumentException.class, () -> {testCalculator.divide(0, 0);});

    }
}