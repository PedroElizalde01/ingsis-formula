package edu.austral.ingsis.math.visitor.functions.operations;

import edu.austral.ingsis.math.visitor.functions.Function;
import edu.austral.ingsis.math.visitor.visitors.Visitor;

public class ParenthesisOperand implements Function {
    private final Function f1;

    public ParenthesisOperand(Function f1) {
        this.f1 = f1;
    }

    public Function getF1() {
        return f1;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitParenthesis(this);
    }
}
