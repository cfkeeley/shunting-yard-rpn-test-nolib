/**
 * 
 */
package calculator.expression;

import calculator.Operator;
import calculator.Parentheses;


/**
 * @author chris
 * A wrapper implementing a set of convenience methods
 * for establishing information about the token 
 */
public class ExpressionToken {

	private final String token;
	
	public String toString() {
		return token;
	}
	
	public ExpressionToken(String aToken) {
		token = aToken;
	}
	
	public ExpressionToken(int aToken) {
		token = String.valueOf(aToken);
	}
	
	public ExpressionToken(double aToken) {
		token = String.valueOf(aToken);
	}
	
	/**
	 * Return the wrapped string token
	 * @return
	 */
	public String valueOf() {
		return token;
	}
	
	/**
	 * True if its either an integer or a float
	 * @return
	 */
	public boolean isNumber() {
		boolean isNumber = true;
		try {
			Integer.parseInt(token);
		}catch(NumberFormatException e) {
			isNumber = false;
		}
		
		if(!isNumber) {
			try {
				Float.parseFloat(token);
				isNumber = true;
			}catch(NumberFormatException e) {
				isNumber = false;
			}
		}
		return isNumber;
	}
	
	/**
	 * Establish if this token is an calculator.Operator
	 * @return true if the token is a calculator.Operator
	 */
	public boolean isOperator() {
		return Operator.isOperator(token);
	}
	
	/**
	 * Establish if this token is a calculator.Parentheses.LEFT_PARENTHESES
	 * @return true if the token is a calculator.Parentheses.LEFT_PARENTHESES
	 */
	public boolean isLeftParentheses() {
		return token.equals(Parentheses.LEFT_PARENTHESES.getSymbol());
	}
	
	/**
	 * Establish if this token is a calculator.Parentheses.RIGHT_PARENTHESES
	 * @return true if the token is a calculator.Parentheses.RIGHT_PARENTHESES
	 */
	public boolean isRightParentheses() {
		return token.equals(Parentheses.RIGHT_PARENTHESES.getSymbol());
	}
	
}
