# Functions: FnList

## 1. Overview

`FnList` is a *parameterizable function hub class*. Before accessing the real functions, you must specify the type parameter, which gives you access to operations on `List`s:

- `FnList.ofBigDecimal()` → FnListOf<BigDecimal>
- `FnList.ofBigInteger()` → FnListOf<BigInteger>
- `FnList.ofBoolean()` → FnListOf<Boolean>
- `FnList.ofByte()` → FnListOf<Byte>
- `FnList.ofCalendar()` → FnListOf<Calendar>
- `FnList.ofCharacter()` → FnListOf<Character>
- `FnList.ofDate()` → FnListOf<Date>
- `FnList.ofDouble()` → FnListOf<Double>
- `FnList.ofFloat()` → FnListOf<Float>
- `FnList.ofInteger()` → FnListOf<Integer>
- `FnList.ofLong()` → FnListOf<Long>
- `FnList.ofObject()` → FnListOf<Object>
- `FnList.ofShort()` → FnListOf<Short>
- `FnList.ofString()` → FnListOf<String>
- `FnList.of(final Type<T> type)` → FnListOf<T> (generic)
- `FnList.ofArrayOf(final Type<T> type)` → FnListOfArrayOf<T>
- `FnList.ofListOf(final Type<T> type)` → FnListOfListOf<T>
- `FnList.ofSetOf(final Type<T> type)` → FnListOfSetOf<T>

## FnListOf

Functions in **FnListOf** are applied on *Lists*. FnListOf is parameterizable, so you must specify the type parameter (e.g., `FnList.ofBigDecimal()`, `FnList.ofLong()`, `FnList.of(final Type<T> type)`, ...).

Shortcuts for common classes: `FnList.ofBigDecimal()`, `FnList.ofInteger()`, `FnList.ofDate()`, `FnList.ofCharacter()`, ...

### Example Usage
```java
// Converts Strings to Calendar and sorts them
Op.onListFor("2000/11/10", "2010/10/10", "2000/01/10")
    .forEach().exec(FnString.toCalendar("yyyy/MM/dd")).endFor()
    .exec(FnList.ofCalendar().sort()).get();

// Creates the map {first = [23], second = [2.3], third = [-23.456]}
Op.onListFor(BigDecimal.valueOf(23), BigDecimal.valueOf(2.3), BigDecimal.valueOf(-23.456))
    .exec(FnList.ofBigDecimal().zipAndGroupKeys("first", "second", "third")).get();

// Creates the map {ff0000 = red, 00ff00 = green, 0000ff = blue}
Op.onListFor("ff0000", "red", "00ff00", "green", "0000ff", "blue")
    .exec(FnList.ofString().couple()).get();
```

