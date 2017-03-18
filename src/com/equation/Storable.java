package com.equation;

import java.util.NoSuchElementException;
import java.util.OptionalDouble;

/**
 * Abstract class that describes storable variable and param
 * @author El Altair
 * @version 1.0
 * @since 18.03.2017
 */
public abstract class Storable {
    private OptionalDouble value;
    private String name;

    /**
     * Default Constructor that creates Storable with empty OptionalDouble
     * @param name name of created item
     * @see OptionalDouble
     */
    public Storable(String name){
        this.name = name;
        this.value = OptionalDouble.empty();
    }

    /**
     * Constructor that creates Storable with OptionalDouble = value
     * @param name name of created item
     * @param value value of item
     */
    public Storable(String name, double value){
       this.name = name;
       this.value = OptionalDouble.of(value);
    }

    /**
     * Return value of Storable
     * @return double
     * @throws NoSuchElementException not found element
     */
    public double value() throws NoSuchElementException{
            return value.orElseThrow(()->new NoSuchElementException("Storable [" + this  + " | Name: " +
                    name + "] doesn't have value [" + value + "]. Use 0.0 as default"));
    }

    /**
     * Return name
     * @return String name of Storable item
     */
    public String name(){
        return name;
    }

    /**
     * Set value of current Storable item
     * @param value value to set
     */
    public void setValue(double value){
            this.value = OptionalDouble.of(value);
    }
}
