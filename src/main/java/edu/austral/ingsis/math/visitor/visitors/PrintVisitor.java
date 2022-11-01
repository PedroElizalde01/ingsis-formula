package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.functions.Value;
import edu.austral.ingsis.math.visitor.functions.Variable;
import edu.austral.ingsis.math.visitor.functions.operations.*;
import edu.austral.ingsis.math.visitor.functions.operations.Module;

public class PrintVisitor implements Visitor<String>{

    @Override
    public String visitValue(Value value) {
        if(value.getValue() % 1 == 0) return String.valueOf((int) value.getValue());
        return String.valueOf(value.getValue());
    }

    @Override
    public String visitVariable(Variable variable) {
        return variable.getVariable();
    }

    @Override
    public String visitSum(Sum sum) {
        return sum.getF1().accept(this) + " + " + sum.getF2().accept(this);
    }

    @Override
    public String visitSub(Sub sub) {
        return sub.getF1().accept(this) + " - " + sub.getF2().accept(this);
    }

    @Override
    public String visitMult(Mult mult) {
        return mult.getF1().accept(this) + " * " + mult.getF2().accept(this);
    }

    @Override
    public String visitDiv(Div div) {
        return div.getF1().accept(this) + " / " + div.getF2().accept(this);
    }

    @Override
    public String visitPow(Pow pow) {
        return pow.getF1().accept(this) + " ^ " + pow.getF2().accept(this);
    }

    @Override
    public String visitModule(Module module) {
        return "|" + module.getF1().accept(this) + "|";
    }

    @Override
    public String visitParenthesis(ParenthesisOperand parenthesis) {
        return "(" + parenthesis.getF1().accept(this) + ")";
    }
}
