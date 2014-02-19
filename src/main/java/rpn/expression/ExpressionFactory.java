/**
 * 
 */
package rpn.expression;

import rpn.Operator;

/**
 * @author chris
 * fetch an implementation for the Operator
 */
public class ExpressionFactory {
	public static Expression instance(ExpressionToken token) {
		Expression exp = null;
		Operator op = Operator.instanceOf(token);
		switch(op) {
			case PLUS:
				exp = new Add();
				break;
			case MINUS:
				exp = new Subtract();
				break;
			case MULTIPLY:
				exp = new Multiply();
				break;
			case DIVIDE:
				exp = new Divide();
				break;
		}
	return exp;
	}
}
