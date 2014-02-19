/**
 * 
 */
package calculator.expression;


/**
 * @author chris
 *
 */
class Multiply implements Expression {

	/* (non-Javadoc)
	 * @see calculator.Expression#evaluate(ExpressionToken, ExpressionToken)
	 */
	public double evaluate(ExpressionToken arg1, ExpressionToken arg2) {
		double left = Double.parseDouble(arg1.valueOf());
		double right = Double.parseDouble(arg2.valueOf());
		return left * right;
	}

}
