# Working with sets

This page explains how op4j can deal with set objects (objects implementing `java.util.Set<T>`).

Set input objects are considered immutable, so they will not be changed when used in an op4j expression and a new set will always be returned when executing `get()`.

This, however, does not apply to the input set element objects, which could be changed if you executed on them any functions which might change their state instead of substituting them for new elements.

## Contents

- Creating set expressions
- Converting to arrays, lists or maps
- Iterating
- Modifying
- Executing functions
- Mapping functions
- Selecting (conditional code)
- Replacing
- Sorting
- Boolean conditions: all, any
- Reversing

---

## 1. Creating set expressions

### Operation expressions

There are two equivalent ways of creating an operation expression on a set. Just use the method you like most:

```java
Set<String> set = ...;
Op.on(set)...
```

```java
Set<String> set = ...;
Op.onList(set)...
```

#### Creating sets from their elements

Set expressions can be created by directly specifying the set elements, like this:

```java
Op.onSetFor("hello", "ola", "hola", "hallo", "ciao").forEach()...
```

### Function expressions

Function expressions are created as usual with other structures:

```java
// Create a function which receives a Set<String> variable as input
function = Fn.onSetOf(Types.STRING)...get();
```

---

## 2. Converting to arrays, lists or maps

### Arrays

For converting a set into an array:

```java
String[] array = Op.on(set).toArrayOf(Types.STRING).get();
```

### Lists

For converting a set into a list:

```java
List<String> list = Op.on(set).toList().get();
```

### Maps

#### Using a Map Builder

A Map Builder is a function which returns map entries (`IFunction<T,Map.Entry<K,V>>`), usually created by extending the abstract class `org.op4j.functions.MapBuilder`, and which provides op4j with a way of creating a map entry from each of the set's elements.

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
Map<Integer,Calendar> map = Op.on(set).toMap(mapBuilder).get();
```

##### Grouping using a Map Builder

If one or more values can have the same key, you should create a grouped map, like:

```java
MapBuilder<String,Integer,Calendar> mapBuilder = ...;
Map<Integer,Set<Calendar>> map = Op.on(set).toGroupMap(mapBuilder).get();
```

#### Using two functions

Instead of a map builder function, we could just use two functions instead, one for creating keys, and a different one for creating values:

```java
IFunction<String,Integer> keyFunction = ...;
IFunction<String,Calendar> valueFunction = ...;
Map<Integer,Calendar> map = Op.on(set).toMap(keyFunction, valueFunction).get();
```

##### Grouping using two functions

Again, if one or more values can have the same key, you should create a grouped map, like:

```java
IFunction<String,Integer> keyFunction = ...;
IFunction<String,Calendar> valueFunction = ...;
Map<Integer,Set<Calendar>> map = Op.on(set).toGroupMap(keyFunction, valueFunction).get();
```

#### Zipping keys or values

A Map can also be created from a set by zipping. Zipping means combining the elements in the set with other objects like this:

```java
// map = {{1="a"}, {2="b"}}
Map<Integer,String> map = 
    Op.onSetFor(1,2).zipValues("a","b").get();
```

...using a collection...

```java
Collection<String> values = {"a", "b"};
// map = {{1="a"}, {2="b"}}
Map<Integer,String> map = 
    Op.onSetFor(1,2).zipValuesFrom(values).get();
```

Or similarly:

```java
// map = {{"a"=1}, {"b"=2}}
Map<String,Integer> map = 
    Op.onSetFor(1,2).zipKeys("a","b").get();
```

...using a collection...

```java
Collection<String> keys = {"a", "b"};
// map = {{"a"=1}, {"b"=2}}
Map<String,Integer> map = 
    Op.onSetFor(1,2).zipKeysFrom(keys).get();
```

Alternatively, a function can be used for evaluating existing elements and obtaining keys or values:

```java
IFunction<Integer,String> valueEvaluatorFn = ...;
Map<Integer,String> map = 
    Op.onSetFor(1,2).zipValuesBy(valueEvaluatorFn).get();
```

```java
IFunction<Integer,String> keyEvaluatorFn = ...;
Map<String,Integer> map = 
    Op.onSetFor(1,2).zipKeysBy(keyEvaluatorFn).get();
```

##### Zipping and Grouping

Collisions (entries with the same key) can be avoided when zipping by using grouping actions:

```java
// mapOfArrays = {{1=["a","c"]}, {2=["b","d","e]}}
Map<Integer,Set<String>> mapOfArrays = 
    Op.onSetFor(1,2,1,2,2).zipAndGroupValues(Types.STRING, "a","b","c","d","e").get();
```

```java
IFunction<Integer,String> keyEvaluatorFn = ...;
Map<String,Set<Integer>> map = 
    Op.onSetFor(1,2,3,4,5,6).zipAndGroupKeysBy(keyEvaluatorFn).get();
