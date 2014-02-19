/**
 * 
 */
package calculator.expression;


/**
 * @author chris
 * Divide the left hand argument by the right hand argument.
 * An ArithmeticException will be thrown if the right hand argument is zero.
 */
class Divide implements Expression {
	/* (non-Javadoc)
	 * @see calculator.Expression#evaluate(ExpressionToken, ExpressionToken)
	 */
	public double evaluate(ExpressionToken arg1, ExpressionToken arg2) {
		double left = Double.parseDouble(arg1.valueOf());
		double right = Double.parseDouble(arg2.valueOf());
		if(right <= 0) {
			throw new ArithmeticException("Division by zero");
		}
		return left / right;
	}

}
