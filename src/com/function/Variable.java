package com.function;

/** Variable class that extends Storable
 * @author El Altair
 * @version 1.0
 */
public class Variable extends Storable{

    /**
     * Default constructor to create new Variable, call Storable constructor
     * @param name name of created Variable
     * @see Storable
     */
    public Variable(String name){
        super(name);
    }

    /**
     * Constructor to create new Variable with value, call Storable constructor
     * @param name name of created Variable
     * @param value value of created Variable
     * @see Storable
     */
    public Variable(String name, double value){
        super(name, value);
    }
}
