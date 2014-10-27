/**
 * 
 */
package FractionCalculator;
import java.util.Scanner;

/**
 * @author christianheiler
 *
 */
public class FractionCalculator {

	/**
	 * 
	 */
	public FractionCalculator() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		welcomeMessage();
		Fraction calculation = new FractionImpl(0,1);
		Scanner in = new Scanner(System.in);
		String temp = "";
		do{
			System.out.print(calculation.toString() + " ? ");
			temp = in.nextLine();
			try {
				calculation = calculation.evaluate(calculation, temp);
			} finally {
				
			}
		}while(calculation != null);

	}
	
	private static void welcomeMessage(){
		System.out.println("Welcome to Christian Heiler's Fraction Calculator");
		System.out.println("write your calculation in line, to get a list of commands, type \"help\" as a single line statement");
	}
	

}
