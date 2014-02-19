package expression.infix.parser.rpn;

public interface ExpressionSymbol {
	public String getSymbol();
	public int getPrecedence();
}
