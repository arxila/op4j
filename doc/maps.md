# Working with maps

This page explains how op4j can deal with map objects (objects implementing `java.util.Map<K,V>`).

Map input objects are considered immutable, so they will not be changed when used in an op4j expression and a new map will always be returned when executing `get()`.

This, however, does not apply to the input map key and value objects, which could be changed if you executed on them any functions which might change their state instead of substituting them for new elements.

## Contents

- [Creating map expressions](#1-creating-map-expressions)
- [Extracting keys and values](#2-extracting-keys-and-values)
- [Iterating](#3-iterating)
- [Modifying](#4-modifying)
- [Executing functions](#5-executing-functions)
- [Selecting (conditional code)](#6-selecting-conditional-code)
- [Replacing](#7-replacing)
- [Reversing](#8-reversing)

---

## 1. Creating map expressions

### Operation expressions

There are two equivalent ways of creating an operation expression on a map. Just use the method you like most:

```java
Map<String,String> map = ...;
Op.on(map)...
```

```java
Map<String,String> map = ...;
Op.onMap(map)...
```

#### Maps from their elements

Map expressions can be created by specifying the map elements (entries), as key/value pairs, like:

```java
Op.onMapFor(key1, value1).and(key2, value2).and(key3, value3)...
```

Once any action is called, the `and(...)` method will not be available anymore, as it is only meant to *build* the map.

#### Maps from arrays, lists or sets

Maps can be built from arrays, lists or sets in a variety of ways (see the [arrays](./arrays.md), [lists](./lists.md) or [sets](./sets.md) documentation for details).

For example, zipping can be used:

```java
Map<String,Integer> map = Op.onListFor("a","b","c").zipValues(1,2,3).get();
```

### Function expressions

Function expressions are created as usual with other structures:

```java
// Create a function which receives a Map<Integer,String> variable as input
function = Fn.onMapOf(Types.INTEGER, Types.STRING)...get();
```

---

## 2. Extracting keys and values

All keys of a map can be extracted as a Set:

```java
Map<Integer,String> map = ...;
Set<Integer> keys = Op.on(map).extractKeys().get();
```

Also values can be extracted, as a List:

```java
Map<Integer,String> map = ...;
List<String> values = Op.on(map).extractValues().get();
```

---

## 3. Iterating

Maps can be iterated, resulting in an operator acting on its map entries (`Map.Entry<K,V>`):

```java
Op.on(map).forEachEntry()...
```

And once iterating each entry, actions can be executed on the entry itself (having thus access to both key and value):

```java
Op.on(map).forEachEntry().[ACTIONS ON MAP ENTRIES]...
```

But also the keys can be selected, so that subsequent actions will only apply on the map's keys:

```java
Op.on(map).forEachEntry().onKey().[ACTIONS ON MAP KEYS]...
```

...and the same for the values:

```java
Op.on(map).forEachEntry().onValue().[ACTIONS ON MAP VALUES]...
```

The result obtained when executing `get()` after iterating will be a map with the results of applying the subsequently chained actions on the entries/keys/values of the map.

Iteration on entries can be ended with the `endFor()` action:

```java
Op.on(map).forEachEntry().[ENTRY ACTIONS].endFor().[MAP ACTIONS].get();
```

And selection of keys or values can be ended with the `endOn()` action:

```java
Op.on(map).forEachEntry().onKey().[KEY ACTIONS].endOn().endFor().[MAP ACTIONS].get();
Op.on(map).forEachEntry().onValue().[VALUE ACTIONS].endOn().endFor().[MAP ACTIONS].get();
```

---

## 4. Modifying

A map can be modified by adding or removing elements from it.

Maps in op4j are ordered (`LinkedHashMap`), and several options for adding new elements at the end of a map:

```java
Map<String,String> map = ...;
Map<String,String> newElements = ...;
Op.on(map).put("new Key", "new Value")...
Op.on(map).putAll(newElements)...
```

New elements can also be inserted into a specific position. Positions start with 0.

```java
Map<String,String> map = ...;
Map<String,String> newElements = ...;
Op.on(map).insert(0, "new Key", "new Value")...
Op.on(map).insertAll(0, newElements)...
```

Removal of elements can be done in several ways. Elements can be removed attending to their keys:

```java
Op.on(map).removeAllKeys("one Key", "another Key")...
Op.on(map).removeAllKeysNot("one Key", "another Key")...
```

A function returning `Boolean` can be used as evaluator to determine whether an element should be removed or not:

```java
Map<String,String> map = ...;
IFunction<Map.Entry<String,String>,Boolean> eval = ...;
Op.on(map).removeAllTrue(eval)...
Op.on(map).removeAllFalse(eval)...
```

---

## 5. Executing functions

### Executing functions on the map keys or values

Functions can be executed on each of the map keys or values after a `forEachEntry()` followed by and an `onKey()` or `onValue()` action:

```java
Map<String,String> map = ...;
Map<String,String> newMap = 
    Op.on(map).forEachEntry().onValue().exec(FnString.toUpperCase()).get();
```

A condition can be added for conditional execution, if needed:

```java
Map<String,String> map = ...;
IFunction<String,String> myFunction = ...;
Map<String,String> newMap = 
    Op.on(map).forEachEntry().onValue().execIfNotNull(myFunction).get();
```

```java
Map<String,String> map = ...;
IFunction<String,Boolean> condition = ...;
IFunction<String,String> myFunction = ...;
Op.on(map).forEachEntry().onValue().execIfTrue(condition, myFunction)...
```

...an else side can it also be added, in which case the expression can change the type of the operator:

```java
Map<String,String> map = ...;
IFunction<String,Boolean> condition = ...;
IFunction<String,Integer> myThenFunction = ...;
IFunction<String,Integer> myElseFunction = ...;
Map<String,Integer> newMap = 
    Op.on(map).forEachEntry().onValue().execIfTrue(condition, myThenFunction, myElseFunction).get();
```

### Executing functions on map entries

Functions can be executed on entire map entries.

These functions can return `Map.Entry<K,V>` objects as well, in which case the target object will be still considered a map:

```java
Map<String,String> map = ...;
IFunction<Map.Entry<String,String>,Map.Entry<String,String>> myFunction = ...;
Map<String,String> newMap = 
    Op.on(map).forEachEntry().execAsMapEntry(myFunction).get();
```

...or they can return something different from a map entry, in which case the target object will be considered a List from then on:

```java
Map<String,String> map = ...;
IFunction<Map.Entry<String,String>,Integer> myFunction = ...;
List<Integer> newList = 
    Op.on(map).forEachEntry().exec(myFunction).get();
```

### Executing functions on the whole map

If a map has not been iterated (`forEachEntry()`) (or it has, but `endFor()` has been called), functions can be executed on the whole map.

There are three ways of executing functions on a map as a whole:

- Executions which return a map (example: `Map<String,String>` -> `Map<String,Integer>`)
- Executions which do not return a map (example: `Map<String,String>` -> `Calendar`)

#### Returning a map

Functions will be executed using the `execAsMap(...)` action:

```java
Map<String,String> map = ...;
IFunction<Map<String,String>,Map<String,Integer>> myFunction = ...;
Op.on(map).execAsMap(myFunction)...
```

A conditional check can be added (null, not null, condition true, condition false):

```java
Map<String,String> map = ...;
IFunction<Map<String,String>,Map<String,Integer>> myFunction = ...;
Op.on(map).execIfNotNullAsMap(myFunction)...
```

#### Not returning a map

```java
Map<String,String> map = ...;
IFunction<Map<String,String>,Calendar> myFunction = ...;
Calendar calendar = Op.on(map).exec(myFunction).get();
```

---

## 6. Selecting (conditional code)

op4j allows the conditional execution of actions. Once the condition (an action starting with `"if"`) is executed, all subsequent actions will apply only on the selected parts of the target object.

For example, lets convert into upper case only the first String key of the map:

```java
Map<String,String> map = ...;
Map<String> newMap = Op.on(map).forEachEntry().ifIndex(0).onKey().exec(FnString.toUpperCase()).get();
```

Selections can be ended with `endIf(...)`:

```java
Map<String> newMap =  
    Op.on(map).forEachEntry().ifIndex(0,1,3).[ACTIONS ON SELECTED ENTRIES].endIf()...
```

### Selecting specific map keys/values

If a selection is executed after `forEachEntry().onKey()` or `forEachEntry().onValue()`, it will be applied on the map keys or values, respectively.

Selection can be based on the nullity of the element:

```java
Op.on(map).forEachEntry().onValue().ifNull()....
Op.on(map).forEachEntry().onValue().ifNotNull()....
```

And also on the value returned by the evaluation of a function returning `Boolean`:

```java
Map<String,String> map = ...;
IFunction<String,Boolean> eval = ...;
Op.on(map).forEachEntry().onValue().ifTrue(eval)...
Op.on(map).forEachEntry().onValue().ifFalse(eval)...
```

### Selecting specific map entries

If a selection is executed after a `forEachEntry()` action without `onKey()` or `onValue()` being executed, it will be applied on the map entries.

Selection can be done on the entry's position in the map:

```java
Op.on(map).forEachEntry().ifIndex(0,2,3)....
Op.on(map).forEachEntry().ifIndexNot(0,1,5)....
```

...on the value of its key:

```java
Op.on(map).forEachEntry().ifKeyEquals("a key", "another key")....
Op.on(map).forEachEntry().ifKeyNotEquals("a key", "another key")....
```

And also on the value returned by the evaluation of a function returning `Boolean`:

```java
Map<String,String> map = ...;
IFunction<Map.Entry<String,String>,Boolean> eval = ...;
Op.on(map).forEachEntry().ifTrue(eval)...
Op.on(map).forEachEntry().ifFalse(eval)...
```

### Selecting the map as a whole

Selection can also be performed on the map itself as a whole, effectively deciding whether subsequent actions will be executed at all or not.

```java
Map<String,String> map = ...;
IFunction<Map<String,String>,Boolean> eval = ...;
Op.on(map).ifNull()....
Op.on(map).ifNotNull()....
Op.on(map).ifTrue(eval)...
Op.on(map).ifFalse(eval)...
```

### Restrictions on execution actions after selection

After executing a selection action, function executed by means of an `exec` action cannot change the map key and/or value types (i.e., a `Map<String,String>` must remain `Map<String,String>`).

So this would not be valid:

```java
// Will not compile!
Map<String,String> newMap = 
    Op.on(map).forEachEntry().ifIndex(0,1,3).onKey().exec(FnString.toInteger()).get();
```

...because converting only some of the map keys to integer would render the map type inconsistent (some elements would be `String`, some other `Integer`).

This is perfectly valid, though:

```java
// FnString.toUpperCase is IFunction<String,String>
Map<String,String> newMap = 
    Op.on(map).forEachEntry().ifIndex(0,1,3).onKey().exec(FnString.toUpperCase()).get();
```

---

## 7. Replacing

Map keys, values, entries or even the map itself can be replaced by other objects:

```java
Map<String,String> newMap = 
    Op.on(map).forEachEntry().onValue().ifNull().replaceWith("[no value]").get();
```

...which is equivalent to:

```java
Map<String,String> newMap = 
    Op.on(map).forEachEntry().onValue().replaceIfNullWith("[no value]").get();
```

---

## 8. Reversing

Maps can be reversed, so that the order of its entries gets inverted:

```java
// map = {{"a"=1},{"b"=2},{"c"=3}}
// newMap = {{"c"=3},{"b"=2},{"a"=1}}
Map<String,Integer> newMap = Op.on(map).reverse().get();
```
