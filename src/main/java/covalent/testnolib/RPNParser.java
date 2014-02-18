/**
 * 
 */
package covalent.testnolib;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author chris
 * Parse an RPN instance 
 */
public class RPNParser {
	private final RPN expression;
	public RPNParser(RPN rpnExpression) {
		expression = rpnExpression;
	}
	
	/**
	 * Parse an RPN representation of an infix expression.
	 * We know that we are ONLY dealing with binary operators
	 * @return
	 */
	public double parse() {
		int MAX_OP_ARGS = 2;
		List<String> rpn = expression.getTokenisedExpression();
		final Deque<String> numbers = new ArrayDeque<String>();
		for(String elem : rpn) {
			ExpressionToken token = new ExpressionToken(elem);
			if(token.isNumber()) {
				numbers.push(token.valueOf());
			}
			else if(token.isOperator()) {
				
			}
		}
		return 0.0;
	}

	/**
	 * @return the expression
	 */
	public RPN getExpression() {
		return expression;
	}
}
