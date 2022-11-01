package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.Function;
import edu.austral.ingsis.math.composite.Value;
import edu.austral.ingsis.math.composite.Variable;
import edu.austral.ingsis.math.composite.operations.*;
import edu.austral.ingsis.math.composite.operations.Module;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final Function f = new Sum(new Value(1.0),new Value(6.0));
        final String expected = "1 + 6";
        final String result = f.toString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final Function f = new Div(new Value(12.0),new Value(2.0));
        final String expected = "12 / 2";
        final String result = f.toString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final Function div = new Div(new Value(9.0), new Value(2.0));
        final Function f = new Mult(new ParenthsisOperand(div), new Value(3.0));
        final String expected = "(9 / 2) * 3";
        final String result = f.toString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final Function div = new Div(new Value(27.0), new Value(6.0));
        final Function f = new Pow(new ParenthsisOperand(div), new Value(2.0));
        final String expected = "(27 / 6) ^ 2";
        final String result = f.toString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final Function f = new Sub(new Module(new Variable("value")), new Value(8.0));
        final String expected = "|value| - 8";
        final String result = f.toString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final Function sub = new Sub(new Value(5.0), new Variable("i"));
        final Function f = new Mult(new ParenthsisOperand(sub), new Value(8.0));
        final String expected = "(5 - i) * 8";
        final String result = f.toString();

        assertThat(result, equalTo(expected));
    }
}
