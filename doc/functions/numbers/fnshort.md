# Functions: FnShort

## 1. Overview

`FnShort` is a *function hub class* containing many static methods to work with `Short` objects. These methods return functions that take a `Short` object as input or output, including conversions to `String` and logical operations between `Short` objects, among others.

## 2. Functions

| Function name      | Type                        | Params                                                                 | Description |
|--------------------|-----------------------------|------------------------------------------------------------------------|-------------|
| abs                | Function<Short, Short>      | —                                                                      | Returns the absolute value of the input. |
| add                | Function<Short, Short>      | Number/byte/short/int/long/float/double add                            | Adds the given number to the target and returns the result. |
| avg                | Function<Iterable<Short>, Short> | —<br>MathContext mathContext<br>RoundingMode roundingMode         | Returns the average of all numbers in the Iterable input object, optionally using MathContext or RoundingMode. |
| avgArray           | Function<Short[], Short>    | —<br>MathContext mathContext<br>RoundingMode roundingMode             | Returns the average of all numbers in the input array, optionally using MathContext or RoundingMode. |
| between            | Function<Short,Boolean>     | Number min, Number max<br>short min, short max                       | Determines if the target is between min and max (`target.compareTo(min) >= 0 && target.compareTo(max) <= 0`). Both must implement Comparable. |
| divideBy           | Function<Short, Short>      | Number/byte/short/int/long/float/double divisor<br>MathContext/RoundingMode | Divides the target by the given divisor and returns the result, optionally using MathContext or RoundingMode. |
| eq                 | Function<Short,Boolean>     | Short object<br>short object                                         | Determines if the target and specified object are equal by calling `equals` on the target. |
| eqBy               | Function<Short,Boolean>     | IFunction<Short,?> by, Object object                                   | Determines if the result of executing the specified function on the target and object are equal by calling `equals`. |
| eqValue            | Function<Short,Boolean>     | Number object<br>short object                                         | Determines if the target and specified object are equal in value (`target.compareTo(object) == 0`). Both must implement Comparable. |
| eqValueBy          | Function<Short,Boolean>     | IFunction<Short,?> by, Object object                                   | Determines if the result of executing the specified function on the target and object are equal in value (`functionResult.compareTo(object) == 0`). Both must implement Comparable. |
| greaterOrEqTo      | Function<Short,Boolean>     | Number object<br>short object                                         | Determines if the target is greater or equal to the specified object (`target.compareTo(object) >= 0`). Both must implement Comparable. |
| greaterOrEqToBy    | Function<Short,Boolean>     | IFunction<Short,?> by, Object object                                   | Determines if the result of executing the specified function on the target is greater or equal to the object (`functionResult.compareTo(object) >= 0`). Both must implement Comparable. |
| greaterThan        | Function<Short,Boolean>     | Number object<br>short object                                         | Determines if the target is greater than the specified object (`target.compareTo(object) > 0`). Both must implement Comparable. |
| greaterThanBy      | Function<Short,Boolean>     | IFunction<Short,?> by, Object object                                   | Determines if the result of executing the specified function on the target is greater than the object (`functionResult.compareTo(object) > 0`). Both must implement Comparable. |
| isNotNull          | Function<Short,Boolean>     | —                                                                      | Determines if the target object is not null. |
| isNull             | Function<Short,Boolean>     | —                                                                      | Determines if the target object is null. |
| lessOrEqTo         | Function<Short,Boolean>     | Number object<br>short object                                         | Determines if the target is less or equal to the specified object (`target.compareTo(object) <= 0`). Both must implement Comparable. |
| lessOrEqToBy       | Function<Short,Boolean>     | IFunction<Short,?> by, Object object                                   | Determines if the result of executing the specified function on the target is less or equal to the object (`functionResult.compareTo(object) <= 0`). Both must implement Comparable. |
| lessThan           | Function<Short,Boolean>     | Number object<br>short object                                         | Determines if the target is less than the specified object (`target.compareTo(object) < 0`). Both must implement Comparable. |
| lessThanBy         | Function<Short,Boolean>     | IFunction<Short,?> by, Object object                                   | Determines if the result of executing the specified function on the target is less than the object (`functionResult.compareTo(object) < 0`). Both must implement Comparable. |
| max                | Function<Iterable<Short>, Short> | —                                                                | Returns the maximum number from an Iterable input object. |
| maxArray           | Function<Short[], Short>    | —                                                                      | Returns the maximum number from the input array. |
| min                | Function<Iterable<Short>, Short> | —                                                                | Returns the minimum number from an Iterable input object. |
| minArray           | Function<Short[], Short>    | —                                                                      | Returns the minimum number from the input array. |
| module             | Function<Short, Short>      | byte/short/int/long/Byte/Short/Integer/Long/BigInteger module          | Performs a module operation and returns the value of (input mod module), always positive. |
| multiplyBy         | Function<Short, Short>      | Number/byte/short/int/long/float/double multiplicand<br>MathContext/RoundingMode | Multiplies the target by the multiplicand and returns the value, optionally using MathContext or RoundingMode. |
| notEq              | Function<Short,Boolean>     | Short object<br>short object                                         | Determines if the target and specified object are NOT equal by calling `equals` on the target. |
| notEqBy            | Function<Short,Boolean>     | IFunction<Short,?> by, Object object                                   | Determines if the result of executing the specified function on the target and object are NOT equal by calling `equals`. |
| notEqValue         | Function<Short,Boolean>     | Number object<br>short object                                         | Determines if the target and specified object are NOT equal in value (`target.compareTo(object) != 0`). Both must implement Comparable. |
| notEqValueBy       | Function<Short,Boolean>     | IFunction<Short,?> by, Object object                                   | Determines if the result of executing the specified function on the target and object are NOT equal in value (`functionResult.compareTo(object) != 0`). Both must implement Comparable. |
| pow                | Function<Short, Short>      | int power<br>int power, MathContext<br>int power, RoundingMode         | Performs the operation target^power and returns its value, optionally using MathContext or RoundingMode. |
| remainder          | Function<Short, Short>      | Number/byte/short/int/long/float/double divisor                        | Divides the target by the divisor and returns the remainder (target % divisor). |
| subtract           | Function<Short, Short>      | Number/byte/short/int/long/float/double subtract                       | Subtracts the given number from the target and returns the result. |
| sum                | Function<Iterable<Short>, Short> | —                                                                | Returns the sum of all numbers in the Iterable input object. |
| sumArray           | Function<Short[], Short>    | —                                                                      | Returns the sum of all numbers in the input array. |
| toCurrencyStr      | Function<Short,String>      | —<br>boolean groupingUsed<br>Locale locale<br>String locale<br>Locale locale, boolean groupingUsed<br>String locale, boolean groupingUsed | Returns the String representation of the target as a currency, with various formatting options. |
| toPercentStr       | Function<Short,String>      | —<br>boolean groupingUsed<br>Locale locale<br>String locale<br>Locale locale, boolean groupingUsed<br>String locale, boolean groupingUsed | Returns a String representing a percentage from the target number, with various formatting options. |
| toStr              | Function<Short,String>      | —<br>boolean groupingUsed<br>Locale locale<br>String locale<br>Locale locale, boolean groupingUsed<br>String locale, boolean groupingUsed | Returns the String representation of the input number, with various formatting options. |

