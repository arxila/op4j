# Functions: FnArray

## 1. Overview

`FnArray` is a *parameterizable function hub class*. Before accessing the actual functions, you must specify the type parameter, which gives you access to operations on **Arrays**:

- `FnArray.ofBigDecimal()`: returns [FnArrayOf<BigDecimal>](#fnarrayof)
- `FnArray.ofBigInteger()`: returns [FnArrayOf<BigInteger>](#fnarrayof)
- `FnArray.ofBoolean()`: returns [FnArrayOf<Boolean>](#fnarrayof)
- `FnArray.ofByte()`: returns [FnArrayOf<Byte>](#fnarrayof)
- `FnArray.ofCalendar()`: returns [FnArrayOf<Calendar>](#fnarrayof)
- `FnArray.ofCharacter()`: returns [FnArrayOf<Character>](#fnarrayof)
- `FnArray.ofDate()`: returns [FnArrayOf<Date>](#fnarrayof)
- `FnArray.ofDouble()`: returns [FnArrayOf<Double>](#fnarrayof)
- `FnArray.ofFloat()`: returns [FnArrayOf<Float>](#fnarrayof)
- `FnArray.ofInteger()`: returns [FnArrayOf<Integer>](#fnarrayof)
- `FnArray.ofLong()`: returns [FnArrayOf<Long>](#fnarrayof)
- `FnArray.ofObject()`: returns [FnArrayOf<Object>](#fnarrayof)
- `FnArray.ofShort()`: returns [FnArrayOf<Short>](#fnarrayof)
- `FnArray.ofString()`: returns [FnArrayOf<String>](#fnarrayof)
- `FnArray.of(final Type<T> type)`: returns [FnArrayOf<T>](#fnarrayof) parameterized with the given type (most generic)
- `FnArray.ofArrayOf(final Type<T> type)`: returns [FnArrayOfArrayOf<T>](#fnarrayofarrayof) parameterized with the given type
- `FnArray.ofListOf(final Type<T> type)`: returns [FnArrayOfListOf<T>](#fnarrayoflistof) parameterized with the given type
- `FnArray.ofSetOf(final Type<T> type)`: returns [FnArrayOfSetOf<T>](#fnarrayofsetof) parameterized with the given type

---

## FnArrayOf

Functions in **FnArrayOf** are applied on *Arrays*. FnArrayOf is a parameterizable class, so you must specify the type parameter (e.g., `FnArray.ofBigDecimal()`, `FnArray.ofLong()`, `FnArray.of(final Type<T> type)`, ...).

`FnArray.of(final Type<T> type)` is the most generic method, but there are shortcuts for common classes: `FnArray.ofBigDecimal()`, `FnArray.ofInteger()`, `FnArray.ofDate()`, `FnArray.ofCharacter()`, ...

**Examples:**

```java
// Converts Strings into Calendar and sorts them
Op.on(new String[] {"2000/11/10", "2010/10/10", "2000/01/10"})
    .forEach().exec(Types.CALENDAR, FnString.toCalendar("yyyy/MM/dd")).endFor()
    .exec(FnArray.ofCalendar().sort()).get();

// Creates the map {first = [23], second = [2.3], third = [-23.456]}
Op.on(new BigDecimal[] {BigDecimal.valueOf(23), BigDecimal.valueOf(2.3), BigDecimal.valueOf(-23.456)})
    .exec(FnArray.ofBigDecimal().zipAndGroupKeys("first", "second", "third")).get();

// Creates the map {ff0000 = red, 00ff00 = green, 0000ff = blue}
Op.onArrayFor("ff0000", "red", "00ff00", "green", "0000ff", "blue")
    .exec(FnArray.ofString().couple()).get();
```

### FnArrayOf Functions

| Function name              | Type                              | Params                                   | Description |
|---------------------------|-----------------------------------|------------------------------------------|-------------|
| **add**                   | Function<T[],T[]>                 | T... newElements                         |             |
| **addAll**                | Function<T[],T[]>                 | Collection<T> collection                 |             |
| **all**                   | Function<T[],Boolean>             | IFunction<? super T,Boolean> eval        |             |
| **any**                   | Function<T[],Boolean>             | IFunction<? super T,Boolean> eval        |             |
| **contains**              | Function<T[],Boolean>             | T object                                 |             |
| **containsAll**           | Function<T[],Boolean>             | T... objects                             |             |
| **containsAny**           | Function<T[],Boolean>             | T... objects                             |             |
| **containsNone**          | Function<T[],Boolean>             | T... objects                             |             |
| **count**                 | Function<T[],Integer>             |                                          |             |
| **couple**                | Function<T[],Map<T,T>>            |                                          |             |
| **coupleAndGroup**        | Function<T[],Map<T,T[]>>          |                                          |             |
| **distinct**              | Function<T[],T[]>                 |                                          |             |
| **insert**                | Function<T[],T[]>                 | int position, T... newElements           |             |
| **notContains**           | Function<T[],Boolean>             | T object                                 |             |
| **removeAllEqual**        | Function<T[],T[]>                 | T... values                              |             |
| **removeAllFalse**        | Function<T[],T[]>                 | IFunction<? super T,Boolean> eval        |             |
| **removeAllIndexes**      | Function<T[],T[]>                 | int... indexes                           |             |
| **removeAllIndexesNot**   | Function<T[],T[]>                 | int... indexes                           |             |
| **removeAllNotNullAndFalse** | Function<T[],T[]>              | IFunction<? super T,Boolean> eval        |             |
| **removeAllNotNullAndTrue**  | Function<T[],T[]>               | IFunction<? super T,Boolean> eval        |             |
| **removeAllNull**         | Function<T[],T[]>                 |                                          |             |
| **removeAllNullOrFalse**  | Function<T[],T[]>                 | IFunction<? super T,Boolean> eval        |             |
| **removeAllNullOrTrue**   | Function<T[],T[]>                 | IFunction<? super T,Boolean> eval        |             |
| **removeAllTrue**         | Function<T[],T[]>                 | IFunction<? super T,Boolean> eval        |             |
| **reverse**               | Function<T[],T[]>                 |                                          |             |
| **sort**                  | Function<T[],T[]>                 |                                          |             |
| **sort**                  | Function<T[],T[]>                 | Comparator<? super T> comparator         |             |
| **sortBy**                | Function<T[],T[]>                 | IFunction<? super T, ?> by               |             |
| **toGroupMapOf**          | Function<T[],Map<K,V[]>>          | Type<V> valueType, IFunction<? super T,Map.Entry<K,V>> mapBuilder |             |
| **toGroupMapOf**          | Function<T[],Map<K,V[]>>          | Type<V> valueType, IFunction<? super T,K> keyFunction, IFunction<? super T,V> valueFunction |             |
| **toList**                | Function<T[],List<T>>             |                                          |             |
| **toMap**                 | Function<T[],Map<K,V>>            | IFunction<? super T,Map.Entry<K,V>> mapBuilder |             |
| **toMap**                 | Function<T[],Map<K,V>>            | IFunction<? super T,K> keyFunction, IFunction<? super T,V> valueFunction |             |
| **toSet**                 | Function<T[],Set<T>>              |                                          |             |
| **zipAndGroupKeys**       | Function<T[],Map<K,T[]>>          | K... keys                                |             |
| **zipAndGroupKeysBy**     | Function<T[],Map<K,T[]>>          | IFunction<? super T, K> eval             |             |
| **zipAndGroupKeysFrom**   | Function<T[],Map<K,T[]>>          | Collection<K> keys                       |             |
| **zipAndGroupKeysFrom**   | Function<T[],Map<K,T[]>>          | K[] keys                                 |             |
| **zipAndGroupValues**     | Function<T[],Map<T,V[]>>          | Type<V> valueType, V... values           |             |
| **zipAndGroupValuesBy**   | Function<T[],Map<T,V[]>>          | Type<V> valueType, IFunction<? super T, V> eval |             |
| **zipAndGroupValuesFrom** | Function<T[],Map<T,V[]>>          | Type<V> valueType, Collection<V> values  |             |
| **zipAndGroupValuesFrom** | Function<T[],Map<T,V[]>>          | Type<V> valueType, V[] values            |             |
| **zipKeys**               | Function<T[],Map<K,T>>            | K... keys                                |             |
| **zipKeysBy**             | Function<T[],Map<K,T>>            | IFunction<? super T, K> eval             |             |
| **zipKeysFrom**           | Function<T[],Map<K,T>>            | Collection<K> keys                       |             |
| **zipKeysFrom**           | Function<T[],Map<K,T>>            | K[] keys                                 |             |
| **zipValues**             | Function<T[],Map<T,V>>            | V... values                              |             |
| **zipValuesBy**           | Function<T[],Map<T,V>>            | IFunction<? super T, V> eval             |             |
| **zipValuesFrom**         | Function<T[],Map<T,V>>            | Collection<V> values                     |             |
| **zipValuesFrom**         | Function<T[],Map<T,V>>            | V[] values                               |             |

---

## FnArrayOfArrayOf

Functions in **FnArrayOfArrayOf** are applied on *Arrays of Arrays* of any type. FnArrayOfArrayOf is a parameterizable class, so you must specify the type parameter (e.g., `FnArray.ofArrayOf(Types.INTEGER)`, `FnArray.ofArrayOf(Types.LONG)`).

**Example:**

```java
// Flattens the target Array of Array; result: ["first", "second", "third"]
Op.on(new String[][] {Op.onArrayFor("first", "second").get(), Op.onArrayFor("third").get()})
    .castToArrayOf(Types.ARRAY_OF_STRING)
    .exec(FnArray.ofArrayOf(Types.STRING).flattenArrays()).get();
```

### FnArrayOfArrayOf Functions

| Function name    | Type                    | Params | Description |
|------------------|------------------------|--------|-------------|
| **flattenArrays**| Function<T[][],T[]>    |        |             |

---

## FnArrayOfListOf

Functions in **FnArrayOfListOf** are applied on *Arrays of Lists* of any type. FnArrayOfListOf is a parameterizable class, so you must specify the type parameter (e.g., `FnArray.ofListOf(Types.INTEGER)`, `FnArray.ofListOf(Types.LONG)`).

**Example:**

```java
// Flattens the target Array of List; result: ["first", "second", "third"]
Op.on(new List[] {Op.onListFor("first", "second").get(), Op.onListFor("third").get()})
    .castToArrayOf(Types.LIST_OF_STRING)
    .exec(FnArray.ofListOf(Types.STRING).flattenLists()).get();
```

### FnArrayOfListOf Functions

| Function name    | Type                        | Params | Description |
|------------------|----------------------------|--------|-------------|
| **flattenLists** | Function<List<T>[],T[]>     |        |             |

---

## FnArrayOfSetOf

Functions in **FnArrayOfSetOf** are applied on *Arrays of Sets* of any type. FnArrayOfSetOf is a parameterizable class, so you must specify the type parameter (e.g., `FnArray.ofSetOf(Types.INTEGER)`, `FnArray.ofSetOf(Types.LONG)`).

**Example:**

```java
// Flattens the target Array of Set; result: ["first", "second", "third"]
Op.on(new Set[] {Op.onSetFor("first", "second").get(), Op.onSetFor("third").get()})
    .castToArrayOf(Types.SET_OF_STRING)
    .exec(FnArray.ofSetOf(Types.STRING).flattenSets()).get();
```

### FnArrayOfSetOf Functions

| Function name    | Type                        | Params | Description |
|------------------|----------------------------|--------|-------------|
| **flattenSets**  | Function<Set<T>[],T[]>      |        |             |
