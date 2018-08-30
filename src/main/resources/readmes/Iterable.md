## Типаж Iterable

![alt text](https://github.com/steklopod/Collections/blob/master/src/main/resources/images/trait_iterable.png "trait Iterable")

Следующий типаж (trait) сверху в иерархии коллекций - `Iterable`. Все методы в этом типаже определяются в терминах 
абстрактного метода, `iterator`, который "обходит" элементы коллекции один за другим. Метод `foreach` из `trait Traversable`
 реализуется в `Iterable` с точки зрения `iterator`. Вот фактическая реализация:

```scala
    def foreach[U](f: Elem => U): Unit = {
      val it = iterator
      while (it.hasNext) f(it.next())
    }
```

Довольно много подклассов `Iterable` переопределяют эту стандартную реализацию `foreach` в `Iterable`, потому что они 
могут обеспечить более эффективную реализацию. Помните, что `foreach` является основой для реализации всех операций в 
`Traversable`, поэтому его производительность имеет значение.

В `Iterable` существует еще два метода, возвращающих итераторы: `grouped` и `sliding`. Однако эти итераторы не возвращают
 отдельные элементы, а целые подпоследовательности элементов исходной коллекции. Максимальный размер этих 
 подпоследовательностей приведен в качестве аргумента для этих методов. Сгруппированный метод возвращает свои элементы 
 в «фрагментированных (chunked)» приращениях, где `sliding` дает скользящее «окно» над элементами. Разница между ними 
 должна стать ясной, если посмотреть на следующее взаимодействие REPL:
 
 ```scala
    scala> val xs = List(1, 2, 3, 4, 5)
      xs: List[Int] = List(1, 2, 3, 4, 5)
    scala> val git = xs grouped 3
      git: Iterator[List[Int]] = non-empty iterator
    scala> git.next()
      res3: List[Int] = List(1, 2, 3)
    scala> git.next()
      res4: List[Int] = List(4, 5)
    scala> val sit = xs sliding 3
      sit: Iterator[List[Int]] = non-empty iterator
    scala> sit.next()
      res5: List[Int] = List(1, 2, 3)
    scala> sit.next()
      res6: List[Int] = List(2, 3, 4)
    scala> sit.next()
      res7: List[Int] = List(3, 4, 5)
 ```
 
 `trait Iterable` также добавляет некоторые другие методы в `Traversable`, которые могут быть эффективно реализованы, 
 только если доступен итератор. Они приведены в следующей таблице.
 
Метод                     | Что делает          
------------------------- | --------------------
**Абстрактный метод**     |
`xs.iterator`             | Итератор, который дает каждый элемент в `xs`, в том же порядке, что и `foreach`.
**Другие итераторы**      |
`xs grouped size`         | Итератор, который дает фиксированные «куски (chunks)» этой коллекции.
`xs sliding size`         | Итератор, который дает скользящее фиксированное окно элементов в этой коллекции.
**Подколлекции**          |
`xs takeRight n`          | Коллекция, состоящая из последних `n` элементов `xs` (или некоторых произвольных `n` элементов, если не задан порядок).
`xs dropRight n`          | Остальная часть коллекции, кроме xs takeRight n.
**Молнии-застежки(Zippers)**   | _данный перевод позволяет лучше понять суть функций `zip`_
`xs zip ys`                    | Итерабельность пар соответствующих элементов из `xs` и `ys`.
`xs zipAll (ys, x, y)`         | Итерабельность пар соответствующих элементов из `xs` и `ys`, где более короткая последовательность расширяется, чтобы соответствовать более длинной, добавляя элементы `x` или `y`.
`xs.zipWithIndex`              | Итерабельность пар элементов из `xs` с их индексами.
**Сравнения**       | 
`xs sameElements ys`| Проверка того, содержат ли xs и ys одни и те же элементы в одном порядке

В иерархии наследования `ниже Iterable` вы найдете три типажа: [Seq](https://www.scala-lang.org/api/current/scala/collection/Seq.html),
 [Set](https://www.scala-lang.org/api/current/scala/collection/Set.html) и 
 [Map](https://www.scala-lang.org/api/current/scala/collection/Map.html). `Seq и Map` реализуют свойство 
[PartialFunction](https://www.scala-lang.org/api/current/scala/PartialFunction.html) с помощью методов `apply` и `isDefinedAt`, каждый из которых выполняется по-разному. `Set` получает 
свой `apply-метод` применения из [GenSetLike](https://www.scala-lang.org/api/current/scala/collection/GenSetLike.html).

Для последовательностей (Seq) `apply` - это позиционная индексация, где элементы всегда нумеруются от `0`. 
То есть `Seq(1, 2, 3)(1)` дает `2`. Для множеств(Set)  `apply` - это тест принадлежности. 
Например, `Set('a', 'b', 'c')('b')` дает `true`, тогда как `Set()('a')` дает `false`. 
Наконец, для отображений (Map) `apply` - это выбор. Например, `Map('a'->1, 'b'->10, 'c'->100)('b')` дает `10`.

_Если этот проект окажется полезным тебе - нажми на кнопочку `star` в правом верхнем углу._

[<= содержание](https://github.com/steklopod/Collections/blob/master/readme.md)