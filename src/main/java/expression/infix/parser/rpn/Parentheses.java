package expression.infix.parser.rpn;


/**
 * Left and right parenthesis
 * @author chris
 */
public enum Parentheses implements ExpressionSymbol {
	
	LEFT_PARENTHESES("(",0),RIGHT_PARENTHESES(")",0);
	
	private String symbol;
	private int precedence;
	
	Parentheses(String aParens, int aPrecendence) {
		symbol = aParens;
		precedence = aPrecendence;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	/**
	 * Lookup an instance of Parentheses using a string symbol
	 * @param symbol
	 * @return
	 */
	public static Parentheses instanceOf(String symbol) {
		for(Parentheses paren : values()) {
			if(paren.getSymbol().equalsIgnoreCase(symbol)) {
				return paren;
			}
		}
		return null;
	}
	
	public int getPrecedence() {
		return precedence;
	}
}