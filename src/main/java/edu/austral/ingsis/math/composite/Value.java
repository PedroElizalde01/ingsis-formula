package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;

public class Value implements Function{

    private final double value;

    public Value(double value){
        this.value = value;
    }

    @Override
    public double calculate(Map<String, Double> map){
        return value;
    }

    @Override
    public List<String> listVariables(){
        return List.of();
    }

    @Override
    public String toString(){
        return value % 1 == 0 ? "" + (int) value : "" + value;
    }
}