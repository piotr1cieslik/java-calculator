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
		System.out.println("�eby obliczy� pojedyncze dzia�anie, wpisz 'dzialanie', a nast�pnie wyra�enie do obliczenia.\n"
				+ "�eby obliczy� wyniki dzia�a� z pliku, wpisz 'plik' a nast�pnie �cie�k� do pliku.\n"
				+ "�eby zamkn�� program, wpisz 'koniec'.");
		CalculatorManager calculator = new CalculatorManager();
		
		calculator.calculatorStart();
	}

}
