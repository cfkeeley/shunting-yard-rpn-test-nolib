/**
 * 
 */
package covalent.testnolib;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import calculator.RPN;
import calculator.expression.ExpressionToken;

/**
 * @author chris
 * Test to see that the infix expression results in the correct postfix expression
 * Formatting not withstanding.
 */
@RunWith(Parameterized.class)
public class RPNTest {

	/**
	 * The input argument
	 */
	private String infix;
	
	/**
	 * The expected result for the input argument
	 */
	private String postfix;
	
	/**
	 * Construct with the input argument and expected result
	 * @param anExpression
	 */
	public RPNTest(String anInfixExpression, String aPostfixExpression) {
		infix = anInfixExpression;
		postfix = aPostfixExpression;
	}
	
	@Test
	public final void test() {
		RPN rpn = new RPN(infix);
		assertEquals(rpn.getTokenisedExpression().toString(),postfix);
	}
	
	/**
	 * The input arguments and expected results
	 * Note: the expected results reflects the toString() representation of the List<String>
	 * @return a list of arguments and expected result pairs 
	 */
	@Parameters(name = "{index}: parse({0})=({1})")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
        		{ "1 + 1", "[1, 1, +]" }, 
        		{ "2 * 2", "[2, 2, *]" }, 
        		{ "1 + 2 + 3", "[1, 2, +, 3, +]" },
                { "6 / 2", "[6, 2, /]" }, 
                { "11 + 23", "[11, 23, +]" }, 
                { "11.1 + 23", "[11.1, 23, +]" }, 
                { "( 11.5 + 15.4 ) + 10.1", "[11.5, 15.4, +, 10.1, +]" },
                { "23 - ( 29.3 - 12.5 )", "[23, 29.3, 12.5, -, -]" }
        });
    }

}
