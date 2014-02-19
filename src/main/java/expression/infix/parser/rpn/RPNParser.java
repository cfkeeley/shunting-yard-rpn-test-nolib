/**
 * 
 */
package expression.infix.parser.rpn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.apache.log4j.Logger;

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
		List<String> rpn = expression.getTokenisedExpression();
		final Deque<String> numbers = new ArrayDeque<String>();
		for(String elem : rpn) {
			ExpressionToken token = new ExpressionToken(elem);
			if(token.isNumber()) {
				numbers.push(token.valueOf());
			}
			else if(token.isOperator()) {
				if(MAX_OP_ARGS > numbers.size()) {
					logger.error(String.format("Operator:%s requires at least %d args", token.valueOf(), MAX_OP_ARGS));
				}
				else {
					String[] args = new String[MAX_OP_ARGS];
					int max = MAX_OP_ARGS;
					for(int pc = --max; pc >= 0; pc--) {
						args[pc] = numbers.pop();
					}
					Expression exp = ExpressionFactory.instance(Operator.instanceOf(token.valueOf()));
					double result = exp.evaluate(args[0], args[1]);
					numbers.push(String.valueOf(result));
				}
			}	
		}
		return (1 == numbers.size()) ? Double.valueOf(numbers.pop()) : -1d;
	}

	/**
	 * @return the expression
	 */
	public RPN getExpression() {
		return expression;
	}
}
