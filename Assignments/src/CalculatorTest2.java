import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest2 {

	@Test
	public void multiplyTest(){
		Calculator calc = new Calculator();
		assertTrue(calc.multiply(100, 0)==0);
		assertTrue(calc.multiply(50, 0) == 0);
		assertTrue(calc.multiply(0, 0) == 0);
	}
	@Test
	public void poundTokgTest(){
		Calculator calc = new Calculator();
		assertTrue(calc.poundTokg(50) == 22.6796);
		assertTrue(calc.poundTokg(0) == 0.0);
		assertTrue(calc.poundTokg(-50) == -22.6796);
	}
	@Test
	public void kgTopoundTest(){
		Calculator calc = new Calculator();
		assertTrue(calc.kgTopound(50) == 110.23115000000001);
		assertTrue(calc.kgTopound(0) == 0.0);
		assertTrue(calc.kgTopound(-50) == -110.23115000000001);
	}
	
}
