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

import rpn.RPN;
import rpn.RPNParser;

/**
 * @author chris
 *
 */
@RunWith(Parameterized.class)
public class RPNParserTest {

	/**
	 * The expression parameter 
	 */
	private String expression;
	
	/**
	 * The expected outcome
	 */
	private double expected;
	
	/**
	 * 
	 * @param anExpression
	 */
	public RPNParserTest(String anExpression, double anExpectedValue) {
		expression = anExpression;
		expected = anExpectedValue;
	}
	
	@Test
	public final void test() {
		RPNParser parser = new RPNParser(new RPN(expression));
		assertEquals(parser.parse(), expected, 0d);
	}


	/**
	 * The test arguments for calculate
	 * @return
	 */
	@Parameters(name = "{index}: parse({0})=({1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
        		{ "1 + 1", 2d }, 
        		{ "2 * 2", 4d }, 
        		{ "1 + 2 + 3", 6d },
                { "6 / 2", 3d }, 
                { "11 + 23", 34d }, 
                { "11.1 + 23", 34.1d }, 
                { "( 11.5 + 15.4 ) + 10.1", 37d },
                { "23 - ( 29.3 - 12.5 )", 6.199999999999999d }
        });
    }
}
