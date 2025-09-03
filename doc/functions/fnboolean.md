# Functions: FnBoolean

## 1. Overview

[FnBoolean](http://www.op4j.org/apidocs/org/op4j/functions/FnBoolean.html) is a *function hub class* containing many static methods returning functions that take a **Boolean** object as input.

---

## 2. Functions

| Function name      | Type                                   | Params                                                                 | Description |
|--------------------|----------------------------------------|------------------------------------------------------------------------|-------------|
| **and**            | Function<R,Boolean>                    | IFunction<X,Boolean> left<br>IFunction<? super R,Boolean> right        | Returns true if both functions return true, false otherwise |
| **eq**             | Function<Object,Boolean>               | Boolean object<br>boolean object                                       | Checks if the target and specified object are equal (equals method) |
| **eqBy**           | Function<X,Boolean>                    | IFunction<X,?> by<br>Boolean object<br>boolean object                | Checks if the result of executing the function on the target and object are equal |
| **isFalse**        | Function<Boolean,Boolean>               |                                                                        | Returns true if the target is Boolean.FALSE, false otherwise |
| **isNotNull**      | Function<Object,Boolean>                |                                                                        | Checks if the target is not null |
| **isNotNullBy**    | Function<X,Boolean>                     | IFunction<X,?> by                                                      | Checks if the result of executing the function on the target is not null |
| **isNull**         | Function<Object,Boolean>                |                                                                        | Checks if the target is null |
| **isNullBy**       | Function<X,Boolean>                     | IFunction<X,?> by                                                      | Checks if the result of executing the function on the target is null |
| **isTrue**         | Function<Boolean,Boolean>               |                                                                        | Returns true if the target is Boolean.TRUE, false otherwise |
| **negate**         | Function<Boolean,Boolean>               |                                                                        | Negates the target Boolean |
| **not**            | Function<T,Boolean>                     | IFunction<T, Boolean> function                                         | Returns true if the specified function returns false, false otherwise |
| **notEq**          | Function<Object,Boolean>                | Boolean object<br>boolean object                                       | Checks if the target and specified object are NOT equal |
| **notEqBy**        | Function<X,Boolean>                    | IFunction<X,?> by<br>Boolean object<br>boolean object                | Checks if the result of executing the function on the target and object are NOT equal |
| **or**             | Function<R,Boolean>                    | IFunction<X,Boolean> left<br>IFunction<? super R,Boolean> right        | Returns true if any of the functions returns true, false otherwise |
| **toBigDecimal**   | Function<Boolean,BigDecimal>            |                                                                        | Converts Boolean to BigDecimal (true = 1, false = 0) |
| **toBigInteger**   | Function<Boolean,BigInteger>            |                                                                        | Converts Boolean to BigInteger (true = 1, false = 0) |
| **toByte**         | Function<Boolean,Byte>                  |                                                                        | Converts Boolean to Byte (true = 1, false = 0) |
| **toDouble**       | Function<Boolean,Double>                |                                                                        | Converts Boolean to Double (true = 1, false = 0) |
| **toFloat**        | Function<Boolean,Float>                 |                                                                        | Converts Boolean to Float (true = 1, false = 0) |
| **toInteger**      | Function<Boolean,Integer>               |                                                                        | Converts Boolean to Integer (true = 1, false = 0) |
| **toLong**         | Function<Boolean,Long>                  |                                                                        | Converts Boolean to Long (true = 1, false = 0) |
| **toShort**        | Function<Boolean,Short>                 |                                                                        | Converts Boolean to Short (true = 1, false = 0) |
