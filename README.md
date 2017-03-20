# Function module  ([Javadocs](https://elaltair.github.io/Function/.))
This module is used to work with equations different parameter and variable count and changable equation behavior.
Source files can be founded: `/src/com/function/` JAR file: `/JAR/`

This example describe the main idea of working with equations:

## Simple function with 1 param

Equation with 1 constant variable with name `"100500"` and value `100500.0`
and one changable param `"LOL"`

```java
Function first = new Function(new Param("LOL"), new Variable("100500", 100500.0));
```

Here we describe `function behavior` with this param and variable
```java
first.functionStatement((i)->{
     return i.value("LOL") + i.value("100500");
});
```

Now we evaluate this function and pass to it argument `"LOL"` with value `1`
```java
System.out.println("First function " + first.evaluate(new Argument("LOL", 1)));
```
The result would be: `First function 100501.0`

Evaluate this function again and now pass argument value `100`
```java
System.out.println("First function " + first.evaluateStatement(new Argument("LOL", 100)));
```
The result would be: `First function 100600.0`

## Function with 2 constant variables and 2 params

```java
Function func = new Function(
               new Param("X1"),
               new Param("X2"),
               new Variable("a", 1.0),
               new Variable("tau",2.0)
       );
```
Describe behavior like that `X1 * X2 + a * tau`
```java
        func.functionStatement((a)-> {
            return a.value("X1") * a.value("X2") + a.value("a") * a.value("tau");
        });

```
Create to arguments - X1 with value `2.0` and X2 with value `2.0`
```java
        Argument X1 = new Argument("X1", 2.0);
        Argument X2 = new Argument("X2", 2.0);
        System.out.println("Function " +  func.evaluateStatement(X1, X2));
        X1.setValue(5.0);
        System.out.println("Function " + func.evaluateStatement(X1, X2));
        X2.setValue(5.0);
        System.out.println("Function " + func.evaluateStatement(X1, X2));
    }
```
The ouput will be: `Function 6.0`
                   `Function 12.0`
                   `Function 27.0`
