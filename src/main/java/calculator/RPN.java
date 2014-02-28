/**
 * 
 */
package calculator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import org.apache.log4j.Logger;

import calculator.expression.ExpressionSymbol;
import calculator.expression.ExpressionToken;

/**
 * @author chris
 * Convert an infix expression to postfix, Reverse Polish Notation (RPN) using an 
 * implementation of the shunting yard algorithm as defined here:
 * http://en.wikipedia.org/wiki/Shunting-yard_algorithm
 */
public final class RPN {
	
	static Logger logger = Logger.getLogger(RPN.class);
	
	private final String EXPRESSION_DELIMETER = " ";
	
	/**
	 * Holds the RPN representation of the infix expression 
	 */
	private final List<ExpressionToken> rpn;
	
	/**
	 * Prevent construction with no arguments
	 */
	@SuppressWarnings("unused")
	private RPN() {rpn=null;}
	
	/**
	 * Construct a postfix representation of the infix expression
	 * @param infix
	 */
	public RPN(String infix) {
		rpn = toPostfix(infix);
	}
	
	/**
	 * @return the postfix representation of the infix expression
	 */
	public List<ExpressionToken> getTokenisedExpression() {
		return rpn;
	}
	
	/**
	 * Convert an infix expression to postfix
	 * @param infix
	 * @return the expression in postfix format
	 */
	private List<ExpressionToken> toPostfix(String infix) {
		final List<ExpressionToken> outQueue = new ArrayList<ExpressionToken>();
		final Deque<ExpressionSymbol> opStack = new ArrayDeque<ExpressionSymbol>();
		for(String elem : Arrays.asList(infix.split(EXPRESSION_DELIMETER))) {
			final ExpressionToken token = new ExpressionToken(elem);
			if(token.isNumber()) {
				outQueue.add(token);
			} 
			else if(token.isOperator()) {
	    		ExpressionSymbol op1 = Operator.instanceOf(token);
	    		ExpressionSymbol op2 = null;
	    		/**
	    		 * while there is at least one 'Operator' on the stack and either
	    		 * its precedence is equal to or less than that of the current
	    		 * operator
	    		 */
	    		while(null != (op2 = opStack.peek()) && 
	    			Operator.isOperator(op2.getSymbol()) && 
	    			op1.getPrecedence() <= op2.getPrecedence())
	    		{
	    			outQueue.add(new ExpressionToken(opStack.pop().getSymbol()));
	    		}
				opStack.push(op1);
	    	}
	    	else if(token.isLeftParentheses()) {
	    		opStack.push(Parentheses.instanceOf(token.valueOf()));
	    	}
	    	else if(token.isRightParentheses()) {
	    		ExpressionSymbol curr = null;
	    		while(null != (curr = opStack.peek()) && !curr.equals(Parentheses.LEFT_PARENTHESES)) {
	    			outQueue.add(new ExpressionToken(opStack.pop().getSymbol()));
	    		}
	    		opStack.pop();
	    	}
	    }
		/**
		 * Pop any remaining operators to the outqueue
		 */
		while(null != opStack.peek()) {
			outQueue.add(new ExpressionToken(opStack.pop().getSymbol()));
		}
		return outQueue;
	}
}
