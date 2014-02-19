/**
 * 
 */
package expression.infix.parser.rpn;

/**
 * @author chris
 * fetch an implementation for the Operator
 */
public class ExpressionFactory {
	public static Expression instance(Operator op) {
		Expression exp = null;
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
