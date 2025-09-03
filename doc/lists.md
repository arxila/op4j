# Working with lists

This page explains how op4j can deal with list objects (objects implementing `java.util.List<T>`).

List input objects are considered immutable, so they will not be changed when used in an op4j expression and a new list will always be returned when executing `get()`.

This, however, does not apply to the input list element objects, which could be changed if you executed on them any functions which might change their state instead of substituting them for new elements.

## Contents

- [Creating list expressions](#1-creating-list-expressions)
- [Converting to arrays, sets or maps](#2-converting-to-arrays-sets-or-maps)
- [Iterating](#3-iterating)
- [Modifying](#4-modifying)
- [Executing functions](#5-executing-functions)
- [Mapping functions](#6-mapping-functions)
- [Selecting (conditional code)](#7-selecting-conditional-code)
- [Replacing](#8-replacing)
- [Removing duplicates](#9-removing-duplicates)
- [Sorting](#10-sorting)
- [Boolean conditions: all, any](#11-boolean-conditions-all-any)
- [Reversing](#12-reversing)

---

## 1. Creating list expressions

### Operation expressions

There are two equivalent ways of creating an operation expression on a list. Just use the method you like most:

```java
List<String> list = ...;
Op.on(list)...
```

```java
List<String> list = ...;
Op.onList(list)...
```

#### Creating lists from their elements

List expressions can be created by directly specifying the list elements, like this:

```java
Op.onListFor("hello", "ola", "hola", "hallo", "ciao").forEach()...
```

### Function expressions

Function expressions are created as usual with other structures:

```java
// Create a function which receives a List<String> variable as input
function = Fn.onListOf(Types.STRING)...get();
```

---

## 2. Converting to arrays, sets or maps

### Arrays

For converting a list into an array:

```java
String[] array = Op.on(list).toArrayOf(Types.STRING).get();
```

### Sets

For converting a list into a set:

```java
Set<String> set = Op.on(list).toSet().get();
```

### Maps

#### Using a Map Builder

A Map Builder is a function which returns map entries (`IFunction<T,Map.Entry<K,V>>`), usually created by extending the abstract class `org.op4j.functions.MapBuilder`, and which provides op4j with a way of creating a map entry from each of the list's elements.

`MapBuilder` looks like this:

```java
public abstract class MapBuilder<T,K,V> implements IFunction<T,Map.Entry<K,V>> {
    public abstract K buildKey(final T target);
    public abstract V buildValue(final T target);
    ...
}
```

...and using it is very easy:

```java
MapBuilder<String,Integer,Calendar> mapBuilder = ...;
Map<Integer,Calendar> map = Op.on(list).toMap(mapBuilder).get();
```

##### Grouping using a Map Builder

If one or more values can have the same key, you should create a grouped map, like:

```java
MapBuilder<String,Integer,Calendar> mapBuilder = ...;
Map<Integer,List<Calendar>> map = Op.on(list).toGroupMap(mapBuilder).get();
```

#### Using two functions

Instead of a map builder function, we could just use two functions instead, one for creating keys, and a different one for creating values:

```java
IFunction<String,Integer> keyFunction = ...;
IFunction<String,Calendar> valueFunction = ...;
Map<Integer,Calendar> map = Op.on(list).toMap(keyFunction, valueFunction).get();
```

##### Grouping using two functions

Again, if one or more values can have the same key, you should create a grouped map, like:

```java
IFunction<String,Integer> keyFunction = ...;
IFunction<String,Calendar> valueFunction = ...;
Map<Integer,List<Calendar>> map = Op.on(list).toGroupMap(keyFunction, valueFunction).get();
```

#### Zipping keys or values

A Map can also be created from a list by zipping. Zipping means combining the elements in the list with other objects like this:

```java
// map = {{1="a"}, {2="b"}}
Map<Integer,String> map = 
    Op.onListFor(1,2).zipValues("a","b").get();
```

...using a collection...

```java
Collection<String> values = {"a", "b"};
// map = {{1="a"}, {2="b"}}
Map<Integer,String> map = 
    Op.onListFor(1,2).zipValuesFrom(values).get();
```

Or similarly:

```java
// map = {{"a"=1}, {"b"=2}}
Map<String,Integer> map = 
    Op.onListFor(1,2).zipKeys("a","b").get();
```

...using a collection...

```java
Collection<String> keys = {"a", "b"};
// map = {{"a"=1}, {"b"=2}}
Map<String,Integer> map = 
    Op.onListFor(1,2).zipKeysFrom(keys).get();
```

Alternatively, a function can be used for evaluating existing elements and obtaining keys or values:

```java
IFunction<Integer,String> valueEvaluatorFn = ...;
Map<Integer,String> map = 
    Op.onListFor(1,2).zipValuesBy(valueEvaluatorFn).get();
```

```java
IFunction<Integer,String> keyEvaluatorFn = ...;
Map<String,Integer> map = 
    Op.onListFor(1,2).zipKeysBy(keyEvaluatorFn).get();
```

##### Zipping and Grouping

Collisions (entries with the same key) can be avoided when zipping by using grouping actions:

```java
// mapOfArrays = {{1=["a","c"]}, {2=["b","d","e]}}
Map<Integer,List<String>> mapOfArrays = 
    Op.onListFor(1,2,1,2,2).zipAndGroupValues("a","b","c","d","e").get();
```

```java
IFunction<Integer,String> keyEvaluatorFn = ...;
Map<String,List<Integer>> map = 
    Op.onListFor(1,2,3,4,5,6).zipAndGroupKeysBy(keyEvaluatorFn).get();
```

#### Coupling

The third way to create a Map from a list is by "coupling" or alternating elements, this is, by considering even elements as keys and odd elements as values (starting with 0). This will mean of course that, for a `List<String>`, we will get a `Map<String,String>`.

```java
// map = {{"a"="X"}, {"b"="Y"}}
Map<String,String> map = 
    Op.onListFor("a","X","b","Y").couple().get();
```

##### Coupling and Grouping

Again, collisions can be avoided by grouping...

```java
// map = {{"a"=["X","Y","Z"]}, {"b"=["1","2"]}}
Map<String,List<String>> mapOfArray = 
    Op.onListFor("a","X","b","1","a","Y","a","Z","b","2").coupleAndGroup().get();
```

---

## 3. Iterating

Lists can be iterated according to the following scheme:

```java
Op.on(list).forEach().[ELEMENT ACTIONS].get();
```

After the `forEach()` action, any action added to the expression chain will be applied, not on the list itself, but on each of its elements, and the result obtained when executing `get()` will be a list with the results of applying the subsequently chained actions on each of the list elements.

Iteration can be ended with the `endFor()` action:

```java
Op.on(list).forEach().[ELEMENT ACTIONS].endFor().[LIST ACTIONS].get();
```

The `endFor()` action allows the subsequent execution of actions acting again on the whole list, after having executed some actions on its elements by separate between `forEach()` and `endFor()`. For example:

```java
Set<String> set = Op.on(list).forEach().exec(FnString.toUpperCase()).endFor().toSet().get();
```

---

## 4. Modifying

A list can be modified by adding or removing elements from it.

Several options for adding new elements at the end of a list:

```java
List<String> list = ...;
Collection<String> strCol = ...;
Op.on(list).add("new String")...
Op.on(list).addAll("new String", "another new String")...
Op.on(list).addAll(strCol)...
```

New elements can also be inserted into a specific position. Positions start with 0.

```java
List<String> list = ...;
Op.on(list).insert(2, "new string")...
Op.on(list).insertAll(2, "new String", "another new String")...
```

Removal of elements can be done in several ways. Elements can be removed attending to their position inside the list:

```java
Op.on(list).removeAllIndexes(2,3,5)...
Op.on(list).insertAllIndexesNot(2,3,5)...
```

Also attending to their value:

```java
Op.on(list).removeAllEqual("Coast", "Mountain")...
```

Nulls can be removed easily:

```java
Op.on(list).removeAllNull()...
```

And finally a function returning `Boolean` can be used as evaluator to determine whether an element should be removed or not, in several ways:

```java
List<String> list = ...;
IFunction<String,Boolean> eval = ...;
Op.on(list).removeAllTrue(eval)...
Op.on(list).removeAllFalse(eval)...
Op.on(list).removeAllNullOrTrue(eval)...
Op.on(list).removeAllNullOrFalse(eval)...
Op.on(list).removeAllNotNullAndTrue(eval)...
Op.on(list).removeAllNotNullAndFalse(eval)...
```

---

## 5. Executing functions

### Executing functions on the list elements

Functions can be executed on each of the list elements after a `forEach()` action:

```java
List<String> list = ...;
List<String> newList = Op.on(list).forEach().exec(FnString.toUpperCase()).get();
```

A condition can be added for conditional execution, if needed:

```java
List<String> list = ...;
List<Integer> newList = Op.on(list).forEach().execIfNotNull(FnString.toInteger()).get();
```

```java
List<String> list = ...;
IFunction<String,Boolean> condition = ...;
IFunction<String,String> myFunction = ...;
Op.on(list).forEach().execIfTrue(condition, myFunction)...
```

...an else side can it also be added, in which case the expression can change the type of the operator:

```java
List<String> list = ...;
IFunction<String,Boolean> condition = ...;
IFunction<String,Integer> myThenFunction = ...;
IFunction<String,Integer> myElseFunction = ...;
List<Integer> newList =  
    Op.on(list).forEach().execIfTrue(condition, myThenFunction, myElseFunction).get();
```

### Executing functions on the whole list

If a list has not been iterated (`forEach()`) (or it has, but `endFor()` has been called), functions can be executed on the whole list.

There are three ways of executing functions on a list as a whole:

- Executions which return a list (example: List<String> -> List<String> or List<String> -> List<Integer>)
- Executions which do not return a list (example: List<String> -> Calendar)

#### Returning a list

Functions will be executed using the `execAsList(...)` action:

```java
List<String> list = ...;
IFunction<List<String>,List<Integer>> myFunction = ...;
Op.on(list).execAsList(myFunction)...
```

A conditional check can be added (null, not null, condition true, condition false):

```java
List<String> list = ...;
IFunction<List<String>,List<Integer>> myFunction = ...;
Op.on(list).execIfNotNullAsList(myFunction)...
```

#### Not returning a list

```java
List<String> list = ...;
Calendar calendar =
    Op.on(list).exec(FnCalendar.fieldStringListToCalendar()).get();
```

---

## 6. Mapping functions

Mapping a list is the equivalent to iterating it, applying a function to each of its elements and then ending the iteration:

```java
Op.on(list).map(function).get();
```

Is equivalent to:

```java
Op.on(list).forEach().exec(function).endFor().get();
```

For example:

```java
List<String> list = ...;
List<BigDecimal> newList = 
    Op.on(list).map(FnString.toBigDecimal(DecimalPoint.IS_COMMA)).get();
```

A null condition on each of the list elements can be added for null-saving a function execution, if needed:

```java
List<String> list = ...;
IFunction<String,String> myFunction = ...;
Op.on(list).mapIfNotNull(myFunction)...
```

---

## 7. Selecting (conditional code)

op4j allows the conditional execution of actions. Once the condition (an action starting with `"if"`) is executed, all subsequent actions will apply only on the selected parts of the target object.

For example, lets convert into upper case only the first String element of the list:

```java
List<String> newList = Op.on(list).forEach().ifIndex(0).exec(FnString.toUpperCase()).get();
```

Selections can be ended with `endIf(...)`:

```java
List<String> newList = 
    Op.on(list).forEach().ifIndex(0,1,3).[ACTIONS ON SELECTED ELEMENTS].endIf()...
```

### Selecting specific list elements

If a selection is executed after an iteration, it will be applied on the list elements.

Selection can be done on the element's position in the list:

```java
Op.on(list).forEach().ifIndex(0,2,3)....
Op.on(list).forEach().ifIndexNot(0,1,5)....
```

Selection can also be based on the nullity of the element:

```java
Op.on(list).forEach().ifNull()....
Op.on(list).forEach().ifNotNull()....
```

And also on the value returned by the evaluation of a function returning `Boolean`:

```java
List<String> list = ...;
IFunction<String,Boolean> eval = ...;
Op.on(list).forEach().ifTrue(eval)...
Op.on(list).forEach().ifFalse(eval)...
```

### Selecting the list as a whole

Selection can also be performed on the list itself as a whole, effectively deciding whether subsequent actions will be executed at all or not.

```java
List<String> list = ...;
IFunction<List<String>,Boolean> eval = ...;
Op.on(list).ifNull()....
Op.on(list).ifNotNull()....
Op.on(list).ifTrue(eval)...
Op.on(list).ifFalse(eval)...
```

### Restrictions on execution actions after selection

After executing a selection action, function executed by means of a `map` or an `exec` action cannot change the list type (i.e., a `List<String>` must remain `List<String>`).

So this would not be valid:

```java
// Will not compile!
List<String> newList = 
    Op.on(list).forEach().ifIndex(0,1,3).exec(FnString.toInteger()).get();
```

...because converting only some of the list elements to integer would render the list type inconsistent (some elements would be `String`, some other `Integer`).

This is perfectly valid, though:

```java
// FnString.toUpperCase is IFunction<String,String>
List<String> newArray = 
    Op.on(list).forEach().ifIndex(0,1,3).exec(FnString.toUpperCase()).get();
```

---

## 8. Replacing

List elements (or the list itself) can be replaced by other objects:

```java
List<String> newList = 
    Op.on(list).forEach().ifNull().replaceWith("[no value]").get();
```

...which is equivalent to:

```java
List<String> newList = 
    Op.on(list).forEach().replaceIfNullWith("[no value]").get();
```

---

## 9. Removing duplicates

Lists can contain duplicate elements, which can be removed by executing a `distinct()` action:

```java
List<String> newList = Op.on(list).distinct().get();
```

---

## 10. Sorting

Lists can be sorted, both using a comparator or natural order:

```java
List<String> newList = Op.on(list).sort().get();
```

```java
Comparator<String> comparator = ...;
List<String> newList = Op.on(list).sort(comparator).get();
```

Also, lists can be sorted not by the elements themselves, but by the result of executing a function on the array elements:

```java
IFunction<String, Comparable<?>> function = ...;
List<String> newList = Op.on(list).sortBy(function).get();
```

---

## 11. Boolean conditions: all, any

Lists can be applied two boolean conditions: `all` and `any`. They both need a function which will be applied to each element of the array.

`all(function)` will return TRUE if the result of executing `function` on all the elements of the list is TRUE:

```java
IFunction<String, Boolean> function = ...;
Boolean allTrue = Op.on(list).all(function).get();
```

`any(function)` will return TRUE if the result of executing `function` on any the elements of the list is TRUE:

```java
IFunction<String, Boolean> function = ...;
Boolean anyTrue = Op.on(list).any(function).get();
```

---

## 12. Reversing

Lists can be reversed, so that the order of its elements gets inverted:

```java
// list = 5,3,4,2
List<Integer> list = Op.onListFor(2,4,3,5).reverse().get();
```