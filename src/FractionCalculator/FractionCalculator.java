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
				calculation = calculation.evaluate(calculation, temp);
		}while(calculation != null);
		in.close();
	}
	
	private static void welcomeMessage(){
		System.out.println("Welcome to Christian Heiler's Fraction Calculator");
		System.out.println("write your calculation in line, to get a list of commands, type \"help\" as a single line statement");
	}
	

}
