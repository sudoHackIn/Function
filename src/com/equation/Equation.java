package com.equation;

public class Equation{
    private Evaluating functionMap;
    public EquationMap variableMap;

    public Equation(){
        variableMap = new EquationMap();
    }

    public Equation(Storable ... variables){
        variableMap = new EquationMap();
        for(Storable v:variables){
            variableMap.put(v.name(),v);
        }
    }

    public void function(Evaluating function){
        functionMap = function;
    }

    public double evaluate(Storable ... params){
        for(Storable p: params){
           variableMap.get(p.name()).setValue(p.value());
        }
        return functionMap.evaluate(variableMap);
    }

    public void set(String name, double value){
        variableMap.get(name).setValue(value);
    }

}
