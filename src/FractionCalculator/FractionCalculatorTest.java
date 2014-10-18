/**
 * 
 */
package FractionCalculator;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author christianheiler
 *
 */
public class FractionCalculatorTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void divideByZero() {
		new Fraction(1, 0);
	}
	
	@Test
	public void multiplyFractions() {
		// test multiply
        Fraction a = new Fraction(2,3);
        Fraction b = a.multiply(new Fraction(3,5));
        assertEquals("Wrong Answer!", new Fraction(6,15), b);
	}
	
	
	@Test
	public void greaterNumenatort() {
        Fraction a = new Fraction(6,3);
        assertEquals("Wrong Answer!", new Fraction(2,1), a);
	}
	
	@Test
	public void divideFractions() {
		// test divide
        Fraction a = new Fraction(4,10);
        Fraction b = a.divide(new Fraction(1,2));
        assertEquals("Wrong Answer!", new Fraction(8,10), b);
	}
	
	@Test
	public void addFractions() {
		// test divide
        Fraction a = new Fraction(1,10);
        Fraction b = a.add(new Fraction(1,2));
        assertEquals("Wrong Answer!", new Fraction(6,10), b);
	}
	
	
	
	
	

}
