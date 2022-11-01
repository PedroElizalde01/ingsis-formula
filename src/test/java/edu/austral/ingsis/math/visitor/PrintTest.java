package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.functions.operations.*;
import edu.austral.ingsis.math.visitor.functions.operations.Module;
import edu.austral.ingsis.math.visitor.functions.operations.ParenthesisOperand;

import edu.austral.ingsis.math.visitor.visitors.PrintVisitor;
import edu.austral.ingsis.math.visitor.visitors.Visitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "1 + 6";
        final Visitor<String> visitor = new PrintVisitor();
        final String result = new Sum(new Value(1), new Value(6)).accept(visitor);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "12 / 2";
        final Visitor<String> visitor = new PrintVisitor();

        final String result = new Div(new Value(12), new Value(2)).accept(visitor);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "(9 / 2) * 3";
        final Visitor<String> visitor = new PrintVisitor();

        final String result = new Mult(new ParenthesisOperand(new Div(new Value(9), new Value(2))), new Value(3)).accept(visitor);


        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "(27 / 6) ^ 2";
        final Visitor<String> visitor = new PrintVisitor();

        final String result = new Pow(new ParenthesisOperand(new Div(new Value(27), new Value(6))), new Value(2)).accept(visitor);


        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "|value| - 8";
        final Visitor<String> visitor = new PrintVisitor();

        final String result = new Sub(new Module(new Variable("value")), new Value(8)).accept(visitor);


        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "|value| - 8";
        final Visitor<String> visitor = new PrintVisitor();

        final String result = new Sub(new Module(new Variable("value")), new Value(8)).accept(visitor);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5 - i) * 8";
        final Visitor<String> visitor = new PrintVisitor();

        final String result = new Mult(new ParenthesisOperand(new Sub(new Value(5), new Variable("i"))), new Value(8)).accept(visitor);

        assertThat(result, equalTo(expected));
    }
}