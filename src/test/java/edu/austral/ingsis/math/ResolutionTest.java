package edu.austral.ingsis.math;

import edu.austral.ingsis.math.composite.Function;
import edu.austral.ingsis.math.composite.Value;
import edu.austral.ingsis.math.composite.operations.*;
import edu.austral.ingsis.math.composite.operations.Module;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        final Function f = new Sum(new Value(1.0), new Value(6.0));
        final Double result = f.calculate(Map.of());

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        final Function f = new Div(new Value(12.0), new Value(2.0));
        final Double result = f.calculate(Map.of());

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        final Function div = new Div(new Value(9.0), new Value(2.0));
        final Function f = new Mult(new ParenthsisOperand(div), new Value(3.0));
        final Double result = f.calculate(Map.of());

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        final Function div = new Div(new Value(27.0), new Value(6.0));
        final Function f = new Pow(new ParenthsisOperand(div), new Value(2.0));
        final Double result = f.calculate(Map.of());

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        final Function div = new Div(new Value(1.0), new Value(2.0));
        final Function f = new Pow(new Value(36d), new ParenthsisOperand(div));
        final Double result = f.calculate(Map.of());

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        final Function f = new Module(new Value(136d));
        final Double result = f.calculate(Map.of());

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        final Function f = new Module(new Value(-136d));
        final Double result = f.calculate(Map.of());

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        final Function sub = new Sub(new Value(5d),new Value(5d));
        final Function f = new Mult(new ParenthsisOperand(sub), new Value(8d));
        final Double result = f.calculate(Map.of());

        assertThat(result, equalTo(0d));
    }
}
