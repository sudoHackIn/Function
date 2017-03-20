package com.function;

/**
 *  This class presented function that can have different set of {@link Variable} and {@link Param}
 *  {@code
 *  Function e = new Function(new Variable("a", 2.0), new Param("X2"))
 *  e.function((a)->{
 *      return a.get("a").value() * a.get("X2").value();
 *  }
 *  e.evaluate(new Argument("X2", 2.0));
 *  }
 *
 *  @author El Altair
 *  @version 1.0
 *  @since 18.03.2017
 *  @see Variable
 *  @see Param
 *  @see Storable
 *  @see Argument
 */

public class Function extends Storable{
    private Statement functionStatement;
    private Inequality functionInequality;
    private FunctionMap variableMap;
    private Function linkedEquation;
    private String name;

    /**
     * @param variables List of {@link Storable} that describe used in function {@link Variable} and
     * {@link Param}
     * {@code
     * Function e = new Function(new Variable("a", 2.0), new Param("X2"))
     * }
     * @since 18.03.2017
     */
    public Function(Storable ... variables){
        super("");
        variableMap = new FunctionMap();
        for(Storable v:variables){
            variableMap.put(v.name(),v);
        }
    }

    public Function(String equationName, Storable ... variables){
        super(equationName);
        variableMap = new FunctionMap();
        for(Storable v:variables){
            variableMap.put(v.name(),v);
        }
    }
    /**
     * Method that save presented function behavior for it's lately using
     * @param function lambda expression that describes function behavior
     *                  {@code
     *                  function((a)->{a.get({@link Variable} or {@link Param}.value(), ...});
     *                  }
     * @since 18.03.2017
     */
    public void functionStatement(Statement function){
        functionStatement = function;
    }

    /**
     * Method that save presented function behavior for it's lately using
     * @param function lambda expression that describes function behavior
     *                  {@code
     *                  function((a)->{a.get({@link Variable} or {@link Param}.value(), ...});
     *                  }
     * @since 18.03.2017
     */
    public void functionInequality(Inequality function){
        functionInequality = function;
    }

    /**
     * Function that update presented in Equation Param values and then evaluate saved behavior
     * @param params List of {@link Argument} that are used as function arguments to pass value for @{link Param} in function
     * @return double result of stored function behavior
     */
    public double evaluateStatement(Storable ... params){
        for(Storable p: params){
           variableMap.get(p.name()).setValue(p.value());
        }
        return functionStatement.evaluate(variableMap);
    }

    /**
     * Function that update presented in Function Param values and then evaluate saved behavior
     * @param params List of {@link Argument} that are used as function arguments to pass value for @{link Param} in function
     * @return boolean boolean result of stored function behavior
     */
    public boolean evaluateInequality(Storable ... params){
        for(Storable p: params){
            variableMap.get(p.name()).setValue(p.value());
        }
        return functionInequality.evaluate(variableMap);

    }
}
