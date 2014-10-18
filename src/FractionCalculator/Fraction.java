package FractionCalculator;

/**
 * Created by keith for the second coursework assignment.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int denom) {
        if (denom == 0) {
            System.out.println("Invalid fraction with denominator 0"); // this should use exceptions
            return;
        }
        int gcd = myGcd(num, denom);
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
    }

    @Override
    public String toString() {
        return "" + getNumerator() + '/' + getDenominator();
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int num) {
        denominator = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    public Fraction multiply(Fraction frac) {

        int num = this.getNumerator() * frac.getNumerator();
        int denom = this.getDenominator() * frac.getDenominator();
        
        return new Fraction(num, denom);
    }

    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

	public Fraction divide(Fraction frac) {
        int num = this.getNumerator() * frac.getDenominator();
        int denom = this.getDenominator() * frac.getNumerator();
        
        return new Fraction(num, denom);
	}

	//OPTIMISE Refactor to make more efficient.
	public Fraction add(Fraction frac) {
		//getting integers for multiplication
		int a = this.getNumerator();
		int b = this.getDenominator();
		int aa = frac.getNumerator();
		int bb = frac.getDenominator();
		
		//multiply to same denominator:		
		a = a * bb;
		aa = aa * b;
		b = b * bb;

		//adding numerators		
		a = a + aa;
		return new Fraction(a,b);
	}
	
	//OPTIMISE Refactor to make more efficient.
	public Fraction sub(Fraction frac) {
		//getting integers for multiplication
		int a = this.getNumerator();
		int b = this.getDenominator();
		int aa = frac.getNumerator();
		int bb = frac.getDenominator();
		
		//multiply to same denominator:		
		a = a * bb;
		aa = aa * b;
		b = b * bb;

		//adding numerators		
		a = a - aa;
		return new Fraction(a,b);
	}

	/*
	 * creating an absolute.
	 */
	public Fraction abs() {
		int a = this.getNumerator();
		int b = this.getDenominator();
		if((a < 0)^(b < 0)){
			a = a* -1;
		}
		return new Fraction(a,b);
	}

	public Fraction neg() {
		int a = this.getNumerator();
		int b = this.getDenominator();
			a = a* -1;
		return new Fraction(a,b);
	}
	
	
	
	
	
}
