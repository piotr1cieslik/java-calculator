package modules;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.ScriptEngine;

/**
 * class for calculating math expressions
 * 
 * @author Piotrek
 * @version 1.0
 */
public class MathEngine {
	/**
	 * calculates math expression given in parameter using javascript engine,
	 * then shows result (with expression) in console
	 * 
	 * @param expression
	 */
	public void showResult(String expression){
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
		try{
			if (expression.equals("")) throw new ScriptException("empty");
			System.out.println(expression + "=" + engine.eval(expression));
		}
		catch(ScriptException se){
			if (!expression.equals("koniec"))
				System.out.println("Wpisa�e� niedozwolone dzia�anie lub polecenie!");
		}
	}
}
