/**
 * 
 */
package calculator.expression;


/**
 * @author chris
 * Subtract the left hand argument from the right hand argument
 */
final class Subtract implements Expression {
	/* (non-Javadoc)
	 * @see calculator.Expression#evaluate(ExpressionToken, ExpressionToken)
	 */
	public double evaluate(ExpressionToken arg1, ExpressionToken arg2) {
		double left = Double.parseDouble(arg1.valueOf());
		double right = Double.parseDouble(arg2.valueOf());
		return left - right;
	}

}
