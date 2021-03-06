package com.function;

/**
 * Interface that have evaluate method, that describes behavior
 * @author El Altair
 * @version 1.0
 */
public interface Statement {

    /**
     * Describe behavior with values, presented in param
     * @param map - map that
     * @return double value of calculated, using presented behavior
     * @see FunctionMap
     */
    public double evaluate(FunctionMap map);
}
