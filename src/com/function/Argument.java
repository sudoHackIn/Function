package com.function;

/**
 * This class extends {@link Storable} and presented Argument, that passes to {@link Function}
 * @author El Altair
 * @version 1.0
 * @since 18.03.2017
 *
 */
public class Argument extends Storable{
    /**
     * Default constructor to create new Argument, call Storable constructor
     * @param name name of argument
     * @param value value of argument
     * @see Storable
     */
    public Argument(String name, double value){
        super(name, value);
    }
}
