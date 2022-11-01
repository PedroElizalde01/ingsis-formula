package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.Function;
import edu.austral.ingsis.math.composite.Value;
import edu.austral.ingsis.math.composite.Variable;
import edu.austral.ingsis.math.composite.operations.*;
import edu.austral.ingsis.math.composite.operations.Module;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        final Function f = new Sum(new Value(1d), new Variable("x"));
        final Double result = f.calculate(Map.of("x",3d));

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        final Function f = new Div(new Value(12.0),new Variable("div"));
        final Double result = f.calculate(Map.of("div",4d));

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        final Function div = new Div(new Value(9.0), new Variable("x"));
        final Function f = new Mult(new ParenthsisOperand(div), new Variable("y"));
        final Double result = f.calculate(Map.of("x",3d,"y",4d));

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        final Function div = new Div(new Value(27.0), new Variable("a"));
        final Function f = new Pow(new ParenthsisOperand(div), new Variable("b"));
        final Double result = f.calculate(Map.of("a",9d,"b",3d));

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        final Function div = new Div(new Value(1.0), new Value(2.0));
        final Function f = new Pow(new Variable("z"),new ParenthsisOperand(div));
        final Double result = f.calculate(Map.of("z",36d));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        final Function f = new Sub(new Module(new Variable("value")), new Value(8.0));
        final Double result = f.calculate(Map.of("value",8d));

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        final Function sub = new Sub(new Value(5.0), new Variable("i"));
        final Function f = new Mult(sub, new Value(8.0));
        final Double result = f.calculate(Map.of("i",2d));

        assertThat(result, equalTo(24d));
    }
}
