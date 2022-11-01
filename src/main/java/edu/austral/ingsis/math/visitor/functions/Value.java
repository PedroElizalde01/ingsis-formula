package edu.austral.ingsis.math.visitor.functions;

import edu.austral.ingsis.math.visitor.visitors.Visitor;

public class Value implements Function{
    private final double value;

    public Value(double value){
        this.value = value;
    }

    public double getValue(){
        return value;
    }


    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitValue(this);
    }
}
