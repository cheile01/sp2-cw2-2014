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
	public void multiply() {
		// test multiply
        assert ((new Fraction(3, 1)).equals(new Fraction(1, 2).multiply(new Fraction(3, 5))));

	}
	
	

}
