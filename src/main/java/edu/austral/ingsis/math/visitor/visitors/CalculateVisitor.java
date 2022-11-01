package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.functions.Value;
import edu.austral.ingsis.math.visitor.functions.Variable;
import edu.austral.ingsis.math.visitor.functions.operations.*;
import edu.austral.ingsis.math.visitor.functions.operations.Module;

import java.util.Collections;
import java.util.Map;

public class CalculateVisitor implements Visitor<Double>{
    private final Map<String, Double> functions;

    public CalculateVisitor(){
        this.functions = Collections.emptyMap();
    }

    public CalculateVisitor(Map<String, Double> functions){
        this.functions = functions;
    }

    @Override
    public Double visitValue(Value value) {
        return value.getValue();
    }

    @Override
    public Double visitVariable(Variable variable) {
        return functions.get(variable.getVariable());
    }

    @Override
    public Double visitSum(Sum sum) {
        return sum.getF1().accept(this) + sum.getF2().accept(this);
    }

    @Override
    public Double visitSub(Sub sub) {
        return sub.getF1().accept(this) - sub.getF2().accept(this);
    }

    @Override
    public Double visitMult(Mult mult) {
        return mult.getF1().accept(this) * mult.getF2().accept(this);
    }

    @Override
    public Double visitDiv(Div div) {
        return div.getF1().accept(this) / div.getF2().accept(this);
    }

    @Override
    public Double visitPow(Pow pow) {
        return Math.pow(pow.getF1().accept(this), pow.getF2().accept(this));
    }

    @Override
    public Double visitModule(Module module) {
        return Math.abs(module.getF1().accept(this));
    }

    @Override
    public Double visitParenthesis(ParenthesisOperand parenthesis) {
        return parenthesis.getF1().accept(this);
    }
}
