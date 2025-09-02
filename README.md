
> [!NOTE]
> A note from the author:
> 
> This library is from 2009/2010. In 2014 Java 8 was released, bringing with it lambdas, streams and
> many other modern Java features that made op4j obsolete. It previously existed as `org.op4j` packages
> in the [op4j](https://github.com/op4j) GitHub organization but has now been moved under the Arxila OSS _umbrella_ 
> in order to keep it near other small projects created by @danielfernandez.
> 
> This library is no longer maintained (please use lambdas and collection streams instead), but it is kept here for
> historical reference. Please look at it the same way you would look at a trilobite in a museum. A lot of effort
> went into it back in the day, and I wouldn't want to just delete it. :)



op4j
====

op4j is a developer happiness tool. It is a Java library aimed at improving quality, semantics, cleanness 
and readability of Java code, especially auxiliary code like data conversion, structure iteration, filtering,
mapping, etc.

op4j is a powerful implementation of the _Fluent Interface_ code style. It allows you to create chained expressions
which apply both predefined or user-defined functions to your objects in a fluid and readable way. This improves
the way your code looks and greatly reduces the complexity of executing auxiliary low-level tasks in the highly
bureaucratic, statically -and strongly- typed language that Java is.

But also, op4j is a huge repository of several hundred functions with more than one thousand different
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
  <groupId>io.arxila.javaruntype</groupId>
  <artifactId>op4j</artifactId>
  <version>{version}</version>
</dependency>
```


