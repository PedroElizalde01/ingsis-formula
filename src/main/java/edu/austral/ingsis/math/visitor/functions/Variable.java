package edu.austral.ingsis.math.visitor.functions;

import edu.austral.ingsis.math.visitor.visitors.Visitor;

public class Variable implements Function{
    private final String variable;

    public Variable(String variable){
        this.variable = variable;
    }

    public String getVariable(){
        return variable;
    }


    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitVariable(this);
    }
}

