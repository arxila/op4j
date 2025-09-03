
> [!NOTE]
> A note from the author:
> 
> The op4j library was developed and published in 2010. However, lambdas, streams and other Java features that
> came with Java 8 in 2014, as well as other features of more modern versions, made this library obsolete. The
> library previously existed as `org.op4j` packages in the [op4j](https://github.com/op4j) GitHub organization but was moved to be
> under the Arxila OSS _umbrella_ in order to group it with other small projects created by [@danielfernandez](https://github.com/danielfernandez).
> 
> This library is no longer maintained (please use JDK lambdas and collection streams instead), but it is kept here
> for historical reference. A lot of effort went into it back in the day, and I wouldn't want to just delete
> it. Please look at it the same way you would look at an artifact in a museum. :)



op4j
====

op4j is a developer happiness tool. It is a Java library aimed at improving the quality, semantics, cleanness 
and readability of Java code, especially auxiliary code like data conversion, structure iteration, filtering,
mapping, etc.

op4j is a powerful implementation of the _Fluent Interface_ code style. It allows you to create chained expressions
which apply both predefined or user-defined functions to your objects in a fluid and readable way. This improves
the way your code looks and greatly reduces the complexity of executing auxiliary low-level tasks in the highly
bureaucratic, statically -and strongly- typed language that Java is.

But also, op4j is a large repository of several hundred functions with more than one thousand different
parameters ready to be used in your expressions. From regular expression matching on Strings to locale-savvy number
conversion, to easy Calendar creation. Check the FnX function hub classes online documentation to know more.

op4j is open-source and distributed under the **Apache License 2.0**.



Requirements
------------

op4j requires **Java 5**.



Maven Info
----------

Library dependency: `io.arxila.op4j:op4j:{version}`

From Maven:

```xml
<dependency>
  <groupId>io.arxila.op4j</groupId>
  <artifactId>op4j</artifactId>
  <version>{version}</version>
</dependency>
```


Overview
--------

Let's see an example of an op4j *operation expression*.

op4j operation expressions usually start with `Op.on(...)` (you can read it as *"operate on"*) specifying the object on  
which op4j will operate, and end with `.get()`, which effectively executes the defined expression and returns the
result. Let's see an example:

Let's convert a `List<String>` into an (ordered) `Set<String>`:

```java
// Without op4j
Set<String> set = new LinkedHashSet<String>(list);

// With op4j
Set<String> set = Op.on(list).toSet().get();
```

Ok, op4j code here was a little bit more readable than "normal" java code... but what if all those  
Strings were dates in the `dd/MM/yyyy` format, and we wanted to convert them into `java.util.Calendar` objects?

Let's iterate the newly created set and execute one of op4j's more than 200 predefined  
functions on each of the set's elements...

```java
Set<Calendar> set = 
    Op.on(list).toSet().forEach().exec(FnString.toCalendar("dd/MM/yyyy")).get();
```

That was cool. But unfortunately, it seems that some of those Strings could be null, and we don't want  
nulls to be included in the final result, so let's remove them before executing the conversion...

```java
Set<Calendar> set = 
    Op.on(list).toSet().removeAllNull().forEach().exec(FnString.toCalendar("dd/MM/yyyy")).get();
```

And a `forEach().exec()` (= *execute on each*) operation is what is usually called a *"map"* operation  
(in fact `map()` is a `forEach().exec().endFor()`), so why not use that more suitable name?

```java
Set<Calendar> set = 
    Op.on(list).toSet().removeAllNull().map(FnString.toCalendar("dd/MM/yyyy")).get();
```

And we can go a little bit further because we don't want dates in the future, only the past ones,  
and so we will reposition that `removeAllNull()` operation after the `map` operation (conversion will not affect nulls)  
and extend it with a boolean condition (a function returning a boolean) to remove future dates:

```java
Calendar now = Calendar.getInstance();
Set<Calendar> set = 
    Op.on(list).toSet().map(FnString.toCalendar("dd/MM/yyyy")).removeAllNullOrTrue(FnCalendar.after(now)).get();
```

Wow! this looks great. There is no need to compare with "normal" java code, right?... but let's do it anyway ;-)

```java
// ****************************
// WARNING: Non-op4j code!!
// ****************************
Calendar now = Calendar.getInstance();
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
Set<Calendar> set = new LinkedHashSet<Calendar>();
for (String element : list) {
  if (element != null) {
      try {
          date = dateFormat1.parse(element);
      } catch (ParseException e) {
          throw new SomeException(e);
      }
      Calendar calendar = Calendar.getInstance();
      calendar.setTimeInMillis(date.getTime());
      if (!calendar.after(now)) {
          set.add(calendar);
      }
  }
}
```

And the above isn't even application logic, it's just auxiliary code for converting and filtering  
a list of String dates.  It has turned into a lot of complex and hard-to-understand code, probably  
bigger and uglier than the (much more important) application logic that may surround it.

Output will be exactly the same for both fragments of code. Given:

```java
List<String> list = ["12/10/1492", "6/12/1978", "15/07/2045", null]
```

...both will return:

```java
Set<Calendar> set = [Calendar(12 October 1492), Calendar(6 December 1978)]
```

### Making it last: turning expressions into functions

What if we didn't really want to execute our date handling expression right there, but rather just define it  
and _store_ it somewhere for later use (similar -just similar- to what you'd achieve with a closure)?

Well, then instead of our `Op.on(...)` we can create an equivalent  
`Fn.on(...)` expression with exactly the same structure, and when executing `.get()` we will  
obtain an executable `Function<List<String>,Set<Calendar>>` object (read it  
as _"Function that receives a List of String and returns a Set of Calendar"_):

```java
Function<List<String>,Set<Calendar>> dateProcessFunction = 
    Fn.onListOf(Types.STRING).toSet().map(FnString.toCalendar("dd/MM/yyyy")).removeAllNullOrTrue(FnCalendar.after(now)).get();
```

...and then we will be able to use it in an `exec` operation exactly as any other predefined  
(or user-defined) function, like:

```java
List<List<String>> listOfListOfStrings = ...
List<Set<Calendar>> listOfSetOfCalendars =
    Op.on(listOfListOfStrings).forEach().exec(dateProcessFunction).get();
```

... or even directly execute it just like:

```java
Set<Calendar> set = dateProcessFunction.execute(list);
```

Learning more...
----------------

To learn more, have a look at the [documentation folder](/doc).



