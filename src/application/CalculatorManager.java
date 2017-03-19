package application;

import java.io.IOException;

import modules.ConsoleReader;
import modules.FilesReader;
import modules.MathEngine;


/**
 * class to manage calculator actions
 * 
 * @author Piotrek
 * @version 1.0
 */
public class CalculatorManager {
	/**
	 * stores line read from console
	 */
	private String line;
	/**
	 * reference variable to store reference to consoleReader object
	 */
	private ConsoleReader consoleReader;
	/**
	 * reference variable to store reference to filesReader object
	 */
	private FilesReader filesReader;
	/**
	 * reference variable to store reference to mathEngine object
	 */
	private MathEngine mathEngine;
	/**
	 * boolean to determine if calculator should read from console or file
	 */
	private boolean readFromConsole;
	
	/**
	 * basic constructor
	 */
	public CalculatorManager(){}
	
	/**
	 * method to start calculator
	 * 
	 * @throws IOException
	 */
	public void calculatorStart() throws IOException{
		readFromConsole = true;
		consoleReader = new ConsoleReader();
		filesReader = new FilesReader();
		mathEngine = new MathEngine();
		
		
		//while user do not write 'koniec' calculator will wait for commands
		do{
			if (readFromConsole)
				line = consoleReader.readLine();
			else{
				line = filesReader.readLine();
				if(line.equals("eof")){
					readFromConsole = true;
					continue;
				}
			}
			analizeResult(checkString(line));
		}while(!line.equals("koniec"));
	}
	
	/**
	 * method to check if input is math expression, file path or "koniec"
	 * 
	 * @param line
	 * @return int
	 */
	private int checkString(String line){
		if (!readFromConsole)
			return 0;
		if(line.equals("dzialanie"))
			return 1;
		else if(line.equals("plik")) 
			return 2;
		else if(line.equals("koniec")) 
			return 3;
		//return 4 if wrong command was read
		return 4;
	}
	
	/**
	 * method to act on results of method checkString
	 * 
	 * @param result
	 */
	private void analizeResult(int result){
		if (result == 0) 
			mathEngine.showResult(line);
		else if (result==1){
			System.out.println("Wpisz dzia³anie (np. 5+6): ");
			line = consoleReader.readLine();
			mathEngine.showResult(line);
		}
		else if (result == 2){
			System.out.println("Podaj scie¿kê do pliku:");
			line = consoleReader.readLine();
			if(filesReader.openFile(line))
				readFromConsole = false;
		}
		else if(result == 4)
			System.out.println("Wpisa³eœ niedozwolone dzia³anie lub polecenie!");
	}
}
