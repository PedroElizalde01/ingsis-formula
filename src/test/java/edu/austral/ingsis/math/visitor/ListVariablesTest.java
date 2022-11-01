package edu.austral.ingsis.math.visitor;


import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.functions.operations.*;
import edu.austral.ingsis.math.visitor.functions.operations.Module;
import edu.austral.ingsis.math.visitor.visitors.ListVariablesVisitor;
import edu.austral.ingsis.math.visitor.visitors.Visitor;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {

        final Function f = new Sum(new Value(1),new Value(6));
        final Visitor<List<String>> visitor = new ListVariablesVisitor();
        final List<String> result = f.accept(visitor);

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {

        final Function f = new Div(new Value(12), new Variable("div"));
        final Visitor<List<String>> visitor = new ListVariablesVisitor();
        final List<String> result = f.accept(visitor);

        assertThat(result, containsInAnyOrder("div"));
    }

    @Test
    public void shouldListVariablesFunction15() {

        final Function f = new Div(new Sum(new Variable("div"), new Variable("xd")), new Variable("div"));
        final Visitor<List<String>> visitor = new ListVariablesVisitor();
        final List<String> result = f.accept(visitor);
        assertThat(result, containsInAnyOrder("div", "xd"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {

        final Function f = new Mult(new Div(new Value(9), new Variable("x")),new Variable("y"));
        final Visitor<List<String>> visitor = new ListVariablesVisitor();
        final List<String> result = f.accept(visitor);

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {

        final Function f = new Pow(new Div(new Value(27), new Variable("a")), new Variable("b"));
        final Visitor<List<String>> visitor = new ListVariablesVisitor();
        final List<String> result = f.accept(visitor);
        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {

        final Function f = new Pow(new Variable("z"), new Div(new Value(1), new Value(2)));
        final Visitor<List<String>> visitor = new ListVariablesVisitor();
        final List<String> result = f.accept(visitor);

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {

        final Function f = new Sub(new Module(new Variable("value")), new Value(8));
        final Visitor<List<String>> visitor = new ListVariablesVisitor();
        final List<String> result = f.accept(visitor);
        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {

        final Function f = new Sub(new Module(new Variable("value")), new Value(8));
        final Visitor<List<String>> visitor = new ListVariablesVisitor();
        final List<String> result = f.accept(visitor);

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {

        final Function f = new Mult(new Sub(new Value(5), new Variable("i")), new Value(8));
        final Visitor<List<String>> visitor = new ListVariablesVisitor();
        final List<String> result = f.accept(visitor);
        assertThat(result, containsInAnyOrder("i"));
    }
}