```

#### Coupling

The third way to create a Map from a set is by "coupling" or alternating elements, this is, by considering even elements as keys and odd elements as values (starting with 0). This will mean of course that, for a `Set<String>`, we will get a `Map<String,String>`.

```java
// map = {{"a"="X"}, {"b"="Y"}}
Map<String,String> map = 
    Op.onSetFor("a","X","b","Y").couple().get();
```

---

## 3. Iterating

Sets can be iterated according to the following scheme:

```java
Op.on(set).forEach().[ELEMENT ACTIONS].get();
```

After the `forEach()` action, any action added to the expression chain will be applied, not on the set itself, but on each of its elements, and the result obtained when executing `get()` will be a set with the results of applying the subsequently chained actions on each of the set elements.

Iteration can be ended with the `endFor()` action:

```java
Op.on(set).forEach().[ELEMENT ACTIONS].endFor().[SET ACTIONS].get();
```

The `endFor()` action allows the subsequent execution of actions acting again on the whole set, after having executed some actions on its elements by separate between `forEach()` and `endFor()`. For example:

```java
List<String> list = Op.on(set).forEach().exec(FnString.toUpperCase()).endFor().toList().get();
```

---

## 4. Modifying

A set can be modified by adding or removing elements from it.

Several options for adding new elements at the end of a set:

```java
Set<String> set = ...;
Collection<String> strCol = ...;
Op.on(set).add("new String")...
Op.on(set).addAll("new String", "another new String")...
Op.on(set).addAll(strCol)...
```

New elements can also be inserted into a specific position. Positions start with 0 (remember that sets can have order, and in fact all sets managed by op4j have, as they are `java.util.LinkedHashSet` objects).

```java
Set<String> set = ...;
Op.on(set).insert(2, "new string")...
Op.on(set).insertAll(2, "new String", "another new String")...
```

Removal of elements can be done in several ways. Elements can be removed attending to their position inside the set:

```java
Op.on(set).removeAllIndexes(2,3,5)...
Op.on(set).insertAllIndexesNot(2,3,5)...
```

Also attending to their value:

```java
Op.on(set).removeAllEqual("Coast", "Mountain")...
```

Nulls can be removed easily:

```java
Op.on(set).removeAllNull()...
```

And finally a function returning `Boolean` can be used as evaluator to determine whether an element should be removed or not, in several ways:

```java
Set<String> set = ...;
IFunction<String,Boolean> eval = ...;
Op.on(set).removeAllTrue(eval)...
Op.on(set).removeAllFalse(eval)...
Op.on(set).removeAllNullOrTrue(eval)...
Op.on(set).removeAllNullOrFalse(eval)...
Op.on(set).removeAllNotNullAndTrue(eval)...
Op.on(set).removeAllNotNullAndFalse(eval)...
```

---

## 5. Executing functions

### Executing functions on the set elements

Functions can be executed on each of the set elements after a `forEach()` action:

```java
Set<String> set = ...;
Set<String> newSet = Op.on(set).forEach().exec(FnString.toUpperCase()).get();
```

A condition can be added for conditional execution, if needed:

```java
Set<String> set = ...;
Set<Integer> newSet = Op.on(set).forEach().execIfNotNull(FnString.toInteger()).get();
```

```java
Set<String> set = ...;
IFunction<String,Boolean> condition = ...;
IFunction<String,String> myFunction = ...;
Op.on(set).forEach().execIfTrue(condition, myFunction)...
```

...an else side can it also be added, in which case the expression can change the type of the operator:

```java
Set<String> set = ...;
IFunction<String,Boolean> condition = ...;
IFunction<String,Integer> myThenFunction = ...;
IFunction<String,Integer> myElseFunction = ...;
Set<Integer> newSet = 
    Op.on(set).forEach().execIfTrue(condition, myThenFunction, myElseFunction).get();
```

### Executing functions on the whole set

If a set has not been iterated (`forEach()`) (or it has, but `endFor()` has been called), functions can be executed on the whole set.

There are three ways of executing functions on a set as a whole:

- Executions which return a set (example: `Set<String>` -> `Set<String>` or `Set<String>` -> `Set<Integer>`)
- Executions which do not return a set (example: `Set<String>` -> `Integer`)

#### Returning a set

Functions will be executed using the `execAsSet(...)` action:

```java
Set<String> set = ...;
IFunction<Set<String>,Set<Integer>> myFunction = ...;
Op.on(set).execAsSet(myFunction)...
```

A conditional check can be added (null, not null, condition true, condition false):

```java
Set<String> set = ...;
IFunction<Set<String>,Set<Integer>> myFunction = ...;
Op.on(set).execIfNotNullAsSet(myFunction)...
```

#### Not returning a set

```java
Set<String> set = ...;
IFunction<Set<String>,Integer> countSetElementsFn = ...;
Integer result = Op.on(set).exec(countSetElementsFn).get();
```

---

## 6. Mapping functions

Mapping a set is the equivalent to iterating it, applying a function to each of its elements and then ending the iteration:

```java
Op.on(set).map(function).get();
```

Is equivalent to:

```java
Op.on(set).forEach().exec(function).endFor().get();
```

For example:

```java
Set<String> set = ...;
Set<BigDecimal> newSet = 
    Op.on(set).map(FnString.toBigDecimal(DecimalPoint.IS_COMMA)).get();
