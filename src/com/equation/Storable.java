package com.equation;

import java.util.NoSuchElementException;
import java.util.OptionalDouble;

public abstract class Storable {
    private OptionalDouble value;
    private String name;

    public Storable(String name){
        this.name = name;
        this.value = OptionalDouble.empty();
    }

    public Storable(String name, double value){
       this.name = name;
       this.value = OptionalDouble.of(value);
    }

    public double value() throws NoSuchElementException{
            return value.orElseThrow(()->new NoSuchElementException("Storable [" + this  + " | Name: " +
                    name + "] doesn't have value [" + value + "]. Use 0.0 as default"));
    }

    public String name(){
        return name;
    }

    public void setValue(double value){
            this.value = OptionalDouble.of(value);
    }
}
