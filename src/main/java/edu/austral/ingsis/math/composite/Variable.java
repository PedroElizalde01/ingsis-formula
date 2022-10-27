package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;

public class Variable implements Function{

    private final String variable;

    public Variable(String variable){
        this.variable = variable;
    }

    @Override
    public String toString(){
        return variable;
    }

    @Override
    public double calculate(Map<String, Double> map){
        return map.get(variable);
    }

    @Override
    public List<String> listVariables(){
        return List.of(variable);
    }

}