# Working with arrays

This page explains how op4j can deal with array objects.

Array input objects are considered immutable, so they will not be changed when used in an op4j expression and a new array will always be returned when executing `get()`.  
This, however, does not apply to the input array's element objects, which could be changed if you executed on them any functions which might change their state instead of substituting them for new elements.

## Contents

- [Creating array expressions](#creating-array-expressions)
- [Converting to lists, sets or maps](#converting-to-lists-sets-or-maps)
- [Iterating](#iterating)
- [Modifying](#modifying)
- [Executing functions](#executing-functions)
- [Mapping functions](#mapping-functions)
- [Selecting (conditional code)](#selecting-conditional-code)
- [Replacing](#replacing)
- [Removing duplicates](#removing-duplicates)
- [Sorting](#sorting)
- [Boolean conditions: all, any](#boolean-conditions-all-any)
- [Reversing](#reversing)

---

## Creating array expressions

### Operation expressions

The creation of operation expressions on arrays in op4j is a little bit different (and a little bit more complex) than it is for creating any other kind of operation expression.

This is because, when dealing with structures (arrays, lists, maps or sets), op4j needs to be able to internally create new instances of those structures. And while creating an instance of `List<String>` or `List<Integer>` is just a matter of instantiating the `java.util.ArrayList` class (independently of its type parameters or generics), for instantiating an array the actual array class is needed, and creating an instance of `String[]` is different from creating an instance of `Integer[]`.

Although Java makes this in fact a little bit more complex than what is explained here, this is in general terms why **op4j needs a Type (javaRuntype Type) to be specified when creating operation expressions on arrays**. Specifically, it needs the type of the array elements (i.e. `Type<String>` for a String[]).

#### Specifying the array element type

This is then the basic way of creating an operation expression on an array:

```java
String[] array = ...;
Op.onArrayOf(Types.STRING, array)...
```

#### Making it faster: the partial array operator

In order to make this faster, however, an abbreviated option is available:

```java
MyObject[] array = ...;
Op.on(array)...
```

...which looks like the creation of an operation expression for a list, a map, a set or any other object, but in fact on an array this will only give you a **partial operator**. An operator only able of executing some actions (for example, `exec(...)` or `toList()`) which do not involve instantiating a new array. For example, you will not be able to iterate (`forEach()`), but this will be valid:

```java
MyObject[] array = ...;
List<MyObject> list = Op.on(array).toList().get();
```

In order to convert a partial array operator into a full-featured array operator, a cast will be needed:

```java
MyObject[] array = ...;
Type<MyObject> myType = ...;
Op.on(array).asArrayOf(myType).forEach()...
```

#### Making it even faster for known types

There are some types, though, which are of everyday use, and for which op4j offers you the possibility of **obtaining a full-featured array operator without specifying the type**.

These types are:

- `String[]`
- `Boolean[]`
- `Character[]`
- Numbers: `Byte[]`, `Short[]`, `Integer[]`, `Long[]`, `Float[]`, `Double[]`, `BigInteger[]`, `BigDecimal[]`
- Dates: `Calendar[]`, `java.util.Date[]`, `java.sql.Date[]`, `Timestamp[]`

**For arrays of all these types, the abbreviated method of creating the operation expression returns a full-featured operator** just as if `onArrayOf(...)` had been executed instead:

```java
String[] array = ...;
Op.on(array).forEach()...
```

This code is therefore completely equivalent to:

```java
String[] array = ...;
Op.onArrayOf(Types.STRING, array).forEach()...
```

#### Creating arrays from their elements

Array expressions can be created by directly specifying the array elements, like this:

```java
Op.onArrayFor("hello", "ola", "hola", "hallo", "ciao").forEach()...
```

### Function expressions

Function expressions are created as usual with other structures:

```java
// Create a function which receives a String[] variable as input
function = Fn.onArrayOf(Types.STRING)...get();
```

---

## Converting to lists, sets or maps

### Lists

For converting an array into a list:

```java
List<String> list = Op.on(array).toList().get();
```

### Sets

For converting an array into a set:

```java
Set<String> set = Op.on(array).toSet().get();
```

### Maps

#### Using a Map Builder

A Map Builder is a function which returns map entries (`IFunction<T,Map.Entry<K,V>>`), usually created by extending the abstract class `org.op4j.functions.MapBuilder`, and which provides op4j with a way of creating a map entry from each of the array's elements.

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
Map<Integer,Calendar> map = Op.on(array).toMap(mapBuilder).get();
```

##### Grouping using a Map Builder

If one or more values can have the same key, you should create a grouped map, like:

```java
MapBuilder<String,Integer,Calendar> mapBuilder = ...;
Map<Integer,Calendar[]> map = Op.on(array).toGroupMapOf(Types.CALENDAR, mapBuilder).get();
```

#### Using two functions

Instead of a map builder function, we could just use two functions instead, one for creating keys, and a different one for creating values:

```java
IFunction<String,Integer> keyFunction = ...;
IFunction<String,Calendar> valueFunction = ...;
Map<Integer,Calendar> map = Op.on(array).toMap(keyFunction, valueFunction).get();
```

##### Grouping using two functions

Again, if one or more values can have the same key, you should create a grouped map, like:

```java
IFunction<String,Integer> keyFunction = ...;
IFunction<String,Calendar> valueFunction = ...;
Map<Integer,Calendar[]> map = Op.on(array).toGroupMapOf(Types.CALENDAR, keyFunction, valueFunction).get();
```

#### Zipping keys or values

A Map can also be created from an array by zipping. Zipping means combining the elements in the array with other objects like this:

```java
// map = {{1="a"}, {2="b"}}
Map<Integer,String> map = 
    Op.onArrayFor(1,2).zipValues("a","b").get();
```

...using a collection...

```java
Collection<String> values = {"a", "b"};
// map = {{1="a"}, {2="b"}}
Map<Integer,String> map = 
    Op.onArrayFor(1,2).zipValuesFrom(values).get();
```

Or similarly:

```java
// map = {{"a"=1}, {"b"=2}}
Map<String,Integer> map = 
    Op.onArrayFor(1,2).zipKeys("a","b").get();
```

...using a collection...

```java
Collection<String> keys = {"a", "b"};
// map = {{"a"=1}, {"b"=2}}
Map<String,Integer> map = 
    Op.onArrayFor(1,2).zipKeysFrom(keys).get();
```

Alternatively, a function can be used for evaluating existing elements and obtaining keys or values:

```java
IFunction<Integer,String> valueEvaluatorFn = ...;
Map<Integer,String> map = 
    Op.onArrayFor(1,2).zipValuesBy(valueEvaluatorFn).get();
```

```java
IFunction<Integer,String> keyEvaluatorFn = ...;
Map<String,Integer> map = 
    Op.onArrayFor(1,2).zipKeysBy(keyEvaluatorFn).get();
```

##### Zipping and Grouping

Collisions (entries with the same key) can be avoided when zipping by using grouping actions:

```java
// mapOfArrays = {{1=["a","c"]}, {2=["b","d","e]}}
Map<Integer,String[]> mapOfArrays = 
    Op.onArrayFor(1,2,1,2,2).zipAndGroupValues(Types.STRING, "a","b","c","d","e").get();
```

```java
IFunction<Integer,String> keyEvaluatorFn = ...;
Map<String,Integer[]> map = 
    Op.onArrayFor(1,2,3,4,5,6).zipAndGroupKeysBy(keyEvaluatorFn).get();
```

#### Coupling

The third way to create a Map from an array is by "coupling" or alternating elements, this is, by considering even elements as keys and odd elements as values (starting with 0). This will mean of course that, for a `String[]`, we will get a `Map<String,String>`.

```java
// map = {{"a"="X"}, {"b"="Y"}}
Map<String,String> map = 
    Op.onArrayFor("a","X","b","Y").couple().get();
```

##### Coupling and Grouping

Again, collisions can be avoided by grouping...

```java
// map = {{"a"=["X","Y","Z"]}, {"b"=["1","2"]}}
Map<String,String[]> mapOfArray = 
    Op.onArrayFor("a","X","b","1","a","Y","a","Z","b","2").coupleAndGroup().get();
```

---

## Iterating

Arrays can be iterated according to the following scheme:

```java
Op.on(array).forEach().[ELEMENT ACTIONS].get();
```

After the `forEach()` action, any action added to the expression chain will be applied, not on the array itself, but on each of its elements, and the result obtained when executing `get()` will be an array with the results of applying the subsequently chained actions on each of the array elements.

Iteration can be ended with the `endFor()` action:

```java
Op.on(array).forEach().[ELEMENT ACTIONS].endFor().[ARRAY ACTIONS].get();
```

The `endFor()` action allows the subsequent execution of actions acting again on the whole array, after having executed some actions on its elements by separate between `forEach()` and `endFor()`. For example:

```java
List<String> list = Op.on(array).forEach().exec(FnString.toUpperCase()).endFor().toList().get();
```

---

## Modifying

An array can be modified by adding or removing elements from it.

Several options for adding new elements at the end of an array:

```java
String[] array = ...;
Collection<String> strCol = ...;
Op.on(array).add("new String")...
Op.on(array).addAll("new String", "another new String")...
Op.on(array).addAll(strCol)...
```

New elements can also be inserted into a specific position. Positions start with 0.

```java
String[] array = ...;
Op.on(array).insert(2, "new string")...
Op.on(array).insertAll(2, "new String", "another new String")...
```

Removal of elements can be done in several ways. Elements can be removed attending to their position inside the array:

```java
Op.on(array).removeAllIndexes(2,3,5)...
Op.on(array).insertAllIndexesNot(2,3,5)...
```

Also attending to their value:

```java
Op.on(array).removeAllEqual("Coast", "Mountain")...
```

Nulls can be removed easily:

```java
Op.on(array).removeAllNull()...
```

And finally a function returning `Boolean` can be used as evaluator to determine whether an element should be removed or not, in several ways:

```java
String[] array = ...;
IFunction<String,Boolean> eval = ...;
Op.on(array).removeAllTrue(eval)...
Op.on(array).removeAllFalse(eval)...
Op.on(array).removeAllNullOrTrue(eval)...
Op.on(array).removeAllNullOrFalse(eval)...
Op.on(array).removeAllNotNullAndTrue(eval)...
Op.on(array).removeAllNotNullAndFalse(eval)...
```

---

## Executing functions

### Executing functions on the array elements

Due to the special condition of arrays in Java, op4j makes a difference between two ways of executing functions on them:

- Executions which keep the array element type (example: String[] -> String[])
- Executions which change the array element type (example: String[] -> Integer[])

#### Keeping the array element type

Functions can be executed on each of the array elements after a `forEach()` action:

```java
String[] array = ...;
Op.on(array).forEach().exec(FnString.toUpperCase())...
```

`FnString.toUpperCase()` was executable this way because it is an `IFunction<String,String>`, and so it would not change the array element type.

A condition can be added for conditional execution, if needed:

```java
String[] array = ...;
IFunction<String,String> myFunction = ...;
Op.on(array).forEach().execIfNotNull(myFunction)...
```

```java
String[] array = ...;
IFunction<String,Boolean> condition = ...;
IFunction<String,String> myFunction = ...;
Op.on(array).forEach().execIfTrue(condition, myFunction)...
```

...an else side can it also be added, in which case the expression can change the type of the operator:

```java
String[] array = ...;
IFunction<String,Boolean> condition = ...;
IFunction<String,Integer> myThenFunction = ...;
IFunction<String,Integer> myElseFunction = ...;
Integer[] newArray = 
    Op.on(array).forEach().execIfTrue(condition, myThenFunction, myElseFunction).get();
```

#### Changing the array element type

When the executed function changes the array element type, the new type has to be specified in the `exec(...)` call, so that op4j is able to instantiate the new array:

```java
String[] array = ...;
BigDecimal[] newArray = 
    Op.on(array).forEach().exec(Types.BIG_DECIMAL, FnString.toBigDecimal(DecimalPoint.IS_COMMA)).get();
```

### Executing functions on the whole array

If an array has not been iterated (`forEach()`) (or it has, but `endFor()` has been called), functions can be executed on the whole array.

There are three ways of executing functions on an array as a whole:

- Executions which return an array keeping the array element type (example: String[] -> String[])
- Executions which return an array changing the array element type (example: String[] -> Integer[])
- Executions which do not return an array (example: String[] -> Calendar)

#### Returning an array and keeping the array element type

Functions will be executed using the `execAsArray(...)` action:

```java
String[] array = ...;
IFunction<String[],String[]> myFunction = ...;
Op.on(array).execAsArray(myFunction)...
```

A conditional check can be added (null, not null, condition true, condition false):

```java
String[] array = ...;
IFunction<String[],String[]> myFunction = ...;
Op.on(array).execIfNotNullAsArray(myFunction)...
```

#### Returning an array and changing the array element type

```java
String[] array = ...;
IFunction<String[],Integer[]> myFunction = ...;
Op.on(array).execAsArray(Types.INTEGER, myFunction)...
```

#### Not returning an array

```java
String[] array = new String[] {"1978", "12", "6"};
Calendar calendar =
    Op.on(array).exec(FnCalendar.fieldStringArrayToCalendar()).get();
```

---

## Mapping functions

Mapping an array is the equivalent to iterating it, applying a function to each of its elements and then ending the iteration:

```java
Op.on(array).map(function).get();
```

Is equivalent to:

```java
Op.on(array).forEach().exec(function).endFor().get();
```

In the same way as executing functions on array elements, there are two ways of mapping:

- Executions which keep the array element type (example: String[] -> String[])
- Executions which change the array element type (example: String[] -> Integer[])

### Keeping the array element type

Functions can be mapped easily:

```java
String[] array = ...;
Op.on(array).map(FnString.toUpperCase())...
```

As with `exec`, `FnString.toUpperCase()` was executable this way because it is an `IFunction<String,String>`, and so it would not change the array element type.

A null condition on each of the array elements can be added for null-saving a function execution, if needed:

```java
String[] array = ...;
IFunction<String,String> myFunction = ...;
Op.on(array).mapIfNotNull(myFunction)...
```

### Changing the array element type

When the executed function changes the array element type, the new type has to be specified in the `map(...)` call, so that op4j is able to instantiate the new array:

```java
String[] array = ...;
BigDecimal[] newArray = 
    Op.on(array).map(Types.BIG_DECIMAL, FnString.toBigDecimal(DecimalPoint.IS_COMMA)).get();
```

---

## Selecting (conditional code)

op4j allows the conditional execution of actions. Once the condition (an action starting with `if`) is executed, all subsequent actions will apply only on the selected parts of the target object.

For example, lets convert into upper case only the first String element of the array:

```java
String[] newArray = Op.on(array).forEach().ifIndex(0).exec(FnString.toUpperCase()).get();
```

Selections can be ended with `endIf(...)`:

```java
String[] newArray = 
    Op.on(array).forEach().ifIndex(0,1,3).[ACTIONS ON SELECTED ELEMENTS].endIf()...
```

### Selecting specific array elements

If a selection is executed after an iteration, it will be applied on the array elements.

Selection can be done on the element's position in the array:

```java
Op.on(array).forEach().ifIndex(0,2,3)....
Op.on(array).forEach().ifIndexNot(0,1,5)....
```

Selection can also be based on the nullity of the element:

```java
Op.on(array).forEach().ifNull()....
Op.on(array).forEach().ifNotNull()....
```

And also on the value returned by the evaluation of a function returning `Boolean`:

```java
String[] array = ...;
IFunction<String,Boolean> eval = ...;
Op.on(array).forEach().ifTrue(eval)...
Op.on(array).forEach().ifFalse(eval)...
```

### Selecting the array as a whole

Selection can also be performed on the array itself as a whole, effectively deciding whether subsequent actions will be executed at all or not.

```java
String[] array = ...;
IFunction<String[],Boolean> eval = ...;
Op.on(array).ifNull()....
Op.on(array).ifNotNull()....
Op.on(array).ifTrue(eval)...
Op.on(array).ifFalse(eval)...
```

### Restrictions on execution actions after selection

After executing a selection action, function executed by means of a `map` or an `exec` action cannot change the array type (i.e., a `String[]` must remain `String[]`).

So this would not be valid:

```java
// Will not compile!
String[] newArray = 
    Op.on(array).forEach().ifIndex(0,1,3).exec(FnString.toInteger()).get();
```

...because converting only some of the array elements to integer would render the array type inconsistent (some elements would be `String`, some other `Integer`).

This is perfectly valid, though:

```java
// FnString.toUpperCase is IFunction<String,String>
String[] newArray = 
    Op.on(array).forEach().ifIndex(0,1,3).exec(FnString.toUpperCase()).get();
```

---

## Replacing

Array elements (or the array itself) can be replaced by other objects:

```java
String[] newArray = 
    Op.on(array).forEach().ifNull().replaceWith("[no value]").get();
```

...which is equivalent to:

```java
String[] newArray = 
    Op.on(array).forEach().replaceIfNullWith("[no value]").get();
```

---

## Removing duplicates

Arrays can contain duplicate elements, which can be removed by executing a `distinct()` action:

```java
String[] newArray = Op.on(array).distinct().get();
```

---

## Sorting

Arrays can be sorted, both using a comparator or natural order:

```java
String[] newArray = Op.on(array).sort().get();
```

```java
Comparator<String> comparator = ...;
String[] newArray = Op.on(array).sort(comparator).get();
```

Also, arrays can be sorted not by the elements themselves, but by the result of executing a function on the array elements:

```java
IFunction<String, Comparable<?>> function = ...;
String[] newArray = Op.on(array).sortBy(function).get();
```

---

## Boolean conditions: all, any

Arrays can be applied two boolean conditions: `all` and `any`. They both need a function which will be applied to each element of the array.

`all(function)` will return TRUE if the result of executing `function` on all the elements of the array is TRUE:

```java
IFunction<String, Boolean> function = ...;
Boolean allTrue = Op.on(array).all(function).get();
```

`any(function)` will return TRUE if the result of executing `function` on any the elements of the array is TRUE:

```java
IFunction<String, Boolean> function = ...;
Boolean anyTrue = Op.on(array).any(function).get();
```

---

## Reversing

Arrays can be reversed, so that the order of its elements gets inverted:

```java
// array = 5,3,4,2
Integer[] array = Op.onArrayFor(2,4,3,5).reverse().get();
```
