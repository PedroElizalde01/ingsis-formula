package edu.austral.ingsis.math;

import edu.austral.ingsis.math.composite.Function;
import edu.austral.ingsis.math.composite.Value;
import edu.austral.ingsis.math.composite.Variable;
import edu.austral.ingsis.math.composite.operations.*;
import edu.austral.ingsis.math.composite.operations.Module;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        final Function f = new Sum(new Value(1.0),new Value(6.0));
        final List<String> result = f.listVariables();

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        final Function f = new Div(new Value(12.0),new Variable("div"));
        final List<String> result = f.listVariables();

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        final Function div = new Div(new Value(9.0), new Variable("x"));
        final Function f = new Mult(new ParenthsisOperand(div), new Variable("y"));
        final List<String> result = f.listVariables();

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        final Function div = new Div(new Value(27.0), new Variable("a"));
        final Function f = new Pow(new ParenthsisOperand(div), new Variable("b"));
        final List<String> result = f.listVariables();

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        final Function div = new Div(new Value(1.0), new Value(2.0));
        final Function f = new Pow(new Variable("z"),new ParenthsisOperand(div));
        final List<String> result = f.listVariables();

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        final Function f = new Sub(new Module(new Variable("value")), new Value(8.0));
        final List<String> result = f.listVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        final Function sub = new Sub(new Value(5.0), new Variable("i"));
        final Function f = new Mult(sub, new Value(8.0));
        final List<String> result = f.listVariables();

        assertThat(result, containsInAnyOrder("i"));
    }
}
