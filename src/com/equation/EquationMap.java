package com.equation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class EquationMap{
    private Map<String, Storable> map;

    public EquationMap(){
        map = new HashMap<>();
    }

    public double value(String name){
        double returnValue = 0.0;
        try {
            returnValue =  map.get(name).value();
        }
        catch (NoSuchElementException e){
            System.err.println();
            System.err.println(e.getMessage());
            Arrays.stream(e.getStackTrace()).forEach(System.err::println);
            System.err.println();
        }
        return returnValue;
    }

    public void put(String name, Storable var){
        map.put(name,var);
    }

    public Storable get(String name){
        return map.get(name);
    }
}
