/**
 * 
 */
package rpn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import org.apache.log4j.Logger;

import rpn.expression.ExpressionSymbol;
import rpn.expression.ExpressionToken;

/**
 * @author chris
 * Convert an infix expression to Reverse Polish Notation (RPN)
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
	 * Construct an RPN representation of the infix expression
	 * @param infix
	 */
	public RPN(String infix) {
		rpn = convertInfixtoRPN(infix);
	}
	/**
	 * @return the rpn representation of the infix expression
	 */
	public List<ExpressionToken> getTokenisedExpression() {
		return rpn;
	}

	
	/**
	 * Convert an infix expression to an RPN representation
	 * @param infix
	 * @return the expression in RPN format
	 */
	private List<ExpressionToken> convertInfixtoRPN(String infix) {
		final List<ExpressionToken> outQueue = new ArrayList<ExpressionToken>();
		final Deque<ExpressionSymbol> opStack = new ArrayDeque<ExpressionSymbol>();
		for(String elem : Arrays.asList(infix.split(EXPRESSION_DELIMETER))) {
			ExpressionToken token = new ExpressionToken(elem);
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
		 * Pop any remaining operators to the out queue
		 */
		while(null != opStack.peek()) {
			outQueue.add(new ExpressionToken(opStack.pop().getSymbol()));
		}
		return outQueue;
	}
	

}
