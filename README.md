
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
  <groupId>io.arxila.op4j</groupId>
  <artifactId>op4j</artifactId>
  <version>{version}</version>
</dependency>
```


