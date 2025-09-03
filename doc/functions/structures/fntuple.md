# Functions: FnTuple

## 1. Overview

[`FnTuple`](http://www.op4j.org/apidocs/org/op4j/functions/FnTuple.html) is a *function hub class* containing methods to work with tuples in op4j (pairs, triplets, etc.). It allows the creation of tuples from n input functions (where n may be two, three, etc., depending on the tuple type) and provides utility functions to check if a tuple contains an object, extract data from a tuple, and more.

Tuple objects created belong to the JavaTuples open source project. See [JavaTuples](http://javatuples.org/) for further information.

## 2. Functions

| Function name     | Type                                      | Params                                                                 | Description |
|------------------|--------------------------------------------|------------------------------------------------------------------------|-------------|
| contains         | Function<X,Boolean>                        | Object value                                                           |             |
| containsAll      | Function<X,Boolean>                        | Collection<?> collection                                               |             |
| containsAll      | Function<X,Boolean>                        | Object... values                                                       |             |
| decadeWith       | Function<X,Decade<A,B,C,D,E,F,G,H,I,J>>    | Function<? super X,A> value0Function<br>Function<? super X,B> value1Function<br>Function<? super X,C> value2Function<br>Function<? super X,D> value3Function<br>Function<? super X,E> value4Function<br>Function<? super X,F> value5Function<br>Function<? super X,G> value6Function<br>Function<? super X,H> value7Function<br>Function<? super X,I> value8Function<br>Function<? super X,J> value9Function |             |
| enneadWith       | Function<X,Ennead<A,B,C,D,E,F,G,H,I>>      | Function<? super X,A> value0Function<br>Function<? super X,B> value1Function<br>Function<? super X,C> value2Function<br>Function<? super X,D> value3Function<br>Function<? super X,E> value4Function<br>Function<? super X,F> value5Function<br>Function<? super X,G> value6Function<br>Function<? super X,H> value7Function<br>Function<? super X,I> value8Function |             |
| getKeyOf         | <Y,X extends IValueKey<Y>> Function<X,Y>   | Type<Y> type                                                          |             |
| getLabelOf       | <Y,X extends IValueLabel<Y>> Function<X,Y> | Type<Y> type                                                          |             |
| getSize          | Function<X,Integer>                        |                                                                        |             |
| getValue0Of      | <Y,X extends IValue0<Y>> Function<X,Y>     | Type<Y> type                                                          |             |
| getValue1Of      | <Y,X extends IValue1<Y>> Function<X,Y>     | Type<Y> type                                                          |             |
| getValue2Of      | <Y,X extends IValue2<Y>> Function<X,Y>     | Type<Y> type                                                          |             |
| getValue3Of      | <Y,X extends IValue3<Y>> Function<X,Y>     | Type<Y> type                                                          |             |
| getValue4Of      | <Y,X extends IValue4<Y>> Function<X,Y>     | Type<Y> type                                                          |             |
| getValue5Of      | <Y,X extends IValue5<Y>> Function<X,Y>     | Type<Y> type                                                          |             |
| getValue6Of      | <Y,X extends IValue6<Y>> Function<X,Y>     | Type<Y> type                                                          |             |
| getValue7Of      | <Y,X extends IValue7<Y>> Function<X,Y>     | Type<Y> type                                                          |             |
| getValue8Of      | <Y,X extends IValue8<Y>> Function<X,Y>     | Type<Y> type                                                          |             |
| getValue9Of      | <Y,X extends IValue9<Y>> Function<X,Y>     | Type<Y> type                                                          |             |
| getValueOf       | <Y,X extends IValueValue<Y>> Function<X,Y> | Type<Y> type                                                          |             |
| keyValueWith     | Function<X,KeyValue<A,B>>                  | Function<? super X,A> value0Function<br>Function<? super X,B> value1Function |             |
| labelValueWith   | Function<X,LabelValue<A,B>>                | Function<? super X,A> value0Function<br>Function<? super X,B> value1Function |             |
| octetWith        | Function<X,Octet<A,B,C,D,E,F,G,H>>         | Function<? super X,A> value0Function<br>Function<? super X,B> value1Function<br>Function<? super X,C> value2Function<br>Function<? super X,D> value3Function<br>Function<? super X,E> value4Function<br>Function<? super X,F> value5Function<br>Function<? super X,G> value6Function<br>Function<? super X,H> value7Function |             |
| pairWith         | Function<X,Pair<A,B>>                      | Function<? super X,A> value0Function<br>Function<? super X,B> value1Function |             |
| quartetWith      | Function<X,Quartet<A,B,C,D>>               | Function<? super X,A> value0Function<br>Function<? super X,B> value1Function<br>Function<? super X,C> value2Function<br>Function<? super X,D> value3Function |             |
| quintetWith      | Function<X,Quintet<A,B,C,D,E>>             | Function<? super X,A> value0Function<br>Function<? super X,B> value1Function<br>Function<? super X,C> value2Function<br>Function<? super X,D> value3Function<br>Function<? super X,E> value4Function |             |
| septetWith       | Function<X,Septet<A,B,C,D,E,F,G>>          | Function<? super X,A> value0Function<br>Function<? super X,B> value1Function<br>Function<? super X,C> value2Function<br>Function<? super X,D> value3Function<br>Function<? super X,E> value4Function<br>Function<? super X,F> value5Function<br>Function<? super X,G> value6Function |             |
| sextetWith       | Function<X,Sextet<A,B,C,D,E,F>>            | Function<? super X,A> value0Function<br>Function<? super X,B> value1Function<br>Function<? super X,C> value2Function<br>Function<? super X,D> value3Function<br>Function<? super X,E> value4Function<br>Function<? super X,F> value5Function |             |
| toArray          | Function<X,Object[]>                       |                                                                        |             |
| toList           | Function<X,List<Object>>                    |                                                                        |             |
| tripletWith      | Function<X,Triplet<A,B,C>>                 | Function<? super X,A> value0Function<br>Function<? super X,B> value1Function<br>Function<? super X,C> value2Function |             |
| unitWith         | Function<X,Unit<A>>                        | Function<? super X,A> value0Function                                   |             |

---

For more details and usage examples, refer to the [op4j FnTuple API documentation](http://www.op4j.org/apidocs/org/op4j/functions/FnTuple.html) and the [JavaTuples project](http://javatuples.org/).
