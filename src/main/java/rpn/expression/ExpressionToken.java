/**
 * 
 */
package rpn.expression;

import rpn.Operator;
import rpn.Parentheses;


/**
 * @author chris
 * A wrapper implementing a set of convenience methods
 * for establishing facts about the token 
 */
public class ExpressionToken {

	private final String token;
	
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

		try {
			Float.parseFloat(token);
			isNumber = true;
		}catch(NumberFormatException e) {
			isNumber = false;
		}
		return isNumber;
	}
	
	public boolean isOperator() {
		return Operator.isOperator(token);
	}
	
	public boolean isLeftParentheses() {
		return token.equals(Parentheses.LEFT_PARENTHESES.getSymbol());
	}
	
	public boolean isRightParentheses() {
		return token.equals(Parentheses.RIGHT_PARENTHESES.getSymbol());
	}
	
}