### Functions Table
| Function name           | Type                                      | Params                                   | Description |
|-------------------------|-------------------------------------------|-------------------------------------------|-------------|
| **add**                 | Function<List<T>,List<T>>                  | T... newElements                         |             |
| **addAll**              | Function<List<T>,List<T>>                  | Collection<T> collection                 |             |
| **all**                 | Function<List<T>,Boolean>                  | IFunction<? super T,Boolean> eval        |             |
| **any**                 | Function<List<T>,Boolean>                  | IFunction<? super T,Boolean> eval        |             |
| **contains**            | Function<List<T>,Boolean>                  | T object                                 |             |
| **containsAll**         | Function<List<T>,Boolean>                  | T... objects                             |             |
| **containsAny**         | Function<List<T>,Boolean>                  | T... objects                             |             |
| **containsNone**        | Function<List<T>,Boolean>                  | T... objects                             |             |
| **count**               | Function<List<T>,Integer>                  |                                           |             |
| **couple**              | Function<List<T>,Map<T,T>>                 |                                           |             |
| **coupleAndGroup**      | Function<List<T>,Map<T,List<T>>>           |                                           |             |
| **distinct**            | Function<List<T>,List<T>>                  |                                           |             |
| **insert**              | Function<List<T>,List<T>>                  | int position, T... newElements           |             |
| **notContains**         | Function<List<T>,Boolean>                  | T object                                 |             |
| **removeAllEqual**      | Function<List<T>,List<T>>                  | T... values                              |             |
| **removeAllFalse**      | Function<List<T>,List<T>>                  | IFunction<? super T,Boolean> eval        |             |
| **removeAllIndexes**    | Function<List<T>,List<T>>                  | int... indexes                           |             |
| **removeAllIndexesNot** | Function<List<T>,List<T>>                  | int... indexes                           |             |
| **removeAllNotNullAndFalse** | Function<List<T>,List<T>>              | IFunction<? super T,Boolean> eval        |             |
| **removeAllNotNullAndTrue**  | Function<List<T>,List<T>>              | IFunction<? super T,Boolean> eval        |             |
| **removeAllNull**       | Function<List<T>,List<T>>                  |                                           |             |
| **removeAllNullOrFalse**| Function<List<T>,List<T>>                  | IFunction<? super T,Boolean> eval        |             |
| **removeAllNullOrTrue** | Function<List<T>,List<T>>                  | IFunction<? super T,Boolean> eval        |             |
| **removeAllTrue**       | Function<List<T>,List<T>>                  | IFunction<? super T,Boolean> eval        |             |
| **reverse**             | Function<List<T>,List<T>>                  |                                           |             |
| **sort**                | Function<List<T>,List<T>>                  |                                           |             |
| **sort**                | Function<List<T>,List<T>>                  | Comparator<? super T> comparator         |             |
| **sortBy**              | Function<List<T>,List<T>>                  | IFunction<? super T, ?> by               |             |
| **toArray**             | Function<List<T>,T[]>                      |                                           |             |
| **toGroupMap**          | Function<List<T>,Map<K,List<V>>>           | IFunction<? super T,Map.Entry<K,V>> mapBuilder |        |
| **toGroupMap**          | Function<List<T>,Map<K,List<V>>>           | IFunction<? super T,K> keyFunction, IFunction<? super T,V> valueFunction | |
| **toMap**               | Function<List<T>,Map<K,V>>                 | IFunction<? super T,Map.Entry<K,V>> mapBuilder |        |
| **toMap**               | Function<List<T>,Map<K,V>>                 | IFunction<? super T,K> keyFunction, IFunction<? super T,V> valueFunction | |
| **toSet**               | Function<List<T>,Set<T>>                   |                                           |             |
| **zipAndGroupKeys**     | Function<List<T>,Map<K,List<T>>>           | K... keys                                |             |
| **zipAndGroupKeysBy**   | Function<List<T>,Map<K,List<T>>>           | IFunction<? super T, K> eval             |             |
| **zipAndGroupKeysFrom** | Function<List<T>,Map<K,List<T>>>           | Collection<K> keys                       |             |
| **zipAndGroupKeysFrom** | Function<List<T>,Map<K,List<T>>>           | K[] keys                                 |             |
| **zipAndGroupValues**   | Function<List<T>,Map<T,List<V>>>           | V... values                              |             |
| **zipAndGroupValuesBy** | Function<List<T>,Map<T,List<V>>>           | IFunction<? super T, V> eval             |             |
| **zipAndGroupValuesFrom** | Function<List<T>,Map<T,List<V>>>          | Collection<V> values                     |             |
| **zipAndGroupValuesFrom** | Function<List<T>,Map<T,List<V>>>          | V[] values                               |             |
| **zipKeys**             | Function<List<T>,Map<K,T>>                 | K... keys                                |             |
| **zipKeysBy**           | Function<List<T>,Map<K,T>>                 | IFunction<? super T, K> eval             |             |
| **zipKeysFrom**         | Function<List<T>,Map<K,T>>                 | Collection<K> keys                       |             |
| **zipKeysFrom**         | Function<List<T>,Map<K,T>>                 | K[] keys                                 |             |
| **zipValues**           | Function<List<T>,Map<T,V>>                 | V... values                              |             |
| **zipValuesBy**         | Function<List<T>,Map<T,V>>                 | IFunction<? super T, V> eval             |             |
| **zipValuesFrom**       | Function<List<T>,Map<T,V>>                 | Collection<V> values                     |             |
| **zipValuesFrom**       | Function<List<T>,Map<T,V>>                 | V[] values                               |             |

## FnListOfArrayOf

Functions in **FnListOfArrayOf** are applied on *Lists of Arrays* of any type. FnListOfArrayOf is parameterizable, so you must specify the type parameter (e.g., `FnList.ofArrayOf(Types.INTEGER)`).

### Example Usage
```java
// Flattens a List of Array to ["first", "second", "third"]
Op.on(new String[][] {Op.onArrayFor("first", "second").get(), Op.onArrayFor("third").get()})
    .toList().exec(FnList.ofArrayOf(Types.STRING).flattenArrays()).get();
```

### Functions Table
| Function name      | Type                                 | Params | Description |
|--------------------|--------------------------------------|--------|-------------|
| **flattenArrays**  | Function<List<T[]>,List<T>>          |        |             |

## FnListOfListOf

Functions in **FnListOfListOf** are applied on *Lists of Lists* of any type. FnListOfListOf is parameterizable, so you must specify the type parameter (e.g., `FnList.ofListOf(Types.INTEGER)`).

### Example Usage
```java
// Flattens a List<List<String>> to ["first", "second", "third"]
Op.onListFor(Op.onListFor("first", "second").get(), Op.onListFor("third").get())
    .exec(FnList.ofListOf(Types.STRING).flattenLists()).get();
```

### Functions Table
| Function name      | Type                                 | Params | Description |
|--------------------|--------------------------------------|--------|-------------|
| **flattenLists**   | Function<List<List<T>>,List<T>>      |        |             |

## FnListOfSetOf

Functions in **FnListOfSetOf** are applied on *Lists of Sets* of any type. FnListOfSetOf is parameterizable, so you must specify the type parameter (e.g., `FnList.ofSetOf(Types.INTEGER)`).

### Example Usage
```java
// Flattens a List<Set<String>> to ["first", "second", "third"]
Op.onListFor(Op.onSetFor("first", "second").get(), Op.onSetFor("third").get())
    .exec(FnList.ofSetOf(Types.STRING).flattenSets()).get();
```

### Functions Table
| Function name      | Type                                 | Params | Description |
|--------------------|--------------------------------------|--------|-------------|
| **flattenSets**    | Function<List<Set<T>>,List<T>>       |        |             |
