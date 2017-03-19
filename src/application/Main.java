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
		System.out.println("¯eby obliczyæ pojedyncze dzia³anie, wpisz 'dzialanie', a nastêpnie wyra¿enie do obliczenia.\n"
				+ "¯eby obliczyæ wyniki dzia³añ z pliku, wpisz 'plik' a nastêpnie œcie¿kê do pliku.\n"
				+ "¯eby zamkn¹æ program, wpisz 'koniec'.");
		CalculatorManager calculator = new CalculatorManager();
		
		calculator.calculatorStart();
	}

}
