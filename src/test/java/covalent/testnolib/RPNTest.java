/**
 * 
 */
package covalent.testnolib;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import expression.infix.parser.rpn.RPN;

/**
 * @author chris
 * Test expression to RPN (Reverse Polish Notation)
 */
@RunWith(Parameterized.class)
public class RPNTest {

	/**
	 * The expression parameter 
	 */
	private String expression;
	
	/**
	 * 
	 * @param anExpression
	 */
	public RPNTest(String anExpression) {
		expression = anExpression;
	}
	
	@Test
	public final void test() {
		RPN rpn = new RPN(expression);
	}
	
	/**
	 * The test arguments for calculate
	 * @return
	 */
	@Parameters(name = "{index}: getRpn({0})")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
        		/*{ "1 + 1" }, 
        		{ "2 * 2" }, 
        		{ "1 + 2 + 3" },
                { "6 / 2" }, 
                { "11 + 23" }, 
                { "11.1 + 23" }, 
                { "( 11.5 + 15.4 ) + 10.1" },*/
                { "23 - ( 29.3 - 12.5 )" }
        });
    }

}
