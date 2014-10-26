package FractionCalculator;

/**
 * Created by keith for the second coursework assignment.
 * Added on by Christian Heiler (cheile01) to complete assignment.
 */
public class FractionImpl implements Fraction {
    private int numerator;
    private int denominator;
    private String operator = "";

    public FractionImpl(int num, int denom) {
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
    	if(this.getDenominator() == 1) return ""+this.getNumerator();
    	
        return "" + this.getNumerator() + '/' + this.getDenominator();
    }


    @Override
	public int getNumerator() {
        return numerator;
    }


    @Override
	public void setNumerator(int num) {
        numerator = num;
    }


    @Override
	public int getDenominator() {
        return denominator;
    }

 
    @Override
	public void setDenominator(int num) {
        denominator = num;
    }
    

    @Override
	public String getOperator() {
        return operator;
    }

    @Override
	public void setOperator(String op) {
        operator = op;
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

    @Override
	public Fraction multiply(Fraction frac) {

        int num = this.getNumerator() * frac.getNumerator();
        int denom = this.getDenominator() * frac.getDenominator();
        
        return new FractionImpl(num, denom);
    }

    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

	@Override
	public Fraction divide(Fraction frac) {
        int num = this.getNumerator() * frac.getDenominator();
        int denom = this.getDenominator() * frac.getNumerator();
        
        return new FractionImpl(num, denom);
	}

	//OPTIMISE Refactor to make more efficient.
	@Override
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
		return new FractionImpl(a,b);
	}
	
	//OPTIMISE Refactor to make more efficient.
	@Override
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
		return new FractionImpl(a,b);
	}

	/*
	 * creating an absolute.
	 */
	@Override
	public Fraction abs() {
		int a = this.getNumerator();
		int b = this.getDenominator();
		if((a < 0)^(b < 0)){
			a = a* -1;
		}
		return new FractionImpl(a,b);
	}


	@Override
	public Fraction neg() {
		int a = this.getNumerator();
		int b = this.getDenominator();
			a = a* -1;
		return new FractionImpl(a,b);
	}


	@Override
	public void clear() {
		this.setDenominator(1);
		this.setNumerator(0);
	}



	@Override
	public Fraction evaluate(Fraction frac, String s) {
		Fraction result = new FractionImpl(0,1);
		Fraction temp = new FractionImpl(0,1);
		
		String[] element = s.split(" ");
		for(String e : element){
			if(e.matches("-?\\d+")){
				int i = Integer.parseInt(e);
				temp = new FractionImpl(i,1);
			} 
			else if (e.matches("-?\\d+\\/-?\\d+")){
				String[] t = e.split("/");
				int a = Integer.parseInt(t[0]);
				int b = Integer.parseInt(t[1]);
				temp = new FractionImpl(a,b);
			}
			if(result.getOperator().equals("")){
				result = temp;
			} else if(result.getOperator().equals("+"))  {
				result = result.add(temp);
				result.setOperator("");
			}
			
			
			
			if (e.equals("+")){
				result.setOperator("+");
			}
		}
		return result;
	}
	
	
}
