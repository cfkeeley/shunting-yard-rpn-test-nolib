/**
 * 
 */
package calculator;

import calculator.expression.ExpressionSymbol;
import calculator.expression.ExpressionToken;

/**
 * @author chris
 * Set of operators 
 */
public enum Operator implements ExpressionSymbol {
	
	PLUS("+",1),MINUS("-",1),MULTIPLY("*",2),DIVIDE("/",2);
	
	private String symbol;
	private int precedence;
	
	Operator(String aSymbol, int aPrecedence) {
		symbol = aSymbol;
		precedence = aPrecedence;
	}
	
	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}
	
	/**
	 * Lookup an instance of Operator using a string symbol
	 * @param symbol
	 * @return
	 */
	public static Operator instanceOf(ExpressionToken token) {
		for(Operator op : values()) {
			if(op.getSymbol().equalsIgnoreCase(token.valueOf())) {
				return op;
			}
		}
		return null;
	}
	
	/**
	 * Lookup an instance of Operator using a string symbol
	 * @param symbol
	 * @return
	 */
	public static boolean isOperator(String symbol) {
		for(Operator op : values()) {
			if(op.getSymbol().equalsIgnoreCase(symbol)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return the precedence
	 */
	public int getPrecedence() {
		return precedence;
	}
}
