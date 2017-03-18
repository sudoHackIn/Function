# Equation module
This module is used to work with equations different parameter and variable count and changable equation behavior.
Source files can be founded: `/src/com/equation/` JAR file: `/JAR/`

This example describe the main idea of working with equations:

## Simple equation with 1 param

Equation with 1 constant variable with name `"100500"` and value `100500.0`
and one changable param `"LOL"`

```java
Equation first = new Equation(new Param("LOL"), new Variable("100500", 100500.0));
```

Here we describe `equation behavior` with this param and variable
```java
first.function((i)->{
     return i.value("LOL") + i.value("100500");
});
```

Now we evaluate this equation and pass to it function argument `"LOL"` with value `1`
```java
System.out.println("First Equation " + first.evaluate(new Argument("LOL", 1)));
```
The result would be: `First Equation 100501.0`

Evaluate this equation again and now pass argument value `100`
```java
System.out.println("First Equation " + first.evaluate(new Argument("LOL", 100)));
```
The result would be: `First Equation 100600.0`

## Equation with 2 constant variables and 2 params

```java
Equation equation = new Equation(
               new Param("X1"),
               new Param("X2"),
               new Variable("a", 1.0),
               new Variable("tau",2.0)
       );
```
Describe behavior like that `X1 * X2 + a * tau`
```java
        equation.function((a)-> {
            return a.value("X1") * a.value("X2") + a.value("a") * a.value("tau");
        });

```
Create to arguments - X1 with value `2.0` and X2 with value `2.0`
```java
        Argument X1 = new Argument("X1", 2.0);
        Argument X2 = new Argument("X2", 2.0);
        System.out.println("Equation " +  equation.evaluate(X1, X2));
        X1.setValue(5.0);
        System.out.println("Equation " + equation.evaluate(X1, X2));
        X2.setValue(5.0);
        System.out.println("Equation " + equation.evaluate(X1, X2));
    }
```
The ouput will be: `Equation 6.0`
                   `Equation 12.0`
                   `Equation 27.0`
