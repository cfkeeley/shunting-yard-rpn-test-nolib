/**
 * 
 */
package expression.infix.parser.rpn;

/**
 * @author chris
 *
 */
public class Add implements Expression {

	public double evaluate(String arg1, String arg2) {
		double left = Double.parseDouble(arg1);
		double right = Double.parseDouble(arg2);
		return left + right;
	}

}
