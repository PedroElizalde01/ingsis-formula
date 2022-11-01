package edu.austral.ingsis.math.visitor;


import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.functions.operations.*;
import edu.austral.ingsis.math.visitor.functions.operations.Module;
import edu.austral.ingsis.math.visitor.functions.operations.ParenthesisOperand;
import edu.austral.ingsis.math.visitor.visitors.CalculateVisitor;
import edu.austral.ingsis.math.visitor.visitors.Visitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        final Visitor<Double> visitor = new CalculateVisitor();
        final Double result = new Sum(new Value(1), new Value(6)).accept(visitor);
        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        Visitor<Double> visitor = new CalculateVisitor();
        final Double result = new Div(new Value(12), new Value(2)).accept(visitor);
        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        Visitor<Double> visitor = new CalculateVisitor();



        final Double result = new Mult(new Div(new Value(9), new Value(2)), new Value(3)).accept(visitor);
        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        Visitor<Double> visitor = new CalculateVisitor();

        final Double result = new Pow(new Div(new Value(27), new Value(6)), new Value(2)).accept(visitor);
        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        Visitor<Double> visitor = new CalculateVisitor();

        final Double result = new Pow(new Value(36), new Div(new Value(1), new Value(2))).accept(visitor);
        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        Visitor<Double> visitor = new CalculateVisitor();

        final Double result = new Module(new Value(136)).accept(visitor);
        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        Visitor<Double> visitor = new CalculateVisitor();

        final Double result =  new Module(new Value(-136)).accept(visitor);

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        Visitor<Double> visitor = new CalculateVisitor();

        final Double result = new Mult(new Sub(new Value(5), new Value(5)), new Value(8)).accept(visitor);
        assertThat(result, equalTo(0d));
    }
}