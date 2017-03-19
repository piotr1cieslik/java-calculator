package application;

import java.io.FileNotFoundException;
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
		if(line.equals("plik")) 
			return 1;
		else if(line.equals("koniec")) 
			return 2;
		return 0;
	}
	
	/**
	 * method to act on results of method checkString
	 * 
	 * @param result
	 * @throws FileNotFoundException
	 */
	private void analizeResult(int result) throws FileNotFoundException{
		if (result == 0) 
			mathEngine.showResult(line);
		else if (result == 1){ 
			readFromConsole = false;
			System.out.println("Podaj scie¿kê do pliku:");
			line = consoleReader.readLine();
			filesReader.openFile(line);
		}
	}
}
