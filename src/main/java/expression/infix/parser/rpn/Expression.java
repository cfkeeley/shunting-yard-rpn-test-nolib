/**
 * 
 */
package expression.infix.parser.rpn;

/**
 * @author chris
 * Evaluate an expression for a binary operator
 */
public interface Expression {
	public double evaluate(String arg1, String arg2);
}
