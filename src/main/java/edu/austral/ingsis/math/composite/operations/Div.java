package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Div implements Function{

    private final Function f1;
    private final Function f2;

    public Div(Function f1, Function f2){
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public String toString(){
        return f1.toString() + " / " + f2.toString();
    }

    @Override
    public double calculate(Map<String, Double> map){
        return f1.calculate(map) / f2.calculate(map);
    }

    @Override
    public List<String> listVariables(){
        List<String> list = new ArrayList<>(f1.listVariables());
        list.addAll(f2.listVariables());
        return list;
    }

}