## Стеки и очереди

### Неизменяемые стеки

Если вам нужна последовательность вида "последний пришел - первый ушел", вы можете использовать [Stack](http://www.scala-lang.org/api/2.12.2/scala/collection/immutable/Stack.html).
 Вы добавляете элемент на стек с помощью `push`, изымаете элемент с помощью `pop` и берете сверху стека, не удаляя его с помощью
  `top`. Сложность всех этих операций составляет константное время.

```scala
    scala> val stack = scala.collection.immutable.Stack.empty
    stack: scala.collection.immutable.Stack[Nothing] = Stack()
    scala> val hasOne = stack.push(1)
    hasOne: scala.collection.immutable.Stack[Int] = Stack(1)
    scala> stack
    stack: scala.collection.immutable.Stack[Nothing] = Stack()
    scala> hasOne.top
    res20: Int = 1
    scala> hasOne.pop
    res19: scala.collection.immutable.Stack[Int] = Stack()
```
Неизменяемые стеки редко используются в программах Скала, потому что их функциональность включена в списки: `push` в 
неизменяемом стеке совпадает с именем `::` в списке, а `pop` в стеке совпадает с `tail` в списке.

### Неизменяемые очереди
[Очередь (Queue)](http://www.scala-lang.org/api/2.12.2/scala/collection/immutable/Queue.html) похожа на стек, за исключением 
того, что она ее структура данных имеет вид "первый пришел - первый ушел", а "последний пришел - первый ушел".

```scala
    scala> val empty = scala.collection.immutable.Queue[Int]()
    empty: scala.collection.immutable.Queue[Int] = Queue()
```

Вы можете добавить элемент в неизменяемую очередь с `enqueue`:

```scala
    scala> val has1 = empty.enqueue(1)
    has1: scala.collection.immutable.Queue[Int] = Queue(1)
```

Чтобы добавить несколько элементов в очередь, вызовите `enqueue` с коллекцией в качестве аргумента:

```scala
    scala> val has123 = has1.enqueue(List(2, 3))
    has123: scala.collection.immutable.Queue[Int]
      = Queue(1, 2, 3)
```

Чтобы удалить элемент из головы очереди - используйте `dequeue`:

```scala
    scala> val (element, has23) = has123.dequeue
    element: Int = 1
    has23: scala.collection.immutable.Queue[Int] = Queue(2, 3)
```

Обратите внимание, что **`dequeue` возвращает пару**, состоящую из удаляемого элемента и остальной части очереди.


_Если этот проект окажется полезным тебе - нажми на кнопочку **`★`** в правом верхнем углу._

[=> Диапозоны](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Concrete-Ranges.md)

[<= содержание](https://github.com/steklopod/Collections/blob/master/readme.md)

