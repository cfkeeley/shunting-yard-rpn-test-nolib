package calculator.expression;
/**
 * Common interface for different symbols in the expression.
 * @author chris
 */
public interface ExpressionSymbol {
	/**
	 * get the literal string representation of this symbol
	 * @return
	 */
	public String getSymbol();
	/**
	 * get the value of the precedence for this symbol
	 * @return
	 */
	public int getPrecedence();
}
