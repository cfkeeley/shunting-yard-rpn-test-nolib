/**
 * 
 */
package calculator.expression;


/**
 * @author chris
 * Evaluate an expression for a binary operator
 */
public interface Expression {
	public double evaluate(ExpressionToken arg1, ExpressionToken arg2);
}