```

A null condition on each of the set elements can be added for null-saving a function execution, if needed:

```java
Set<String> set = ...;
IFunction<String,String> myFunction = ...;
Op.on(set).mapIfNotNull(myFunction)...
```

---

## 7. Selecting (conditional code)

op4j allows the conditional execution of actions. Once the condition (an action starting with `"if"`) is executed, all subsequent actions will apply only on the selected parts of the target object.

For example, lets convert into upper case only the first String element of the set:

```java
Set<String> newSet = Op.on(set).forEach().ifIndex(0).exec(FnString.toUpperCase()).get();
```

Selections can be ended with `endIf(...)`:

```java
Set<String> newSet = 
    Op.on(set).forEach().ifIndex(0,1,3).[ACTIONS ON SELECTED ELEMENTS].endIf()...
```

### Selecting specific set elements

If a selection is executed after an iteration, it will be applied on the set elements.

Selection can be done on the element's position in the set:

```java
Op.on(set).forEach().ifIndex(0,2,3)....
Op.on(set).forEach().ifIndexNot(0,1,5)....
```

Selection can also be based on the nullity of the element:

```java
Op.on(set).forEach().ifNull()....
Op.on(set).forEach().ifNotNull()....
```

And also on the value returned by the evaluation of a function returning `Boolean`:

```java
Set<String> set = ...;
IFunction<String,Boolean> eval = ...;
Op.on(set).forEach().ifTrue(eval)...
Op.on(set).forEach().ifFalse(eval)...
```

### Selecting the set as a whole

Selection can also be performed on the set itself as a whole, effectively deciding whether subsequent actions will be executed at all or not.

```java
Set<String> set = ...;
IFunction<Set<String>,Boolean> eval = ...;
Op.on(set).ifNull()....
Op.on(set).ifNotNull()....
Op.on(set).ifTrue(eval)...
Op.on(set).ifFalse(eval)...
```

### Restrictions on execution actions after selection

After executing a selection action, function executed by means of a `map` or an `exec` action cannot change the set type (i.e., a `Set<String>` must remain `Set<String>`).

So this would not be valid:

```java
// Will not compile!
Set<String> newSet = 
    Op.on(set).forEach().ifIndex(0,1,3).exec(FnString.toInteger()).get();
```

...because converting only some of the set elements to integer would render the set type inconsistent (some elements would be `String`, some other `Integer`).

This is perfectly valid, though:

```java
// FnString.toUpperCase is IFunction<String,String>
Set<String> newSet = 
    Op.on(set).forEach().ifIndex(0,1,3).exec(FnString.toUpperCase()).get();
```

---

## 8. Replacing

Set elements (or the set itself) can be replaced by other objects:

```java
Set<String> newSet = 
    Op.on(set).forEach().ifNull().replaceWith("[no value]").get();
```

...which is equivalent to:

```java
Set<String> newSet = 
    Op.on(set).forEach().replaceIfNullWith("[no value]").get();
```

---

## 9. Sorting

Sets can be sorted (op4j uses `LinkedHashSet` internally), both using a comparator or natural order:

```java
Set<String> newSet = Op.on(set).sort().get();
```

```java
Comparator<String> comparator = ...;
Set<String> newSet = Op.on(set).sort(comparator).get();
```

Also, sets can be sorted not by the elements themselves, but by the result of executing a function on the set elements:

```java
IFunction<String, Comparable<?>> function = ...;
Set<String> newSet = Op.on(set).sortBy(function).get();
```

---

## 10. Boolean conditions: all, any

Sets can be applied two boolean conditions: `all` and `any`. They both need a function which will be applied to each element of the set.

`all(function)` will return TRUE if the result of executing `function` on all the elements of the set is TRUE:

```java
IFunction<String, Boolean> function = ...;
Boolean allTrue = Op.on(set).all(function).get();
```

`any(function)` will return TRUE if the result of executing `function` on any the elements of the set is TRUE:

```java
IFunction<String, Boolean> function = ...;
Boolean anyTrue = Op.on(set).any(function).get();
```

---

## 11. Reversing

Sets can be reversed, so that the order of its elements gets inverted:

```java
// set = 5,3,4,2
Set<Integer> set = Op.onSetFor(2,4,3,5).reverse().get();
```
