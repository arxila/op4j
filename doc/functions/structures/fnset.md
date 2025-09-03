# Functions: FnSet

## 1. Overview

[**FnSet**](http://www.op4j.org/apidocs/org/op4j/functions/FnSet.html) is a *parameterizable function hub class*. Before accessing the actual functions, you must specify the type parameter, which gives you access to operations on Sets:

- `FnSet.ofBigDecimal()` → FnSetOf<BigDecimal>
- `FnSet.ofBigInteger()` → FnSetOf<BigInteger>
- `FnSet.ofBoolean()` → FnSetOf<Boolean>
- `FnSet.ofByte()` → FnSetOf<Byte>
- `FnSet.ofCalendar()` → FnSetOf<Calendar>
- `FnSet.ofCharacter()` → FnSetOf<Character>
- `FnSet.ofDate()` → FnSetOf<Date>
- `FnSet.ofDouble()` → FnSetOf<Double>
- `FnSet.ofFloat()` → FnSetOf<Float>
- `FnSet.ofInteger()` → FnSetOf<Integer>
- `FnSet.ofLong()` → FnSetOf<Long>
- `FnSet.ofObject()` → FnSetOf<Object>
- `FnSet.ofShort()` → FnSetOf<Short>
- `FnSet.ofString()` → FnSetOf<String>
- `FnSet.of(final Type<T> type)` → FnSetOf<T> (generic)
- `FnSet.ofArrayOf(final Type<T> type)` → FnSetOfArrayOf<T>
- `FnSet.ofListOf(final Type<T> type)` → FnSetOfListOf<T>
- `FnSet.ofSetOf(final Type<T> type)` → FnSetOfSetOf<T>

## FnSetOf

Functions in **FnSetOf** are applied on Sets. FnSetOf is parameterizable, so you must specify the type parameter (e.g., `FnSet.ofBigDecimal()`, `FnSet.ofLong()`, `FnSet.of(final Type<T> type)`).

Shortcuts exist for common classes: `FnSet.ofBigDecimal()`, `FnSet.ofInteger()`, `FnSet.ofDate()`, `FnSet.ofCharacter()`, etc.

### Example Usage
```java
// Convert Strings to Calendar and sort
Op.onSetFor("2000/11/10", "2010/10/10", "2000/01/10")
    .forEach().exec(FnString.toCalendar("yyyy/MM/dd")).endFor()
    .exec(FnSet.ofCalendar().sort()).get();

// Create map {first = [23], second = [2.3], third = [-23.456]}
Op.onSetFor(BigDecimal.valueOf(23), BigDecimal.valueOf(2.3), BigDecimal.valueOf(-23.456))
    .exec(FnSet.ofBigDecimal().zipAndGroupKeys("first", "second", "third")).get();

// Create map {ff0000 = red, 00ff00 = green, 0000ff = blue}
Op.onSetFor("ff0000", "red", "00ff00", "green", "0000ff", "blue")
    .exec(FnSet.ofString().couple()).get();
```

### Functions Table
| Function name           | Type                                   | Params                                   | Description |
|------------------------|----------------------------------------|------------------------------------------|-------------|
| add                    | Function<Set<T>,Set<T>>                | T... newElements                         |             |
| addAll                 | Function<Set<T>,Set<T>>                | Collection<T> collection                 |             |
| all                    | Function<Set<T>,Boolean>               | IFunction<? super T,Boolean> eval        |             |
| any                    | Function<Set<T>,Boolean>               | IFunction<? super T,Boolean> eval        |             |
| contains               | Function<Set<T>,Boolean>               | T object                                 |             |
| containsAll            | Function<Set<T>,Boolean>               | T... objects                             |             |
| containsAny            | Function<Set<T>,Boolean>               | T... objects                             |             |
| containsNone           | Function<Set<T>,Boolean>               | T... objects                             |             |
| count                  | Function<Set<T>,Integer>                | —                                        |             |
| couple                 | Function<Set<T>,Map<T,T>>              | —                                        |             |
| coupleAndGroup         | Function<Set<T>,Map<T,Set<T>>>         | —                                        |             |
| insert                 | Function<Set<T>,Set<T>>                | int position, T... newElements           |             |
| notContains            | Function<Set<T>,Boolean>               | T object                                 |             |
| removeAllEqual         | Function<Set<T>,Set<T>>                | T... values                              |             |
| removeAllFalse         | Function<Set<T>,Set<T>>                | IFunction<? super T,Boolean> eval        |             |
| removeAllIndexes       | Function<Set<T>,Set<T>>                | int... indexes                           |             |
| removeAllIndexesNot    | Function<Set<T>,Set<T>>                | int... indexes                           |             |
| removeAllNotNullAndFalse| Function<Set<T>,Set<T>>               | IFunction<? super T,Boolean> eval        |             |
| removeAllNotNullAndTrue| Function<Set<T>,Set<T>>                | IFunction<? super T,Boolean> eval        |             |
| removeAllNull          | Function<Set<T>,Set<T>>                | —                                        |             |
| removeAllNullOrFalse   | Function<Set<T>,Set<T>>                | IFunction<? super T,Boolean> eval        |             |
| removeAllNullOrTrue    | Function<Set<T>,Set<T>>                | IFunction<? super T,Boolean> eval        |             |
| removeAllTrue          | Function<Set<T>,Set<T>>                | IFunction<? super T,Boolean> eval        |             |
| reverse                | Function<Set<T>,Set<T>>                | —                                        |             |
| sort                   | Function<Set<T>,Set<T>>                | —<br>Comparator<? super T> comparator     |             |
| sortBy                 | Function<Set<T>,Set<T>>                | IFunction<? super T, ?> by               |             |
| toArray                | Function<Set<T>,T[]>                    | —                                        |             |
| toGroupMap             | Function<Set<T>,Map<K,Set<V>>>         | IFunction<? super T,Map.Entry<K,V>> mapBuilder<br>IFunction<? super T,K> keyFunction, IFunction<? super T,V> valueFunction |             |
| toList                 | Function<Set<T>,List<T>>                | —                                        |             |
| toMap                  | Function<Set<T>,Map<K,V>>              | IFunction<? super T,Map.Entry<K,V>> mapBuilder<br>IFunction<? super T,K> keyFunction, IFunction<? super T,V> valueFunction |             |
| zipAndGroupKeys        | Function<Set<T>,Map<K,Set<T>>>         | K... keys                                |             |
| zipAndGroupKeysBy      | Function<Set<T>,Map<K,Set<T>>>         | IFunction<? super T, K> eval             |             |
| zipAndGroupKeysFrom    | Function<Set<T>,Map<K,Set<T>>>         | Collection<K> keys<br>K[] keys           |             |
| zipAndGroupValues      | Function<Set<T>,Map<T,Set<V>>>         | V... values                              |             |
| zipAndGroupValuesBy    | Function<Set<T>,Map<T,Set<V>>>         | IFunction<? super T, V> eval             |             |
| zipAndGroupValuesFrom  | Function<Set<T>,Map<T,Set<V>>>         | Collection<V> values<br>V[] values       |             |
| zipKeys                | Function<Set<T>,Map<K,T>>              | K... keys                                |             |
| zipKeysBy              | Function<Set<T>,Map<K,T>>              | IFunction<? super T, K> eval             |             |
| zipKeysFrom            | Function<Set<T>,Map<K,T>>              | Collection<K> keys<br>K[] keys           |             |
| zipValues              | Function<Set<T>,Map<T,V>>              | V... values                              |             |
| zipValuesBy            | Function<Set<T>,Map<T,V>>              | IFunction<? super T, V> eval             |             |
| zipValuesFrom          | Function<Set<T>,Map<T,V>>              | Collection<V> values<br>V[] values       |             |

## FnSetOfArrayOf

Functions in **FnSetOfArrayOf** are applied on Sets of Arrays of any type. Specify the type parameter (e.g., `FnSet.ofArrayOf(Types.INTEGER)`).

### Example Usage
```java
// Flatten a Set of Arrays to a single set
Op.onSetFor(Op.onArrayFor("first", "second").get(), Op.onArrayFor("third").get())
    .exec(FnSet.ofArrayOf(Types.STRING).flattenArrays()).get();
```

| Function name   | Type                              | Params | Description |
|----------------|-----------------------------------|--------|-------------|
| flattenArrays  | Function<Set<T[]>,Set<T>>         | —      |             |

## FnSetOfListOf

Functions in **FnSetOfListOf** are applied on Sets of Lists of any type. Specify the type parameter (e.g., `FnSet.ofListOf(Types.INTEGER)`).

### Example Usage
```java
// Flatten a Set of Lists to a single set
Op.onSetFor(Op.onListFor("first", "second").get(), Op.onListFor("third").get())
    .exec(FnSet.ofListOf(Types.STRING).flattenLists()).get();
```

| Function name   | Type                              | Params | Description |
|----------------|-----------------------------------|--------|-------------|
| flattenLists   | Function<Set<List<T>>,Set<T>>     | —      |             |

## FnSetOfSetOf

Functions in **FnSetOfSetOf** are applied on Sets of Sets of any type. Specify the type parameter (e.g., `FnSet.ofSetOf(Types.INTEGER)`).

### Example Usage
```java
// Flatten a Set of Sets to a single set
Op.onSetFor(Op.onSetFor("first", "second").get(), Op.onSetFor("third").get())
    .exec(FnSet.ofSetOf(Types.STRING).flattenSets()).get();
```

| Function name   | Type                              | Params | Description |
|----------------|-----------------------------------|--------|-------------|
| flattenSets    | Function<Set<Set<T>>,Set<T>>      | —      |             |

---

*For detailed parameter options and formatting, see the [FnSet JavaDoc](http://www.op4j.org/apidocs/org/op4j/functions/FnSet.html).*
