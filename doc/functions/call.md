# Functions: Call

## Overview

`org.op4j.functions.Call` is a special functions class which allows the execution of a method in the target object.

Here is an example: Imagine your application has a `User` class which contains a `getName()` method, returning a String. Let's get the names of all the users in a list:

```java
List<User> users = ...;
List<String> userNames = Op.on(users).map(Call.methodForString("getName")).get();
```

The `methodForX(...)` methods in the `Call` class return the following functions:

| Method                              | Returned function type                      |
|--------------------------------------|---------------------------------------------|
| `methodForBigDecimal(...)`           | `Function<Object,BigDecimal>`               |
| `methodForBigInteger(...)`           | `Function<Object,BigInteger>`               |
| `methodForBoolean(...)`              | `Function<Object,Boolean>`                  |
| `methodForByte(...)`                 | `Function<Object,Byte>`                     |
| `methodForCalendar(...)`             | `Function<Object,Calendar>`                 |
| `methodForCharacter(...)`            | `Function<Object,Character>`                |
| `methodForDate(...)`                 | `Function<Object,Date>`                     |
| `methodForDouble(...)`               | `Function<Object,Double>`                   |
| `methodForFloat(...)`                | `Function<Object,Float>`                    |
| `methodForInteger(...)`              | `Function<Object,Integer>`                  |
| `methodForLong(...)`                 | `Function<Object,Long>`                     |
| `methodForObject(...)`               | `Function<Object,Object>`                   |
| `methodForShort(...)`                | `Function<Object,Short>`                    |
| `methodForString(...)`               | `Function<Object,String>`                   |
| `methodFor(Type<T>,...)`             | `Function<Object,T>`                        |
| `methodForArrayOf(Type<T>,...)`      | `Function<Object,T[]>`                      |
| `methodForArrayOfString(...)`        | `Function<Object,String[]>`                 |
| `methodForListOf(Type<T>,...)`       | `Function<Object,List<T>>`                  |
| `methodForListOfString(...)`         | `Function<Object,List<String>>`             |
| `methodForSetOf(Type<T>,...)`        | `Function<Object,Set<T>>`                   |
| `methodForSetOfString(...)`          | `Function<Object,Set<String>>`              |

There also exist more convenient abbreviated methods, which are:

| Method                  | Returned function type                  |
|-------------------------|-----------------------------------------|
| `bigDecimal(...)`       | `Function<Object,BigDecimal>`           |
| `bigInteger(...)`       | `Function<Object,BigInteger>`           |
| `bool(...)`             | `Function<Object,Boolean>`              |
| `calendar(...)`         | `Function<Object,Calendar>`             |
| `c(...)`                | `Function<Object,Character>`            |
| `date(...)`             | `Function<Object,Date>`                 |
| `d(...)`                | `Function<Object,Double>`               |
| `f(...)`                | `Function<Object,Float>`                |
| `i(...)`                | `Function<Object,Integer>`              |
| `l(...)`                | `Function<Object,Long>`                 |
| `obj(...)`              | `Function<Object,Object>`               |
| `shr(...)`              | `Function<Object,Short>`                |
| `s(...)`                | `Function<Object,String>`               |
| `obj(Type<T>,...)`      | `Function<Object,T>`                    |
| `arrayOf(Type<T>)`      | `Function<Object,T[]>`                  |
| `arrayOfString()`       | `Function<Object,String[]>`             |
| `listOf(Type<T>)`       | `Function<Object,List<T>>`              |
| `listOfString()`        | `Function<Object,List<String>>`         |
| `setOf(Type<T>)`        | `Function<Object,Set<T>>`               |
| `setOfString()`         | `Function<Object,Set<String>>`          |

Every `methodForX(...)` or abbreviated method can be passed parameters, and these have to correspond with the parameters of the method being called.

Example:

```java
List<User> users = ...;
Group group = ...;
...
List<User> usersInGroup = 
    Op.on(users).removeAllFalse(Call.bool("isInGroup", group)).get();
```