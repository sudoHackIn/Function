package com.function;

/**
 * Interface that have evaluate method, that describes behavior
 * @author El Altair
 * @version 1.0
 */
public interface Inequality {

    /**
     * Describe behavior with values, presented in param
     * @param map - map that
     * @return boolean boolean value of calculated behavior
     * @see FunctionMap
     */
    public boolean evaluate(FunctionMap map);
}
