/**
 * 
 */
package calculator.expression;


/**
 * @author chris
 * An ArithmeticException will be thrown upon attempted division by zero
 */
class Divide implements Expression {

	/* (non-Javadoc)
	 * @see calculator.Expression#evaluate(java.lang.String, java.lang.String)
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
