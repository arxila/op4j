# Functions: FnBigInteger

## 1. Overview

[FnBigInteger](http://www.op4j.org/apidocs/org/op4j/functions/FnBigInteger.html) is a *function hub class* containing many static methods to work with BigInteger objects. These static methods return functions that take a **BigInteger** object either as input or output (depending on the function). It includes conversions to String, currency representations, and logical operations between BigInteger objects, among others.

---

## 2. Functions

| Function name      | Type                                   | Params                                                                 | Description |
|--------------------|----------------------------------------|------------------------------------------------------------------------|-------------|
| **abs**            | Function<BigInteger, BigInteger>        |                                                                        | Returns the absolute value of the input |
| **add**            | Function<BigInteger, BigInteger>        | Number add<br>byte add<br>short add<br>int add<br>long add<br>float add<br>double add | Adds the given number to the target and returns the result |
| **avg**            | Function<Iterable<BigInteger>, BigInteger> | <br>RoundingMode roundingMode<br>MathContext mathContext              | Returns the average of all numbers in the Iterable input object. RoundingMode or MathContext can be used for rounding and precision |
| **avgArray**       | Function<BigInteger[], BigInteger>      | <br>RoundingMode roundingMode<br>MathContext mathContext              | Returns the average of all numbers in the input array. RoundingMode or MathContext can be used for rounding and precision |
| **between**        | Function<BigInteger,Boolean>            | Number min<br>Number max                                               | Determines if the target is between min and max |
| **divideBy**       | Function<BigInteger, BigInteger>        | Number divisor<br>byte divisor<br>short divisor<br>int divisor<br>long divisor<br>float divisor<br>double divisor | Divides the target by the given divisor and returns the result |
| **eq**             | Function<BigInteger,Boolean>            | BigInteger object                                                      | Checks if the target and specified object are equal (equals method) |
| **eqBy**           | Function<BigInteger,Boolean>            | IFunction<BigInteger,?> by<br>Object object                           | Checks if the result of executing the function on the target and object are equal |
| **eqValue**        | Function<BigInteger,Boolean>            | Number object                                                          | Checks if the target and specified object are equal in value (compareTo == 0) |
| **eqValueBy**      | Function<BigInteger,Boolean>            | IFunction<BigInteger,?> by<br>Object object                           | Checks if the result of executing the function on the target and object are equal in value |
| **greaterOrEqTo**  | Function<BigInteger,Boolean>            | Number object                                                          | Checks if the target is greater or equal to the specified object |
| **greaterOrEqToBy**| Function<BigInteger,Boolean>            | IFunction<BigInteger,?> by<br>Object object                           | Checks if the result of executing the function on the target is greater or equal to the object |
| **greaterThan**    | Function<BigInteger,Boolean>            | Number object                                                          | Checks if the target is greater than the specified object |
| **greaterThanBy**  | Function<BigInteger,Boolean>            | IFunction<BigInteger,?> by<br>Object object                           | Checks if the result of executing the function on the target is greater than the object |
| **isNotNull**      | Function<BigInteger,Boolean>            |                                                                        | Checks if the target is not null |
| **isNull**         | Function<BigInteger,Boolean>            |                                                                        | Checks if the target is null |
| **lessOrEqTo**     | Function<BigInteger,Boolean>            | Number object                                                          | Checks if the target is less or equal to the specified object |
| **lessOrEqToBy**   | Function<BigInteger,Boolean>            | IFunction<BigInteger,?> by<br>Object object                           | Checks if the result of executing the function on the target is less or equal to the object |
| **lessThan**       | Function<BigInteger,Boolean>            | Number object                                                          | Checks if the target is less than the specified object |
| **lessThanBy**     | Function<BigInteger,Boolean>            | IFunction<BigInteger,?> by<br>Object object                           | Checks if the result of executing the function on the target is less than the object |
| **max**            | Function<Iterable<BigInteger>, BigInteger> |                                                                        | Returns the maximum number from the Iterable input object |
| **maxArray**       | Function<BigInteger[], BigInteger>      |                                                                        | Returns the maximum number from the input array |
| **min**            | Function<Iterable<BigInteger>, BigInteger> |                                                                        | Returns the minimum number from the Iterable input object |
| **minArray**       | Function<BigInteger[], BigInteger>      |                                                                        | Returns the minimum number from the input array |
| **module**         | Function<BigInteger, BigInteger>        | byte module<br>short module<br>int module<br>long module<br>Byte module<br>Short module<br>Integer module<br>Long module<br>BigInteger module | Performs a module operation and returns the value of (input mod module), always positive |
| **multiplyBy**     | Function<BigInteger, BigInteger>        | Number multiplicand<br>byte multiplicand<br>short multiplicand<br>int multiplicand<br>long multiplicand<br>float multiplicand<br>double multiplicand | Multiplies the target by the given multiplicand and returns the result |
| **notEq**          | Function<BigInteger,Boolean>            | BigInteger object                                                      | Checks if the target and specified object are NOT equal |
| **notEqBy**        | Function<BigInteger,Boolean>            | IFunction<BigInteger,?> by<br>Object object                           | Checks if the result of executing the function on the target and object are NOT equal |
| **notEqValue**     | Function<BigInteger,Boolean>            | Number object                                                          | Checks if the target and specified object are NOT equal in value |
| **notEqValueBy**   | Function<BigInteger,Boolean>            | IFunction<BigInteger,?> by<br>Object object                           | Checks if the result of executing the function on the target and object are NOT equal in value |
| **pow**            | Function<BigInteger, BigInteger>        | int power                                                               | Raises the target to the given power and returns the result |
| **remainder**      | Function<BigInteger, BigInteger>        | Number divisor<br>byte divisor<br>short divisor<br>int divisor<br>long divisor<br>float divisor<br>double divisor | Divides the target by the given divisor and returns the remainder (target % divisor) |
| **subtract**       | Function<BigInteger, BigInteger>        | Number subtract<br>byte subtract<br>short subtract<br>int subtract<br>long subtract<br>float subtract<br>double subtract | Subtracts the given number from the target and returns the result |
| **sum**            | Function<Iterable<BigInteger>, BigInteger> |                                                                        | Returns the sum of all numbers in the Iterable input object |
| **sumArray**       | Function<BigInteger[], BigInteger>      |                                                                        | Returns the sum of all numbers in the input array |
| **toCurrencyStr**  | Function<BigInteger,String>             | <br>boolean groupingUsed<br>Locale locale<br>String locale<br>Locale locale + boolean groupingUsed<br>String locale + boolean groupingUsed | Returns the String representation of the target as a currency in the specified locale, with options for formatting |
| **toPercentStr**   | Function<BigInteger,String>             | <br>boolean groupingUsed<br>Locale locale<br>String locale<br>Locale locale + boolean groupingUsed<br>String locale + boolean groupingUsed | Returns a String representing a percentage from the target number, with options for formatting |
| **toStr**          | Function<BigInteger,String>             | <br>boolean groupingUsed<br>Locale locale<br>String locale<br>Locale locale + boolean groupingUsed<br>String locale + boolean groupingUsed | Returns the String representation of the input number, with options for formatting |
