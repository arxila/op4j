# Functions: FnObject

## 1. Overview

**[FnObject](http://www.op4j.org/apidocs/org/op4j/functions/FnObject.html)** is a *function hub class* containing a lot of static methods to work with Objects in general.

## 2. Functions

| Function name         | Type                        | Params                                                                 | Description |
|-----------------------|-----------------------------|------------------------------------------------------------------------|-------------|
| between               | Function<Object,Boolean>    | Object min, Object max<br>float min, float max<br>int min, int max<br>byte min, byte max<br>double min, double max<br>long min, long max<br>short min, short max | Determines whether the target object is between min and max in value (`target.compareTo(min) >= 0 && target.compareTo(max) <= 0`). Target and min/max must implement Comparable. |
| eq                    | Function<Object,Boolean>    | Object/primitive object (float, double, byte, short, int, long, boolean) | Determines whether the target object and the specified object are equal by calling `equals` on the target. |
| eqBy                  | Function<X,Boolean>         | IFunction<X,?> by, Object/primitive object | Determines whether the result of executing the specified function on the target and the object parameter are equal by calling `equals`. |
| eqValue               | Function<Object,Boolean>    | Object/primitive object (float, double, byte, short, int, long, boolean) | Determines whether the target and specified object are equal in value (`target.compareTo(object) == 0`). Both must implement Comparable. |
| eqValueBy             | Function<X,Boolean>         | IFunction<X,?> by, Object/primitive object | Determines whether the result of executing the specified function on the target and the object parameter are equal in value (`functionResult.compareTo(object) == 0`). Both must implement Comparable. |
| greaterOrEqTo         | Function<Object,Boolean>    | Object/primitive object (float, double, byte, short, int, long) | Determines whether the target is greater or equal to the specified object (`target.compareTo(object) >= 0`). Both must implement Comparable. |
| greaterOrEqToBy       | Function<X,Boolean>         | IFunction<X,?> by, Object/primitive object | Determines whether the result of executing the specified function on the target is greater or equal to the object parameter (`functionResult.compareTo(object) >= 0`). Both must implement Comparable. |
| greaterThan           | Function<Object,Boolean>    | Object/primitive object (float, double, byte, short, int, long) | Determines whether the target is greater than the specified object (`target.compareTo(object) > 0`). Both must implement Comparable. |
| greaterThanBy         | Function<X,Boolean>         | IFunction<X,?> by, Object/primitive object | Determines whether the result of executing the specified function on the target is greater than the object parameter (`functionResult.compareTo(object) > 0`). Both must implement Comparable. |
| intoSingletonArrayOf  | Function<T,T[]>             | Type<T> type | Creates an array of the specified type with only the target object in it. |
| intoSingletonListOf   | Function<T,List<T>>         | Type<T> type | Creates a list of the specified type with only the target object in it. |
| intoSingletonSetOf    | Function<T,Set<T>>          | Type<T> type | Creates a set of the specified type with only the target object in it. |
| isNotNull             | Function<Object,Boolean>    | — | Determines whether the target object is not null. |
| isNotNullBy           | Function<X,Boolean>         | IFunction<X,?> by | Determines whether the result of executing the specified function on the target object is not null. |
| isNull                | Function<Object,Boolean>    | — | Determines whether the target object is null. |
| isNullBy              | Function<X,Boolean>         | IFunction<X,?> by | Determines whether the result of executing the specified function on the target object is null. |
| lessOrEqTo            | Function<Object,Boolean>    | Object/primitive object (float, double, byte, short, int, long) | Determines whether the target is less or equal to the specified object (`target.compareTo(object) <= 0`). Both must implement Comparable. |
| lessOrEqToBy          | Function<X,Boolean>         | IFunction<X,?> by, Object/primitive object | Determines whether the result of executing the specified function on the target is less or equal to the object parameter (`functionResult.compareTo(object) <= 0`). Both must implement Comparable. |
| lessThan              | Function<Object,Boolean>    | Object/primitive object (float, double, byte, short, int, long) | Determines whether the target is less than the specified object (`target.compareTo(object) < 0`). Both must implement Comparable. |
| lessThanBy            | Function<X,Boolean>         | IFunction<X,?> by, Object/primitive object | Determines whether the result of executing the specified function on the target is less than the object parameter (`functionResult.compareTo(object) < 0`). Both must implement Comparable. |
| notEq                 | Function<Object,Boolean>    | Object/primitive object (float, double, byte, short, int, long, boolean) | Determines whether the target and specified object are NOT equal by calling `equals` on the target. |
| notEqBy               | Function<X,Boolean>         | IFunction<X,?> by, Object/primitive object | Determines whether the result of executing the specified function on the target and the object parameter are NOT equal by calling `equals`. |
| notEqValue            | Function<Object,Boolean>    | Object/primitive object (float, double, byte, short, int, long, boolean) | Determines whether the target and specified object are NOT equal in value (`target.compareTo(object) != 0`). Both must implement Comparable. |
| notEqValueBy          | Function<X,Boolean>         | IFunction<X,?> by, Object/primitive object | Determines whether the result of executing the specified function on the target and the object parameter are NOT equal in value (`functionResult.compareTo(object) != 0`). Both must implement Comparable. |
| replaceWith           | Function<Object,T>          | T object | Replaces the target object with the object specified as a parameter. |
| toStr                 | Function<Object,String>     | — | Converts the target object to String using the default `toString()` method. |
| toStrNullSafe         | Function<Object,String>     | — | Converts the target object to String using the default `toString()` method, returning null if target is null. |

---

*For detailed parameter options and formatting, see the [FnObject JavaDoc](http://www.op4j.org/apidocs/org/op4j/functions/FnObject.html).*
