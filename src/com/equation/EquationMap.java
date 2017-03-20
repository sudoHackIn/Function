package com.equation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Class that overload java java.util.Map methods to work with OptionalDouble
 * @author El Altair
 * @version 1.0
 * @see java.util.OptionalDouble
 */
public class EquationMap{
    private Map<String, Storable> map;

    public EquationMap(){
        map = new HashMap<>();
    }

    /**
     * Get Storable with param.name if presented and throws NoSuchElementException if not found
     * @param name name of Storable to get
     * @return double value of Storable item
     * @see NoSuchElementException
     */
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

    /**
     * Put new Storable to map
     * @param name name of Storable to put
     * @param var Storable to put
     */
    public void put(String name, Storable var){
        map.put(name,var);
    }

    /**
     * Return Storable from map
     * @param name name of Storable to get
     * @return Storable Storable object in map
     */
    public Storable get(String name){
        return map.get(name);
    }

    public Equation equation(String name){
        return (Equation) map.get(name);
    }
}
