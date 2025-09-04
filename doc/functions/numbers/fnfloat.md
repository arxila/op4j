# Functions: FnFloat

## 1. Overview

`FnFloat` is a *function hub class* containing a lot of static methods to work with Float objects. Those static methods return functions that take a `Float` object either as its input or output (depending on the function). It includes conversions to String, to a String representing a currency, and logical operations between Float objects among others.

## 2. Functions

| Function name      | Type                           | Params                                   | Description |
|--------------------|--------------------------------|-------------------------------------------|-------------|
| **abs**            | Function<Float, Float>         |                                           | It returns the absolute value of the input |
| **add**            | Function<Float, Float>         | Number add                                | It adds the given number to the target and returns the result |
| **add**            | Function<Float, Float>         | byte add                                  | It adds the given number to the target and returns the result |
| **add**            | Function<Float, Float>         | short add                                 | It adds the given number to the target and returns the result |
| **add**            | Function<Float, Float>         | int add                                   | It adds the given number to the target and returns the result |
| **add**            | Function<Float, Float>         | long add                                  | It adds the given number to the target and returns the result |
| **add**            | Function<Float, Float>         | float add                                 | It adds the given number to the target and returns the result |
| **add**            | Function<Float, Float>         | double add                                | It adds the given number to the target and returns the result |
| **avg**            | Function<Iterable<Float>, Float>|                                           | It returns the average of all the numbers in the Iterable input object |
| **avg**            | Function<Iterable<Float>, Float>| MathContext mathContext                   | It returns the average of all the numbers in the Iterable input object. The given MathContext will be used to round and set the output precision |
| **avg**            | Function<Iterable<Float>, Float>| RoundingMode roundingMode                 | It returns the average of all the numbers in the Iterable input object. The given RoundingMode will be used to round the output |
| **avgArray**       | Function<Float[], Float>       |                                           | It returns the average of all the numbers in the input array |
| **avgArray**       | Function<Float[], Float>       | MathContext mathContext                   | It returns the average of all the numbers in the input array. The given MathContext will be used to round and set the output precision |
| **avgArray**       | Function<Float[], Float>       | RoundingMode roundingMode                 | It returns the average of all the numbers in the input array. The given RoundingMode will be used to round the output |
| **between**        | Function<Float,Boolean>        | Number min, Number max                    | Determines whether the target object is between min and max in value |
| **between**        | Function<Float,Boolean>        | float min, float max                      | Determines whether the target object is between min and max in value |
| **divideBy**       | Function<Float, Float>         | Number divisor                            | It divides the target element by the given divisor and returns its result |
| **divideBy**       | Function<Float, Float>         | byte divisor                              | It divides the target element by the given divisor and returns its result |
| **divideBy**       | Function<Float, Float>         | short divisor                             | It divides the target element by the given divisor and returns its result |
| **divideBy**       | Function<Float, Float>         | int divisor                               | It divides the target element by the given divisor and returns its result |
| **divideBy**       | Function<Float, Float>         | long divisor                              | It divides the target element by the given divisor and returns its result |
| **divideBy**       | Function<Float, Float>         | float divisor                             | It divides the target element by the given divisor and returns its result |
| **divideBy**       | Function<Float, Float>         | double divisor                            | It divides the target element by the given divisor and returns its result |
| **divideBy**       | Function<Float, Float>         | Number divisor, MathContext mathContext   | It divides the target element by the given divisor and returns its result with the precision and rounding mode specified by mathContext |
| **divideBy**       | Function<Float, Float>         | byte divisor, MathContext mathContext     | It divides the target element by the given divisor and returns its result with the precision and rounding mode specified by mathContext |
| **divideBy**       | Function<Float, Float>         | short divisor, MathContext mathContext    | It divides the target element by the given divisor and returns its result with the precision and rounding mode specified by mathContext |
| **divideBy**       | Function<Float, Float>         | int divisor, MathContext mathContext      | It divides the target element by the given divisor and returns its result with the precision and rounding mode specified by mathContext |
| **divideBy**       | Function<Float, Float>         | long divisor, MathContext mathContext     | It divides the target element by the given divisor and returns its result with the precision and rounding mode specified by mathContext |
| **divideBy**       | Function<Float, Float>         | float divisor, MathContext mathContext    | It divides the target element by the given divisor and returns its result with the precision and rounding mode specified by mathContext |
| **divideBy**       | Function<Float, Float>         | double divisor, MathContext mathContext   | It divides the target element by the given divisor and returns its result with the precision and rounding mode specified by mathContext |
| **divideBy**       | Function<Float, Float>         | Number divisor, RoundingMode roundingMode | It divides the target element by the given divisor and returns its result rounded based on the specified rounding mode |
| **divideBy**       | Function<Float, Float>         | byte divisor, RoundingMode roundingMode   | It divides the target element by the given divisor and returns its result rounded based on the specified rounding mode |
| **divideBy**       | Function<Float, Float>         | short divisor, RoundingMode roundingMode  | It divides the target element by the given divisor and returns its result rounded based on the specified rounding mode |
| **divideBy**       | Function<Float, Float>         | int divisor, RoundingMode roundingMode    | It divides the target element by the given divisor and returns its result rounded based on the specified rounding mode |
| **divideBy**       | Function<Float, Float>         | long divisor, RoundingMode roundingMode   | It divides the target element by the given divisor and returns its result rounded based on the specified rounding mode |
| **divideBy**       | Function<Float, Float>         | float divisor, RoundingMode roundingMode  | It divides the target element by the given divisor and returns its result rounded based on the specified rounding mode |
| **divideBy**       | Function<Float, Float>         | double divisor, RoundingMode roundingMode | It divides the target element by the given divisor and returns its result rounded based on the specified rounding mode |
| **eq**             | Function<Float,Boolean>        | Float object                              | Determines whether the target object and the specified object are equal by calling the `equals` method on the target object. |
| **eq**             | Function<Float,Boolean>        | float object                              | Determines whether the target object and the specified object are equal by calling the `equals` method on the target object. |
| **eqBy**           | Function<Float,Boolean>        | IFunction<Float,?> by, Object object      | Determines whether the result of executing the specified function on the target object and the specified object parameter are equal by calling the `equals` method. |
| **eqValue**        | Function<Float,Boolean>        | Number object                             | Determines whether the target object and the specified object are equal in value, i.e., `target.compareTo(object) == 0`. Both must implement Comparable. |
| **eqValue**        | Function<Float,Boolean>        | float object                              | Determines whether the target object and the specified object are equal in value, i.e., `target.compareTo(object) == 0`. Both must implement Comparable. |
| **eqValueBy**      | Function<Float,Boolean>        | IFunction<Float,?> by, Object object      | Determines whether the result of executing the specified function on the target object and the specified object parameter are equal in value, i.e., `functionResult.compareTo(object) == 0`. Both must implement Comparable. |
| **greaterOrEqTo**  | Function<Float,Boolean>        | Number object                             | Determines whether the target object is greater or equal to the specified object in value, i.e., `target.compareTo(object) >= 0`. Both must implement Comparable. |
| **greaterOrEqTo**  | Function<Float,Boolean>        | float object                              | Determines whether the target object is greater or equal to the specified object in value, i.e., `target.compareTo(object) >= 0`. Both must implement Comparable. |
| **greaterOrEqToBy**| Function<Float,Boolean>        | IFunction<Float,?> by, Object object      | Determines whether the result of executing the specified function on the target object is greater or equal to the specified object parameter in value, i.e., `functionResult.compareTo(object) >= 0`. Both must implement Comparable. |
| **greaterThan**    | Function<Float,Boolean>        | Number object                             | Determines whether the target object is greater than the specified object in value, i.e., `target.compareTo(object) > 0`. Both must implement Comparable. |
| **greaterThan**    | Function<Float,Boolean>        | float object                              | Determines whether the target object is greater than the specified object in value, i.e., `target.compareTo(object) > 0`. Both must implement Comparable. |
| **greaterThanBy**  | Function<Float,Boolean>        | IFunction<Float,?> by, Object object      | Determines whether the result of executing the specified function on the target object is greater than the specified object parameter in value, i.e., `functionResult.compareTo(object) > 0`. Both must implement Comparable. |
| **isNotNull**      | Function<Float,Boolean>        |                                           | Determines whether the target object is null or not. |
| **isNull**         | Function<Float,Boolean>        |                                           | Determines whether the target object is null or not. |
| **lessOrEqTo**     | Function<Float,Boolean>        | Number object                             | Determines whether the target object is less or equal to the specified object in value, i.e., `target.compareTo(object) <= 0`. Both must implement Comparable. |
| **lessOrEqTo**     | Function<Float,Boolean>        | float object                              | Determines whether the target object is less or equal to the specified object in value, i.e., `target.compareTo(object) <= 0`. Both must implement Comparable. |
| **lessOrEqToBy**   | Function<Float,Boolean>        | IFunction<Float,?> by, Object object      | Determines whether the result of executing the specified function on the target object is less or equal to the specified object parameter in value, i.e., `functionResult.compareTo(object) <= 0`. Both must implement Comparable. |
| **lessThan**       | Function<Float,Boolean>        | Number object                             | Determines whether the target object is less than the specified object in value, i.e., `target.compareTo(object) < 0`. Both must implement Comparable. |
| **lessThan**       | Function<Float,Boolean>        | float object                              | Determines whether the target object is less than the specified object in value, i.e., `target.compareTo(object) < 0`. Both must implement Comparable. |
| **lessThanBy**     | Function<Float,Boolean>        | IFunction<Float,?> by, Object object      | Determines whether the result of executing the specified function on the target object is less than the specified object parameter in value, i.e., `functionResult.compareTo(object) < 0`. Both must implement Comparable. |
| **max**            | Function<Iterable<Float>, Float>|                                           | It returns the maximum number from an Iterable input object |
| **maxArray**       | Function<Float[], Float>       |                                           | It returns the maximum number from the input array |
| **min**            | Function<Iterable<Float>, Float>|                                           | It returns the minimum number from an Iterable input object |
| **minArray**       | Function<Float[], Float>       |                                           | It returns the minimum number from the input array |
| **multiplyBy**     | Function<Float, Float>         | Number multiplicand                       | It multiplies target by multiplicand and returns its value |
| **multiplyBy**     | Function<Float, Float>         | byte multiplicand                         | It multiplies target by multiplicand and returns its value |
| **multiplyBy**     | Function<Float, Float>         | short multiplicand                        | It multiplies target by multiplicand and returns its value |
| **multiplyBy**     | Function<Float, Float>         | int multiplicand                          | It multiplies target by multiplicand and returns its value |
| **multiplyBy**     | Function<Float, Float>         | long multiplicand                         | It multiplies target by multiplicand and returns its value |
| **multiplyBy**     | Function<Float, Float>         | float multiplicand                        | It multiplies target by multiplicand and returns its value |
| **multiplyBy**     | Function<Float, Float>         | double multiplicand                       | It multiplies target by multiplicand and returns its value |
| **multiplyBy**     | Function<Float, Float>         | Number multiplicand, MathContext mathContext | It multiplies target by multiplicand and returns its value. The result precision and RoundingMode is specified by the given MathContext |
| **multiplyBy**     | Function<Float, Float>         | byte multiplicand, MathContext mathContext | It multiplies target by multiplicand and returns its value. The result precision and RoundingMode is specified by the given MathContext |
| **multiplyBy**     | Function<Float, Float>         | short multiplicand, MathContext mathContext| It multiplies target by multiplicand and returns its value. The result precision and RoundingMode is specified by the given MathContext |
| **multiplyBy**     | Function<Float, Float>         | int multiplicand, MathContext mathContext  | It multiplies target by multiplicand and returns its value. The result precision and RoundingMode is specified by the given MathContext |
| **multiplyBy**     | Function<Float, Float>         | long multiplicand, MathContext mathContext | It multiplies target by multiplicand and returns its value. The result precision and RoundingMode is specified by the given MathContext |
| **multiplyBy**     | Function<Float, Float>         | float multiplicand, MathContext mathContext| It multiplies target by multiplicand and returns its value. The result precision and RoundingMode is specified by the given MathContext |
| **multiplyBy**     | Function<Float, Float>         | double multiplicand, MathContext mathContext| It multiplies target by multiplicand and returns its value. The result precision and RoundingMode is specified by the given MathContext |
| **multiplyBy**     | Function<Float, Float>         | Number multiplicand, RoundingMode roundingMode | It multiplies target by multiplicand and returns its value. The result is rounded based on the given RoundingMode |
| **multiplyBy**     | Function<Float, Float>         | byte multiplicand, RoundingMode roundingMode | It multiplies target by multiplicand and returns its value. The result is rounded based on the given RoundingMode |
| **multiplyBy**     | Function<Float, Float>         | short multiplicand, RoundingMode roundingMode| It multiplies target by multiplicand and returns its value. The result is rounded based on the given RoundingMode |
| **multiplyBy**     | Function<Float, Float>         | int multiplicand, RoundingMode roundingMode  | It multiplies target by multiplicand and returns its value. The result is rounded based on the given RoundingMode |
| **multiplyBy**     | Function<Float, Float>         | long multiplicand, RoundingMode roundingMode | It multiplies target by multiplicand and returns its value. The result is rounded based on the given RoundingMode |
| **multiplyBy**     | Function<Float, Float>         | float multiplicand, RoundingMode roundingMode| It multiplies target by multiplicand and returns its value. The result is rounded based on the given RoundingMode |
| **multiplyBy**     | Function<Float, Float>         | double multiplicand, RoundingMode roundingMode| It multiplies target by multiplicand and returns its value. The result is rounded based on the given RoundingMode |
| **notEq**          | Function<Float,Boolean>        | Float object                              | Determines whether the target object and the specified object are NOT equal by calling the `equals` method on the target object. |
| **notEq**          | Function<Float,Boolean>        | float object                              | Determines whether the target object and the specified object are NOT equal by calling the `equals` method on the target object. |
| **notEqBy**        | Function<Float,Boolean>        | IFunction<Float,?> by, Object object      | Determines whether the result of executing the specified function on the target object and the specified object parameter are NOT equal by calling the `equals` method. |
| **notEqValue**     | Function<Float,Boolean>        | Number object                             | Determines whether the target object and the specified object are NOT equal in value, i.e., `target.compareTo(object) != 0`. Both must implement Comparable. |
| **notEqValue**     | Function<Float,Boolean>        | float object                              | Determines whether the target object and the specified object are NOT equal in value, i.e., `target.compareTo(object) != 0`. Both must implement Comparable. |
| **notEqValueBy**   | Function<Float,Boolean>        | IFunction<Float,?> by, Object object      | Determines whether the result of executing the specified function on the target object and the specified object parameter are NOT equal in value, i.e., `functionResult.compareTo(object) != 0`. Both must implement Comparable. |
| **pow**            | Function<Float, Float>         | int power                                 | It performs the operation target^power and returns its value |
| **pow**            | Function<Float, Float>         | int power, MathContext mathContext        | It performs the operation target^power and returns its value. The result precision and rounding mode is specified by the given MathContext |
| **pow**            | Function<Float, Float>         | int power, RoundingMode roundingMode      | It performs the operation target^power and returns its value. The result rounding mode is specified by the given RoundingMode |
| **remainder**      | Function<Float, Float>         | Number divisor                            | It divides the target element by the given divisor and returns the remainder (target % divisor) |
| **remainder**      | Function<Float, Float>         | byte divisor                              | It divides the target element by the given divisor and returns the remainder (target % divisor) |
| **remainder**      | Function<Float, Float>         | short divisor                             | It divides the target element by the given divisor and returns the remainder (target % divisor) |
| **remainder**      | Function<Float, Float>         | int divisor                               | It divides the target element by the given divisor and returns the remainder (target % divisor) |
| **remainder**      | Function<Float, Float>         | long divisor                              | It divides the target element by the given divisor and returns the remainder (target % divisor) |
| **remainder**      | Function<Float, Float>         | float divisor                             | It divides the target element by the given divisor and returns the remainder (target % divisor) |
| **remainder**      | Function<Float, Float>         | double divisor                            | It divides the target element by the given divisor and returns the remainder (target % divisor) |
| **subtract**       | Function<Float, Float>         | Number subtract                           | It subtracts the given number from the target and returns the result |
| **subtract**       | Function<Float, Float>         | byte subtract                             | It subtracts the given number from the target and returns the result |
| **subtract**       | Function<Float, Float>         | short subtract                            | It subtracts the given number from the target and returns the result |
| **subtract**       | Function<Float, Float>         | int subtract                              | It subtracts the given number from the target and returns the result |
| **subtract**       | Function<Float, Float>         | long subtract                             | It subtracts the given number from the target and returns the result |
| **subtract**       | Function<Float, Float>         | float subtract                            | It subtracts the given number from the target and returns the result |
| **subtract**       | Function<Float, Float>         | double subtract                           | It subtracts the given number from the target and returns the result |
| **sum**            | Function<Iterable<Float>, Float>|                                           | It returns the sum of all the numbers in the Iterable input object |
| **sumArray**       | Function<Float[], Float>       |                                           | It returns the sum of all the numbers in the input array |
| **toCurrencyStr**  | Function<Float,String>         |                                           | It returns the String representation of the target as a currency in the default Locale |
| **toCurrencyStr**  | Function<Float,String>         | boolean groupingUsed                      | It returns the String representation of the target as a currency in the default Locale |
| **toCurrencyStr**  | Function<Float,String>         | Locale locale                             | It returns the String representation of the target as a currency in the given Locale |
| **toCurrencyStr**  | Function<Float,String>         | String locale                             | It returns the String representation of the target as a currency in the given locale |
| **toCurrencyStr**  | Function<Float,String>         | Locale locale, boolean groupingUsed       | It returns the String representation of the target as a currency in the given Locale |
| **toCurrencyStr**  | Function<Float,String>         | String locale, boolean groupingUsed       | It returns the String representation of the target as a currency in the given locale |
| **toPercentStr**   | Function<Float,String>         |                                           | A String representing a percentage is created from the target number. |
| **toPercentStr**   | Function<Float,String>         | boolean groupingUsed                      | A String representing a percentage is created from the target number either using grouping or not depending on the given parameter. |
| **toPercentStr**   | Function<Float,String>         | Locale locale                             | A String representing a percentage is created from the target number in the given Locale |
| **toPercentStr**   | Function<Float,String>         | String locale                             | A String representing a percentage is created from the target number in the given locale |
| **toPercentStr**   | Function<Float,String>         | Locale locale, boolean groupingUsed       | A String representing a percentage is created from the target number in the given Locale. Grouping will be used depending on the value of the groupingUsed parameter. |
| **toPercentStr**   | Function<Float,String>         | String locale, boolean groupingUsed       | A String representing a percentage is created from the target number in the given locale. Grouping will be used depending on the value of the groupingUsed parameter. |
| **toStr**          | Function<Float,String>         |                                           | It returns the String representation of the input number |
| **toStr**          | Function<Float,String>         | boolean groupingUsed                      | It returns the String representation of the input number either using or not using grouping |
| **toStr**          | Function<Float,String>         | Locale locale                             | It returns the String representation of the target number in the given Locale |
| **toStr**          | Function<Float,String>         | String locale                             | It returns the String representation of the target number in the given locale |
| **toStr**          | Function<Float,String>         | Locale locale, boolean groupingUsed       | It returns the String representation of the target number in the given Locale. Grouping will be used depending on the value of the groupingUsed parameter |
| **toStr**          | Function<Float,String>         | String locale, boolean groupingUsed       | It returns the String representation of the target number in the given locale. Grouping will be used depending on the value of the groupingUsed parameter |
