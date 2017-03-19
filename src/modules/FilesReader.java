package modules;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.FileNotFoundException;
import java.io.IOException;

import interfaces.ReadingInterface;

/**
 * class for reading from file
 * 
 * @author Piotrek
 * @version 1.0
 */
public class FilesReader implements ReadingInterface {
	/**
	 * buffered reader to read from file
	 */
	private BufferedReader reader;
	
	/**
	 * basic constructor
	 */
	public FilesReader(){}
	
	/**
	 * method which opens a file (using path from parameter)
	 * 
	 * @param filePath
	 * @return boolean
	 */
	public boolean openFile(String filePath){
		try{
			reader = new BufferedReader(new FileReader(filePath));
			return true;
		}
		catch(FileNotFoundException fnfe){
			if(!filePath.equals("koniec"))
				System.out.println("Plik o podanej œcie¿ce nie istnieje!");
			return false;
		}
	}
	
	/**
	 * reads one line from file and returns it
	 * in case of end of file, returns "eof"
	 * 
	 * @throws IOException
	 * @return String
	 */
	public String readLine() throws IOException{
		String line = reader.readLine();
		if(reader == null || line == null)
			return "eof";
		else
			return line;
	}
}
