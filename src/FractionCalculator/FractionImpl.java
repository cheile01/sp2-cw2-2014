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


    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
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


	@Override
	public Fraction add(Fraction frac) {
		//initialising variables
		int a;
		
		//adding numerators		
		a = (this.getNumerator() * frac.getDenominator()) + (frac.getNumerator() * this.getDenominator());
		return new FractionImpl(a,(this.getDenominator() * frac.getDenominator()));
	}
	
	@Override
	public Fraction sub(Fraction frac) {
		//initialising variables
		int a;
		
		//subtracting numerators		
		a = (this.getNumerator() * frac.getDenominator()) - (frac.getNumerator() * this.getDenominator());
		return new FractionImpl(a,(this.getDenominator() * frac.getDenominator()));
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
		if (s.toLowerCase().equals("help")){
			help();
			return frac;
		}
		Fraction result = frac;
		Fraction temp = new FractionImpl(0,1);
		boolean calc = false;
		String[] element = s.split(" ");
		for(String e : element){
			e = e.toLowerCase();
			if (e.equals("+")){
				result.setOperator("+");
			} else if (e.equals("-")){
				result.setOperator("-");
			} else if (e.equals("*")){
				result.setOperator("*");
			} else if (e.equals("/")){
				result.setOperator("/");
			} else if (e.equals("abs") || e.equals("a")){
				result = result.abs();
			} else if (e.equals("neg") || e.equals("n")){
				result = result.neg();
			} else if (e.equals("c") || e.equals("clear")){
				result.clear();
			} else if (e.equals("q") || e.equals("quit")){
				System.out.println("Thank you for using fraction calculator");
				System.out.println("The last result was: " + result);
				return null;
			} else if(e.matches("-?\\d+")){
				int i = Integer.parseInt(e);
				temp = new FractionImpl(i,1);
				calc = true;
			} else if (e.matches("-?\\d+\\/-?\\d+")){
				String[] t = e.split("/");
				int a = Integer.parseInt(t[0]);
				int b = Integer.parseInt(t[1]);
				temp = new FractionImpl(a,b);
				calc = true;
			} else if (e.equals("")){
				//Do nothing - just capturing multiple spaces
			} else {
				System.out.println("Can't interpret: " + e);
				result.clear();
				return result;
			}
			
			//only execute calculation if needed.
			if (calc){
				if(result.getOperator().equals("")){
					result = temp;
				} else if(result.getOperator().equals("+"))  {
					result = result.add(temp);
					result.setOperator("");
				} else if(result.getOperator().equals("-"))  {
					result = result.sub(temp);
					result.setOperator("");
				} else if(result.getOperator().equals("*"))  {
					result = result.multiply(temp);
					result.setOperator("");
				} else if(result.getOperator().equals("/"))  {
					result = result.divide(temp);
					result.setOperator("");
				}
				temp = new FractionImpl(0,1);
				calc = false;
			}

		}

		return result;
	}
	
	private void help(){
		System.out.println();
		System.out.println("Christian Heiler's Fraction calculator help");
		System.out.println("Mathematical signs: \t Multiply: + \t Divide: / \t Add: + \t Subtract: - ");
		System.out.println("Operators: \t\t Absolute value: abs | a \t Negate: neg | n \t Clear: clear | c ");
		System.out.println("System: \t\t Help: help (this helpfile) \t End: quit | q ");
		System.out.println();
	}
	
	
}
