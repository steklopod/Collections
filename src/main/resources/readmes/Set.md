## Типаж Set (множество/набор)

**Set** - это коллекция, которая не содержат повторяющихся элементов. Операции подразделяются на следующие категории:

* **Тесты**: `contains`, `apply`, `subsetOf`. Метод `contains` спрашивает, содержит ли набор данный элемент. Метод `apply`
 для набора такой же, как и `contains`, поэтому запись `set(elem)` эквивалентна  `set contains elem`. Это означает, что наборы 
 также могут использоваться в качестве тестовых функций, возвращающих `true` для элементов, которые они содержат.

```scala 
    scala> val fruit = Set("apple", "orange", "peach", "banana")
    fruit: scala.collection.immutable.Set[java.lang.String] = Set(apple, orange, peach, banana)
    scala> fruit("peach")
    res0: Boolean = true
    scala> fruit("potato")
    res1: Boolean = false
```

_Если этот проект окажется полезным тебе - нажми на кнопочку **`★`** в правом верхнем углу._

* [=> Типаж Seq](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Map.md)

[<= содержание](https://github.com/steklopod/Collections/blob/master/readme.md)