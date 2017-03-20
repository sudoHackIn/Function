package com.function;

import static javax.management.Query.value;

public class Main {
    public static void main(String[] strs){
        Function first = new Function("first", new Param("LOL"));
        first.functionStatement((i)-> {
            return 2 * i.value("LOL");
        });
        System.out.println("First Equation " + first.evaluateStatement(new Argument("LOL", 1)));
        System.out.println("First Equation " + first.evaluateStatement(new Argument("LOL", 100)));

        Function equation = new Function(
                first,
                new Param("X1"),
                new Param("X2"),
                new Variable("a", 1.0),
                new Variable("tau",2.0)
        );

        equation.functionStatement((a)-> {
            return a.equation("first").evaluateStatement(new Argument("LOL", a.value("X1"))) +
                    a.value("X1") * a.value("X2");
        });


        equation.functionInequality((a)->{
            return a.equation("first").evaluateStatement(new Argument("LOL",a.value("X2"))) *
                    a.value("X1") * a.value("X2") >= a.value("a") * a.value("tau");
        });

        Argument X1 = new Argument("X1", 2.0);
        Argument X2 = new Argument("X2", 2.0);

        System.out.println("Magic " +  equation.evaluateStatement(X1, X2));
        // Ожидаем
        // first(X1) = 2 * X1;
        // function(X1, X2) = first(X1) + X1 * X2;
        // function(2,2) = f(2) + 2 * 2 = 4 + 4 = 8;

        X1.setValue(5.0);
        System.out.println("Magic " + equation.evaluateStatement(X1, X2));
        X2.setValue(5.0);
        System.out.println("Magic " + equation.evaluateStatement(X1, X2));
        System.out.println("Magic inequality " + equation.evaluateInequality(X1, X2));

    }

}
