## Массивы-Буфферы (Array Buffers)

[ArrayBuffer](http://www.scala-lang.org/api/2.12.2/scala/collection/mutable/ArrayBuffer.html) содержит массив и размер. 
Большинство операций с буфером массива имеют ту же скорость, что и для массива, поскольку операции просто обеспечивают 
доступ и изменение базового массива. Кроме того, массивы-буфферы могут эффективно добавлять данные в конец. При добавлении 
элемента в буфер массива учитывается постоянное время. Таким образом, буферы массивов полезны для эффективного создания 
большой коллекции всякий раз, **когда новые элементы всегда добавляются в конец**.

```scala
    scala> val buf = scala.collection.mutable.ArrayBuffer.empty[Int]
      buf: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
    
    scala> buf += 1
      res32: buf.type = ArrayBuffer(1)
    
    scala> buf += 10
      res33: buf.type = ArrayBuffer(1, 10)
    
    scala> buf.toArray
      res34: Array[Int] = Array(1, 10)
```
> удаление элементов

`ArrayBuffer` - изменяемая последовательность, поэтому вы можете удалять элементы с помощью обычных методов `-=`, `-=`, `remove` и `clear`.

Вы можете удалить один или несколько элементов с помощью: `-=:`

```scala
    import scala.collection.mutable.ArrayBuffer
    
    val x = ArrayBuffer('a', 'b', 'c', 'd', 'e')
    
    // удалить один элемент
    x -= 'a'
    
    // удалить несколько элементов (методы определяют параметр varargs)
    x -= ('b', 'c')
```

Используйте  `-=` чтобы удалить несколько элементов, объявленных в другой коллекции (любая коллекция, которая расширяет 
`TraversableOnce`):

```scala
    val x = ArrayBuffer('a', 'b', 'c', 'd', 'e')
    x --= Seq('a', 'b')
    x --= Array('c')
    x --= Set('d')
```

Используйте метод `remove` для удаления одного элемента по его позиции в массиве `ArrayBuffer` или последовательности 
элементов, начинающихся в исходной позиции:

```scala
    scala> val x = ArrayBuffer('a', 'b', 'c', 'd', 'e', 'f')
    x: scala.collection.mutable.ArrayBuffer[Char] = ArrayBuffer(a, b, c, d, e, f)
    
    scala> x.remove(0)
    res0: Char = a
    
    scala> x
    res1: scala.collection.mutable.ArrayBuffer[Char] = ArrayBuffer(b, c, d, e, f)
    
    scala> x.remove(1, 3)
    
    scala> x
    res2: scala.collection.mutable.ArrayBuffer[Char] = ArrayBuffer(b, f)
```

В этих примерах коллекция, содержащая элементы, подлежащие удалению, может быть любой коллекцией, которая расширяет 
`TraversableOnce`, поэтому `removeThese` может быть `Seq`, `Array`, `Vector` и многими другими типами, которые расширяют.

Открытый метод удаляет все элементы из массива `ArrayBuffer`:

```scala
    scala> var a = ArrayBuffer(1,2,3,4,5)
    a: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, 3, 4, 5)
    
    scala> a.clear
    
    scala> a
    res0: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
```

Вы также можете использовать обычные методы фильтрации Crfkf (drop, filter, take и т.д.) Для фильтрации элементов из коллекции; 
просто не забудьте присвоить результат новой переменной.

## Буфферы-Списки (List Buffers)

[ListBuffer](http://www.scala-lang.org/api/2.12.2/scala/collection/mutable/ListBuffer.html) похож на массив-буфер, за 
исключением того, что он использует связанный список внутри, а не массив. Если вы планируете преобразовать буфер в список 
после его создания, используйте буфер списка вместо буфера массива.

```scala
    scala> val buf = scala.collection.mutable.ListBuffer.empty[Int]
        buf: scala.collection.mutable.ListBuffer[Int] = ListBuffer()
    
    scala> buf += 1
        res35: buf.type = ListBuffer(1)
    
    scala> buf += 10
        res36: buf.type = ListBuffer(1, 10)
    
    scala> buf.toList
        res37: List[Int] = List(1, 10)
```

_Если этот проект окажется полезным тебе - нажми на кнопочку **`★`** в правом верхнем углу._

[<= содержание](https://github.com/steklopod/Collections/blob/master/readme.md)
