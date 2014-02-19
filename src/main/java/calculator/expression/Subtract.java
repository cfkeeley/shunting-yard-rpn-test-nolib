/**
 * 
 */
package calculator.expression;


/**
 * @author chris
 *
 */
final class Subtract implements Expression {
	
	/* (non-Javadoc)
	 * @see calculator.Expression#evaluate(java.lang.String, java.lang.String)
	 */
	public double evaluate(ExpressionToken arg1, ExpressionToken arg2) {
		double left = Double.parseDouble(arg1.valueOf());
		double right = Double.parseDouble(arg2.valueOf());
		return left - right;
	}

}
