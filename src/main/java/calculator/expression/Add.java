/**
 * 
 */
package calculator.expression;


/**
 * @author chris
 *
 */
class Add implements Expression {

	public double evaluate(ExpressionToken arg1, ExpressionToken arg2) {
		double left = Double.parseDouble(arg1.valueOf());
		double right = Double.parseDouble(arg2.valueOf());
		return left + right;
	}

}
