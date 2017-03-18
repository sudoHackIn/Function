package com.equation;

public class Main {
    public static void main(String[] strs){
        Equation first = new Equation(new Param("LOL"), new Variable("100500", 100500.0));
        first.functionStatement((i)-> {
            return i.value("LOL") + i.value("100500");
        });
        System.out.println("First Equation " + first.evaluateStatement(new Argument("LOL", 1)));
        System.out.println("First Equation " + first.evaluateStatement(new Argument("LOL", 100)));

        Equation equation = new Equation(
                new Param("X1"),
                new Param("X2"),
                new Variable("a", 1.0),
                new Variable("tau",2.0)
        );

        equation.functionStatement((a)-> a.value("X1") * a.value("X2") + a.value("a") * a.value("tau"));

        Argument X1 = new Argument("X1", 2.0);
        Argument X2 = new Argument("X2", 2.0);
        System.out.println("Magic " +  equation.evaluateStatement(X1, X2));
        X1.setValue(5.0);
        System.out.println("Magic " + equation.evaluateStatement(X1, X2));
        X2.setValue(5.0);
        System.out.println("Magic " + equation.evaluateStatement(X1, X2));

    }

}
