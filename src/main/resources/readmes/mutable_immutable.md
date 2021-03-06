## Изменяемые и неизменяемые коллекции

Коллекции Скала систематически различают `изменяемые` и `неизменяемые коллекции`. _Изменяемае коллекция_ может быть 
обновлена ​​или расширена. Это означает, что вы можете изменять, добавлять или удалять элементы коллекции в качестве 
побочного эффекта. _Неизменяемые коллекции_, напротив, никогда не меняются. У вас все еще есть операции, 
имитирующие дополнения, удаления или обновления, но эти операции в каждом случае **возвращают новую коллекцию** и 
оставляют старую коллекцию неизменной.

Все классы коллекций находятся в пакете **`scala.collection`**. Большинство классов коллекций, требуемых клиентским кодом,
 существуют в трех вариантах, которые расположены в пакетах `scala.collection`, `scala.collection.immutable` и 
 `scala.collection.mutable` соответственно. Каждый вариант имеет разные характеристики в отношении изменчивости.

* Коллекции в пакете `scala.collection.immutable` гарантируют иммутабельность. Такие коллекции никогда не изменятся 
после их создания. Поэтому вы можете положиться на тот факт, что одновременное обращение к одному и тому же набору 
значений в разные моменты времени всегда даст коллекцию с теми же элементами.

* Коллекции в пакете `scala.collection.mutable` имеют операции, которые изменяют коллекцию. 

* Коллекции в пакете `scala.collection` могут быть изменяемыми или неизменяемыми. Например, `collection.IndexedSeq[T]` 
является суперклассом как `collection.immutable.IndexedSeq[T]`, так и `collection.mutable.IndexedSeq[T]`.
 Как правило, корневые коллекции в пакете `scala.collection` определяют тот же интерфейс, что и неизменные коллекции, 
 и изменяемые коллекции в пакете `scala.collection.mutable` обычно добавляют некоторые операции модификации побочных 
 эффектов в этот неизменный интерфейс.

Разница между корневыми коллекциями и неизменяемыми коллекциями заключается в том, что _клиенты неизменяемой коллекции 
имеют гарантию того, что никто не может мутировать коллекцию_, тогда как _клиенты корневой коллекции обещают не менять 
коллекцию самостоятельно_. Несмотря на то, что статический тип такой коллекции не предусматривает операций по изменению 
коллекции, все же возможно, что тип времени выполнения является изменяемой коллекцией, которую могут изменять другие клиенты.

**По умолчанию Скала всегда выбирает неизменные коллекции**. _Например, если вы просто пишете `Set` без какого-либо префикса 
или не импортируете `Set` откуда-то, вы получите неизменяемый набор, и если вы напишете `Iterable`, вы получите 
неизменяемую итеративную коллекцию, потому что это привязки по умолчанию, импортированные из пакета `scala`_. 
Чтобы получить изменчивые версии по умолчанию, вам нужно явно написать `collection.mutable.Set` или `collection.mutable.Iterable`.

Полезным соглашением, если вы хотите использовать как изменяемые, так и неизменные версии коллекций, является импорт 
только пакета `collection.mutable`.

<!-- code -->
```scala
  import scala.collection.mutable
```

`Set` без префикса, по-прежнему относится к неизменяемой коллекции, тогда как `mutable.Set` относится к изменяемой копии.

Последний пакет в иерархии коллекции - `collection.generic`. Этот пакет содержит строительные блоки для реализации коллекций.
 Как правило, классы коллекций откладывают реализацию некоторых из своих операций с классами в общем виде. 
 С другой стороны, пользователям системы сбора данных следует относиться к классам только в исключительных обстоятельствах.

Для удобства и обратной совместимости некоторые важные типы имеют псевдонимы в пакете `scala`, поэтому вы можете 
использовать их своими простыми именами без необходимости импорта. Примером может служить тип `List`, к которому можно 
получить доступ

<!-- code -->
```scala
  scala.collection.immutable.List   // вот где это определено
  scala.List                        // через псевдоним в пакете scala
  List                              // потому что `scala._` is always automatically imported
```

Типажи коллекций в Скала - это `Traversable`, `Iterable`, `Seq`, `IndexedSeq`, `Iterator`, `Stream`, `Vector`, 
`StringBuilder` и `Range`.

На следующей схеме показаны все коллекции в пакете `scala.collection`. Это все абстрактные классы или
 типажи высокого уровня, которые обычно имеют изменяемые, а также неизменяемые реализации.
 >иерархия типажей `scala.collection`
![alt text](https://github.com/steklopod/Collections/blob/master/src/main/resources/images/collections.png "collections")


>Неизменяемын коллекции `scala.collection.immutable`
![alt text](https://github.com/steklopod/Collections/blob/master/src/main/resources/images/collections.immutable.png "collections.immutable")

>Изменяемын коллекции  `scala.collection.mutable`
![alt text](https://github.com/steklopod/Collections/blob/master/src/main/resources/images/collections.mutable.png "collections.mutable")

### Обзор API коллекций

Наиболее важные классы коллекций показаны на рисунках выше. У этих классов довольно много общего. Например, 
каждый вид коллекции может быть создан одним и тем же единообразным синтаксисом, записывая имя класса коллекции, 
за которым следуют его элементы:

<!-- code -->
```scala
  Traversable(1, 2, 3)
  Iterable("x", "y", "z")
  Map("x" -> 24, "y" -> 25, "z" -> 26)
  Set(Color.red, Color.green, Color.blue)
  SortedSet("hello", "world")
  Buffer(x, y, z)
  IndexedSeq(1.0, 2.0)
  LinearSeq(a, b, c)
```

Тот же принцип применим и к конкретным реализациям коллекции, таким как:

<!-- code -->
```scala
    List(1, 2, 3)
    HashMap("x" -> 24, "y" -> 25, "z" -> 26)
```

Все эти коллекции отображаются с помощью `toString` так же, как они написаны выше.

Все коллекции поддерживают API, предоставляемый `Traversable`, но специализируют типы везде, где это имеет смысл. 
Например, метод `map` в классе `Traversable` возвращает в качестве результата другой `Traversable`. Но этот тип 
результата переопределяется в подклассах. Например, при вызове `map` в `List` снова появляется список, вызывающий его 
в `Set`, снова возвращает `Set` и так далее.

<!-- code -->
```scala
    scala> List(1, 2, 3) map (_ + 1)
    res0: List[Int] = List(2, 3, 4)
    scala> Set(1, 2, 3) map (_ * 2)
    res0: Set[Int] = Set(2, 4, 6)
```

Такое поведение, которое реализуется повсеместно в библиотеках коллекций, называется 
`принципом равномерного возврата (uniform return type principle)`.

Большинство классов в иерархии коллекций существуют в трех вариантах: `root`, `mutable` и `immutable`. Единственное исключение
 - это свойство буфера, которое существует только как изменяемая коллекция.

Далее мы рассмотрим эти классы один за другим.

_Если этот проект окажется полезным тебе - нажми на кнопочку **`★`** в правом верхнем углу._

* [=> Типаж Traversable](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Traversable.md)

[<= содержание](https://github.com/steklopod/Collections/blob/master/readme.md)