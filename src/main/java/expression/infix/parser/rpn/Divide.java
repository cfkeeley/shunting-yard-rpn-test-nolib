/**
 * 
 */
package expression.infix.parser.rpn;

/**
 * @author chris
 *
 */
public class Divide implements Expression {

	/* (non-Javadoc)
	 * @see expression.infix.parser.rpn.Expression#evaluate(java.lang.String, java.lang.String)
	 */
	public double evaluate(String arg1, String arg2) {
		double left = Double.parseDouble(arg1);
		double right = Double.parseDouble(arg2);
		return left / right;
	}

}
