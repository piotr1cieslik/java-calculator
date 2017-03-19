package modules;

import java.util.Scanner;

import interfaces.ReadingInterface;

/**
 * class for reading from console
 * 
 * @author Piotrek
 * @version 1.0
 */
public class ConsoleReader implements ReadingInterface{
	/**
	 * reads one line from console and returns it
	 * 
	 * @return String
	 */
	public String readLine(){
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
