package FractionCalculator;

public interface Fraction {

	public abstract String toString();

	public abstract int getNumerator();

	public abstract void setNumerator(int num);

	public abstract int getDenominator();

	public abstract void setDenominator(int num);

	public abstract String getOperator();

	public abstract void setOperator(String op);

	public abstract boolean equals(Object o);

	public abstract int hashCode();

	public abstract Fraction multiply(Fraction frac);

	public abstract Fraction divide(Fraction frac);

	public abstract Fraction add(Fraction frac);

	public abstract Fraction sub(Fraction frac);

	public abstract Fraction abs();

	public abstract Fraction neg();

	public abstract void clear();
	
	public Fraction evaluate(Fraction frac, String s);


}