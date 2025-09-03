# Functions: FnMap

## 1. Overview

**[FnMap](http://www.op4j.org/apidocs/org/op4j/functions/FnMap.html)** is a *parameterizable function hub class*. Before accessing the real functions, you must specify the type parameter, which gives you access to operations on *Maps*:

- `FnMap.ofIntegerString()` → FnMapOf<Integer, String>
- `FnMap.ofObjectObject()` → FnMapOf<Object, Object>
- `FnMap.ofStringInteger()` → FnMapOf<String, Integer>
- `FnMap.ofStringString()` → FnMapOf<String, String>
- `FnMap.of()` → FnMapOf<K, V>

## FnMapOf

Functions in **FnMapOf** are applied on *Maps*. FnMapOf is parameterizable, so you must specify the type parameter (e.g., `FnMap.ofIntegerString()`, `FnMap.ofStringString()`, `FnMap.of(final Type<K> keyType, final Type<V> valueType)`, ...).

Shortcuts for common classes: `FnMap.ofIntegerString()`, `FnMap.ofObjectObject()`, `FnMap.ofStringInteger()`, `FnMap.ofStringString()`

### Example Usage
```java
// Creates a Map<Integer, String> and removes entries with null value
Op.onMapFor(Integer.valueOf(0), "all").put(Integer.valueOf(1), "first")
    .put(Integer.valueOf(2), null).put(Integer.valueOf(3), "third")
    .exec(FnMap.ofIntegerString().removeAllFalse(
        new IFunction<Map.Entry<Integer, String>, Boolean>() {
            public Boolean execute(Entry<Integer, String> input, ExecCtx ctx) throws Exception {
                return input.getValue() != null;
            }
        })
    ).get();
```

### Functions Table
| Function name           | Type                                      | Params                                   | Description |
|-------------------------|-------------------------------------------|-------------------------------------------|-------------|
| **all**                 | Function<Map<K,V>,Boolean>                 | IFunction<? super Map.Entry<K,V>,Boolean> eval |             |
| **any**                 | Function<Map<K,V>,Boolean>                 | IFunction<? super Map.Entry<K,V>,Boolean> eval |             |
| **containsAllKeys**     | Function<Map<K,V>,Boolean>                 | K... keys                                |             |
| **containsAnyKeys**     | Function<Map<K,V>,Boolean>                 | K... keys                                |             |
| **containsKey**         | Function<Map<K,V>,Boolean>                 | K key                                    |             |
| **containsNoneKeys**    | Function<Map<K,V>,Boolean>                 | K... keys                                |             |
| **count**               | Function<Map<?,?>,Integer>                 |                                           |             |
| **extractKeys**         | Function<Map<K,V>,Set<K>>                  |                                           |             |
| **extractValues**       | Function<Map<K,V>,List<V>>                 |                                           |             |
| **insert**              | Function<Map<K,V>,Map<K,V>>                | int position, K key, V value             |             |
| **insertAll**           | Function<Map<K,V>,Map<K,V>>                | int position, Map<K,V> map               |             |
| **notContainsKey**      | Function<Map<K,V>,Boolean>                 | K key                                    |             |
| **put**                 | Function<Map<K,V>,Map<K,V>>                | K key, V value                           |             |
| **putAll**              | Function<Map<K,V>,Map<K,V>>                | Map<K,V> map                             |             |
| **removeAllFalse**      | Function<Map<K,V>,Map<K,V>>                | IFunction<? super Entry<K,V>,Boolean> eval |            |
| **removeAllKeys**       | Function<Map<K,V>,Map<K,V>>                | K... keys                                |             |
| **removeAllKeysNot**    | Function<Map<K,V>,Map<K,V>>                | K... keys                                |             |
| **removeAllTrue**       | Function<Map<K,V>,Map<K,V>>                | IFunction<? super Entry<K,V>,Boolean> eval |            |
| **reverse**             | Function<Map<K,V>,Map<K,V>>                |                                           |             |
| **sortBy**              | Function<Map<K,V>,Map<K,V>>                | IFunction<? super Map.Entry<K,V>, ?> by  |             |
| **sortByKey**           | Function<Map<K,V>,Map<K,V>>                |                                           |             |
| **sortEntries**         | Function<Map<K,V>,Map<K,V>>                | Comparator<? super Entry<K,V>> comparator |             |
