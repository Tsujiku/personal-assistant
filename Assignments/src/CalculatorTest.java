import static org.junit.Assert.*;
import java.io.*;
import org.junit.*;

public class CalculatorTest {
   
   @Test
   public void testDivide() {
      
      Calculator calc = new Calculator();
      
      //NaN
      assertTrue(calc.divide(0, 0) == 0);
      
      //Infinity
      assertTrue(calc.divide(100, 0) == 0);

      assertTrue(calc.divide(0, 100) == 0);
      assertTrue(calc.divide(1, -100) == -0.01);
      assertTrue(calc.divide(-100, 100) == -1);
      assertTrue(calc.divide(-100, -100) == 1);
   }

   @Test
   public void testFahrenheitToCelsius() {
      Calculator calc = new Calculator();
      assertTrue(calc.FahrenheitToCelsius(0) == -17.77777777777778);
      assertTrue(calc.FahrenheitToCelsius(100) == 37.77777777777778);
      assertTrue(calc.FahrenheitToCelsius(-100) == -73.33333333333333);
   }
   
   @Test
   public void testCelsiusToFahrenheit() {
      Calculator calc = new Calculator();
      assertTrue(calc.CelsiusToFahrenheit(0) == 32);
      assertTrue(calc.CelsiusToFahrenheit(100) == 212);
      assertTrue(calc.CelsiusToFahrenheit(-100) == -148);
   }
}