/**
 * 
 */
package rpn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.apache.log4j.Logger;

import rpn.expression.Expression;
import rpn.expression.ExpressionFactory;
import rpn.expression.ExpressionToken;

/**
 * @author chris
 * Parse an RPN instance 
 */
public class RPNParser {
	private final RPN expression;
	static Logger logger = Logger.getLogger(RPNParser.class);
	public RPNParser(RPN rpnExpression) {
		expression = rpnExpression;
	}
	
	/**
	 * Parse an RPN representation of an infix expression.
	 * We know that we are only dealing with binary operators
	 * @return
	 */
	public double parse() {
		int MAX_OP_ARGS = 2;
		final Deque<Double> numbers = new ArrayDeque<Double>();
		for(ExpressionToken token : expression.getTokenisedExpression()) {
			if(token.isNumber()) {
				numbers.push(new Double(token.valueOf()));
			}
			else if(token.isOperator()) {
				if(MAX_OP_ARGS > numbers.size()) {
					logger.error(String.format("Operator:%s requires at least %d args", token.valueOf(), MAX_OP_ARGS));
				}
				else {
					ExpressionToken[] args = new ExpressionToken[MAX_OP_ARGS];
					int max = MAX_OP_ARGS;
					for(int pc = --max; pc >= 0; pc--) {
						args[pc] = new ExpressionToken(numbers.pop());
					}
					Expression exp = ExpressionFactory.instance(token);
					double result = exp.evaluate(args[0], args[1]);
					numbers.push(result);
				}
			}	
		}
		return (1 == numbers.size()) ? numbers.pop() : -1d;
	}

	/**
	 * @return the expression
	 */
	public RPN getExpression() {
		return expression;
	}
}
