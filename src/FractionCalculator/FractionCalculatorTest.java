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
		new FractionImpl(1, 0);
	}
	
	@Test
	public void multiplyFractionImpls() {
		// test multiply
        FractionImpl a = new FractionImpl(2,3);
        Fraction b = a.multiply(new FractionImpl(3,5));
        assertEquals("Wrong Answer!", new FractionImpl(6,15), b);
	}
	
	
	@Test
	public void greaterNumenatort() {
        FractionImpl a = new FractionImpl(6,3);
        assertEquals("Wrong Answer!", new FractionImpl(2,1), a);
	}
	
	@Test
	public void divideFractionImpls() {
		// test divide
        Fraction a = new FractionImpl(4,10);
        Fraction b = a.divide(new FractionImpl(1,2));
        assertEquals("Wrong Answer!", new FractionImpl(8,10), b);
	}
	
	@Test
	public void addFractionImpls() {
        Fraction a = new FractionImpl(2,5);
        Fraction b = a.add(new FractionImpl(2,10));
        assertEquals("Wrong Answer!", new FractionImpl(6,10), b);
	}
	
	@Test
	public void subtractFractionImpls() {
        Fraction a = new FractionImpl(4,5);
        Fraction b = a.sub(new FractionImpl(1,10));
        assertEquals("Wrong Answer!", new FractionImpl(7,10), b);
	}
	
	@Test
	public void absolute1() {
        Fraction a = new FractionImpl(-4,5);
        Fraction b = a.abs();
        assertEquals("Wrong Answer!", new FractionImpl(4,5), b);
	}
	@Test
	public void absolute2() {
        Fraction a = new FractionImpl(4,-5);
        Fraction b = a.abs();
        assertEquals("Wrong Answer!", new FractionImpl(4,5), b);
	}
	@Test
	public void absolute3() {
        Fraction a = new FractionImpl(-4,-5);
        Fraction b = a.abs();
        assertEquals("Wrong Answer!", new FractionImpl(4,5), b);
	}
	
	@Test
	public void neg1() {
        Fraction a = new FractionImpl(-4,5);
        Fraction b = a.neg();
        assertEquals("Wrong Answer!", new FractionImpl(4,5), b);
	}
	@Test
	public void neg2() {
        Fraction a = new FractionImpl(4,-5);
        Fraction b = a.neg();
        assertEquals("Wrong Answer!", new FractionImpl(4,5), b);
	}
	@Test
	public void neg3() {
        Fraction a = new FractionImpl(-4,5);
        Fraction b = a.neg();
        assertEquals("Wrong Answer!", new FractionImpl(4,5), b);
	}
	@Test
	public void neg4() {
        Fraction a = new FractionImpl(4,5);
        Fraction b = a.neg();
        assertEquals("Wrong Answer!", new FractionImpl(-4,5), b);
	}
	
	@Test
	public void fullInteger() {
        Fraction a = new FractionImpl(6,1);
        assertEquals("Wrong Answer!", "6", a.toString());
	}
	
	@Test
	public void clearFractionImpl() {
        Fraction a = new FractionImpl(4,5);
        a.clear();
        assertEquals("Wrong Answer!", new FractionImpl(0,1), a);
	}
	
	
	//TEST evaluate whole number input
	@Test
	public void evaluation1() {
        Fraction a = new FractionImpl(0,1);
        Fraction b = a.evaluate(a, "2");
        assertEquals("Wrong Answer!", new FractionImpl(2,1), b);
	}
	
	//TEST evaluate fraction input
	@Test
	public void evaluation2() {
        Fraction a = new FractionImpl(0,1);
        Fraction b = a.evaluate(a, "2/4");
        assertEquals("Wrong Answer!", new FractionImpl(1,2), b);
	}
	
	//TEST evaluate fraction addition
	@Test
	public void evaluation3() {
        Fraction a = new FractionImpl(0,1);
        Fraction b = a.evaluate(a, "2/4 + 1/3");
        assertEquals("Wrong Answer!", new FractionImpl(5,6), b);
	}
	
	
	
		
	
	
	
	
	
	

}
