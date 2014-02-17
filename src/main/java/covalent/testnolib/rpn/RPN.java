/**
 * 
 */
package covalent.testnolib.rpn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import covalent.testnolib.Operator;

/**
 * @author chris
 * Convert an infix expression to Reverse Polish Notation (RPN)
 */
public final class RPN {
	/**
	 * Holds the RPN representation of the infix expression 
	 */
	private final String rpn;
	
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
		rpn = convert(infix);
	}
	/**
	 * @return the rpn representation of the infix expression
	 */
	public String getRpn() {
		return rpn;
	}

	
	/**
	 * Convert an infix expression to an RPN representation
	 * @param infix
	 * @return the expression in RPN format
	 */
	private String convert(String infix) {
	
		final List<String> outQueue = new ArrayList<String>();
		final Deque<Operator> opStack = new ArrayDeque<Operator>();
		
		String[] result = infix.split(" ");
		int len = result.length;
		
	    for (int ix=0; ix<len; ix++) {
	    	String value = result[ix];
	    	if(Operator.isOperator(value)) {
	    		/**
	    		* If the token is an operator, o1, then:
				* while there is an operator token, o2, at the top of the stack, and
				* either o1 is left-associative and its precedence is equal to that of o2,
				* or o1 has precedence less than that of o2,
				* pop o2 off the stack, onto the output queue;
				* push o1 onto the stack.
	    		*/
	    		Operator op1 = Operator.instanceOf(value);
	    		Operator op2 = null;
				while(null != (op2 = opStack.peek())) {
					if( (op1.getPrecedence() == op2.getPrecedence()) || op1.getPrecedence() < op2.getPrecedence() ) {
						outQueue.add(opStack.pop().getSymbol());
					}
				}
				opStack.push(op1);
	    	}
	    	else {
	    		outQueue.add(value);
	    	} 
	    }
		return null;
	}
	

}
