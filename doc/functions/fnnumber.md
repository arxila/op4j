# Functions: FnNumber

## 1. Overview

**[FnNumber](http://www.op4j.org/apidocs/org/op4j/functions/FnNumber.html)** is a *function hub class* containing a lot of static methods to work with `Number` objects. These static methods return functions that deal with `Number` objects, including conversions to `String`, currency formatting, rounding functions, and more.

## 2. Functions

| Function name      | Type                        | Params                                                                 | Description |
|--------------------|-----------------------------|------------------------------------------------------------------------|-------------|
| between            | Function<Number,Boolean>    | Number min, Number max<br>int min, int max<br>short min, short max<br>byte min, byte max<br>long min, long max<br>double min, double max<br>float min, float max | Determines whether the target object is between min and max in value (`target.compareTo(min) >= 0 && target.compareTo(max) <= 0`). Target and min/max must implement Comparable. |
| eq                 | Function<Number,Boolean>    | Number object<br>float object<br>double object<br>byte object<br>short object<br>int object<br>long object | Determines whether the target object and the specified object are equal by calling `equals` on the target. |
| eqBy               | Function<Number,Boolean>    | IFunction<Number,?> by, Number/primitive object | Determines whether the result of executing the specified function on the target and the object parameter are equal by calling `equals`. |
| eqValue            | Function<Number,Boolean>    | Number/primitive object | Determines whether the target and specified object are equal in value (`target.compareTo(object) == 0`). Both must implement Comparable. |
| eqValueBy          | Function<Number,Boolean>    | IFunction<Number,?> by, Number/primitive object | Determines whether the result of executing the specified function on the target and the object parameter are equal in value (`functionResult.compareTo(object) == 0`). Both must implement Comparable. |
| greaterOrEqTo      | Function<Number,Boolean>    | Number/primitive object | Determines whether the target is greater or equal to the specified object (`target.compareTo(object) >= 0`). Both must implement Comparable. |
| greaterOrEqToBy    | Function<Number,Boolean>    | IFunction<Number,?> by, Number/primitive object | Determines whether the result of executing the specified function on the target is greater or equal to the object parameter (`functionResult.compareTo(object) >= 0`). Both must implement Comparable. |
| greaterThan        | Function<Number,Boolean>    | Number/primitive object | Determines whether the target is greater than the specified object (`target.compareTo(object) > 0`). Both must implement Comparable. |
| greaterThanBy      | Function<Number,Boolean>    | IFunction<Number,?> by, Number/primitive object | Determines whether the result of executing the specified function on the target is greater than the object parameter (`functionResult.compareTo(object) > 0`). Both must implement Comparable. |
| isNotNull          | Function<Number,Boolean>    | — | Determines whether the target object is not null. |
| isNull             | Function<Number,Boolean>    | — | Determines whether the target object is null. |
| lessOrEqTo         | Function<Number,Boolean>    | Number/primitive object | Determines whether the target is less or equal to the specified object (`target.compareTo(object) <= 0`). Both must implement Comparable. |
| lessOrEqToBy       | Function<Number,Boolean>    | IFunction<Number,?> by, Number/primitive object | Determines whether the result of executing the specified function on the target is less or equal to the object parameter (`functionResult.compareTo(object) <= 0`). Both must implement Comparable. |
| lessThan           | Function<Number,Boolean>    | Number/primitive object | Determines whether the target is less than the specified object (`target.compareTo(object) < 0`). Both must implement Comparable. |
| lessThanBy         | Function<Number,Boolean>    | IFunction<Number,?> by, Number/primitive object | Determines whether the result of executing the specified function on the target is less than the object parameter (`functionResult.compareTo(object) < 0`). Both must implement Comparable. |
| notEq              | Function<Number,Boolean>    | Number/primitive object | Determines whether the target and specified object are NOT equal by calling `equals` on the target. |
| notEqBy            | Function<Number,Boolean>    | IFunction<Number,?> by, Number/primitive object | Determines whether the result of executing the specified function on the target and the object parameter are NOT equal by calling `equals`. |
| notEqValue         | Function<Number,Boolean>    | Number/primitive object | Determines whether the target and specified object are NOT equal in value (`target.compareTo(object) != 0`). Both must implement Comparable. |
| notEqValueBy       | Function<Number,Boolean>    | IFunction<Number,?> by, Number/primitive object | Determines whether the result of executing the specified function on the target and the object parameter are NOT equal in value (`functionResult.compareTo(object) != 0`). Both must implement Comparable. |
| roundBigDecimal    | Function<BigDecimal,BigDecimal> | int scale, RoundingMode roundingMode | Rounds the target object with the specified scale and rounding mode. |
| roundDouble        | Function<Double,Double>     | int scale, RoundingMode roundingMode | Rounds the target object with the specified scale and rounding mode. |
| roundFloat         | Function<Float,Float>       | int scale, RoundingMode roundingMode | Rounds the target with the specified scale and rounding mode. |
| toBigDecimal       | Function<Number,BigDecimal> | —<br>int scale, RoundingMode roundingMode | Converts the input into a BigDecimal, optionally using scale and rounding mode. |
| toBigInteger       | Function<Number,BigInteger> | —<br>RoundingMode roundingMode | Converts the input into a BigInteger, optionally using rounding mode. |
| toBoolean          | Function<Number,Boolean>    | — | Converts the input into a Boolean. |
| toByte             | Function<Number,Byte>       | —<br>RoundingMode roundingMode | Converts the input into a Byte, optionally using rounding mode. |
| toCurrencyStr      | Function<Number,String>     | Various locale, digit, grouping, separator, and formatting options | Returns the String representation of the target as a currency, with extensive formatting options. |
| toDouble           | Function<Number,Double>     | —<br>int scale, RoundingMode roundingMode | Converts the target into a Double, optionally using scale and rounding mode. |
| toFloat            | Function<Number,Float>      | —<br>int scale, RoundingMode roundingMode | Converts the input into a Float, optionally using scale and rounding mode. |
| toInteger          | Function<Number,Integer>    | —<br>RoundingMode roundingMode | Converts the target into an Integer, optionally using rounding mode. |
| toLong             | Function<Number,Long>       | —<br>RoundingMode roundingMode | Converts the input into a Long, optionally using rounding mode. |
| toPercentStr       | Function<Number,String>     | Various locale, digit, grouping, separator, and formatting options | Returns a String representing a percentage from the target number, with extensive formatting options. |
| toShort            | Function<Number,Short>      | —<br>RoundingMode roundingMode | Converts the input into a Short, optionally using rounding mode. |
| toStr              | Function<Number,String>     | Various locale, digit, grouping, separator, and formatting options | Returns the String representation of the input number, with extensive formatting options. |

---

*For detailed parameter options and formatting, see the [FnNumber JavaDoc](http://www.op4j.org/apidocs/org/op4j/functions/FnNumber.html).*
