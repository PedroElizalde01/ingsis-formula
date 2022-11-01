package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.functions.Value;
import edu.austral.ingsis.math.visitor.functions.Variable;
import edu.austral.ingsis.math.visitor.functions.operations.*;
import edu.austral.ingsis.math.visitor.functions.operations.Module;

import java.util.ArrayList;
import java.util.List;

public class ListVariablesVisitor implements Visitor<List<String>>{

    @Override
    public List<String> visitValue(Value value) {
        return new ArrayList<>();
    }

    @Override
    public List<String> visitVariable(Variable variable) {
        List<String> list = new ArrayList<>(1);
        list.add(variable.getVariable());
        return list;
    }

    @Override
    public List<String> visitSum(Sum sum) {
        return mergeLists(sum.getF1().accept(this), sum.getF2().accept(this));
    }

    @Override
    public List<String> visitSub(Sub sub) {
        return mergeLists(sub.getF1().accept(this), sub.getF2().accept(this));    }

    @Override
    public List<String> visitMult(Mult mult) {
        return mergeLists(mult.getF1().accept(this), mult.getF2().accept(this));
    }

    @Override
    public List<String> visitDiv(Div div) {
        return mergeLists(div.getF1().accept(this), div.getF2().accept(this));
    }

    @Override
    public List<String> visitPow(Pow pow) {
        return mergeLists(pow.getF1().accept(this), pow.getF2().accept(this));
    }

    @Override
    public List<String> visitModule(Module module) {
        return module.getF1().accept(this);
    }

    @Override
    public List<String> visitParenthesis(ParenthesisOperand parenthesis) {
        return parenthesis.getF1().accept(this);
    }

    private List<String> mergeLists(List<String> a,List<String> b ){
        for(String s : b){
            if(!a.contains(s)) a.add(s);
        }
        return a;
    }
}
