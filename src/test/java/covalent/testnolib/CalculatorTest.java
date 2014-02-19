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

import calculator.Calculator;
import calculator.RPN;

/**
 * @author chris
 * Test parsing/execution of a series of Infix expressions against their
 * expected values.
 */
@RunWith(Parameterized.class)
public class CalculatorTest {

	/**
	 * The input argument
	 */
	private String expression;
	
	/**
	 * The expected result for the input argument
	 */
	private double expected;
	
	/**
	 * Construct with the input argument and expected result
	 * @param anExpression
	 */
	public CalculatorTest(String anExpression, double anExpectedValue) {
		expression = anExpression;
		expected = anExpectedValue;
	}
	
	/**
	 * Test the calculate method
	 */
	@Test
	public final void test() {
		assertEquals(Calculator.calculate(expression), expected, 0d);
	}

	/**
	 * The input arguments and expected results 
	 * @return a list of arguments and expected result pairs 
	 */
	@Parameters(name = "{index}: parse({0})=({1})")
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
