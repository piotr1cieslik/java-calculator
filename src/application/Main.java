package application;

import java.io.IOException;


/**
 * class containing main method
 * 
 * @author Piotrek
 * @version 1.0
 */
public class Main {
	/**
	 * main method
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		//show options to user
		System.out.println("�eby otrzyma� wynik, wpisz dzia�anie. �eby obliczy� wyniki z pliku, wpisz �cie�k� do pliku. "
				+ "�eby zamkn�� program, wpisz 'koniec'.");
		CalculatorManager calculator = new CalculatorManager();
		
		calculator.calculatorStart();
	}

}
