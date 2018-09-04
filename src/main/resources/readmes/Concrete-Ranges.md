## Диапозоны (Ranges)

[Диапазон](http://www.scala-lang.org/api/2.12.2/scala/collection/immutable/Range.html) - это упорядоченная последовательность
 целых чисел, которые расположены на равном расстоянии друг от друга. Например, «1, 2, 3» - это диапазон, как и «5, 8, 11, 14.». 
 Чтобы создать диапазон в Скала, используйте предопределенные методы `to` и `by`.
 
```scala
    scala> 1 to 3
    res2: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3)
    
    scala> 5 to 14 by 3
    res3: scala.collection.immutable.Range = Range(5, 8, 11, 14)
```

Если вы хотите создать диапазон, который не включает его верхний предел - используйте метод `until`, а не `to`:

```scala
   scala> 1 until 3
    res2: scala.collection.immutable.Range = Range(1, 2)
```

Диапазоны представлены в постоянном пространстве, потому что они могут быть определены только тремя числами: 
их началом, их окончанием и степенным значением. Из-за этого представления большинство операций с диапазонами очень быстрые.
 
 
![alt text](https://github.com/steklopod/Collections/blob/master/src/main/resources/images/range.jpg "range")

_Если этот проект окажется полезным тебе - нажми на кнопочку **`★`** в правом верхнем углу._

[<= содержание](https://github.com/steklopod/Collections/blob/master/readme.md)

