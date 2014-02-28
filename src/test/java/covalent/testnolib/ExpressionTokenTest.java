/**
 * 
 */
package covalent.testnolib;

import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import calculator.RPN;

/**
 * @author chris
 *
 */
@RunWith(Parameterized.class)
public class ExpressionTokenTest {
	
	private RPN rpn;
	
	private String expression;
	
	public ExpressionTokenTest(RPN anRpn, String anExpression) {
		rpn = anRpn;
		expression = anExpression;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		rpn = new RPN(expression);
	}

	/**
	 * Test method for {@link calculator.expression.ExpressionToken#toString()}.
	 */
	@Test
	public final void testToString() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link calculator.expression.ExpressionToken#ExpressionToken(java.lang.String)}.
	 */
	@Test
	public final void testExpressionTokenString() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link calculator.expression.ExpressionToken#ExpressionToken(int)}.
	 */
	@Test
	public final void testExpressionTokenInt() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link calculator.expression.ExpressionToken#ExpressionToken(double)}.
	 */
	@Test
	public final void testExpressionTokenDouble() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link calculator.expression.ExpressionToken#valueOf()}.
	 */
	@Test
	public final void testValueOf() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link calculator.expression.ExpressionToken#isNumber()}.
	 */
	@Test
	public final void testIsNumber() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link calculator.expression.ExpressionToken#isOperator()}.
	 */
	@Test
	public final void testIsOperator() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link calculator.expression.ExpressionToken#isLeftParentheses()}.
	 */
	@Test
	public final void testIsLeftParentheses() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link calculator.expression.ExpressionToken#isRightParentheses()}.
	 */
	@Test
	public final void testIsRightParentheses() {
		fail("Not yet implemented"); // TODO
	}

}
