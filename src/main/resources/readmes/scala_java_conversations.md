## Конверсии между коллекциями java и scala

Подобно Scala, Java также имеет богатую коллекцию библиотек. Между ними много общего. Например, обе библиотеки имеют 
итераторы, наборы, отображения и последовательности. Но есть и важные отличия. В частности, библиотеки Scala уделяют
 гораздо больше внимания неизменным коллекциям и предоставляют гораздо больше операций, которые преобразуют коллекцию в новую.

Иногда вам может потребоваться перейти от одной рамки коллекции к другой. Например, вам может потребоваться доступ к 
существующей коллекции Java, как если бы это была коллекция Scala. Или вы можете передать одну из коллекций Scala в 
Java-метод, ожидающий своего Java-партнера. Это довольно легко сделать, поскольку Scala предлагает неявные преобразования 
между всеми основными типами коллекций в объекте `JavaConverters`. В частности, вы найдете двунаправленные преобразования 
между следующими типами.

```scala
    Iterator               <=>     java.util.Iterator
    Iterator               <=>     java.util.Enumeration
    Iterable               <=>     java.lang.Iterable
    Iterable               <=>     java.util.Collection
    mutable.Buffer         <=>     java.util.List
    mutable.Set            <=>     java.util.Set
    mutable.Map            <=>     java.util.Map
    mutable.ConcurrentMap  <=>     java.util.concurrent.ConcurrentMap
```

Чтобы включить эти преобразования, просто импортируйте их из объекта `JavaConverters`:


```scala
    scala> import collection.JavaConverters._
    import collection.JavaConverters._
```

Это позволит конвертировать между коллекциями Scala и их соответствующими наборами Java посредством методов расширения, 
называемых `asScala` и `asJava`:

```scala
    scala> import collection.mutable._
    import collection.mutable._
    
    scala> val jul: java.util.List[Int] = ArrayBuffer(1, 2, 3).asJava
    jul: java.util.List[Int] = [1, 2, 3]
    
    scala> val buf: Seq[Int] = jul.asScala
    buf: scala.collection.mutable.Seq[Int] = ArrayBuffer(1, 2, 3)
    
    scala> val m: java.util.Map[String, Int] = HashMap("abc" -> 1, "hello" -> 2).asJava
    m: java.util.Map[String,Int] = {abc=1, hello=2}
```

Внутри эти преобразования создавают объект «обертка», который переводит все операции в основной объект коллекции. Таким 
образом, коллекции не копируются при конвертации между Java и Scala. Интересным свойством является то, что если вы 
совершите конверсию в оба конца, скажем, тип Java, соответствующий свой тип Scala, и вернитесь к одному и тому же 
Java-типу, вы получите идентичный объект коллекции, с которого вы начали.

Некоторые другие коллекции Scala также могут быть преобразованы в Java, но не имеют преобразования обратно к исходному типу Scala:

```scala
    Seq           =>    java.util.List
    mutable.Seq   =>    java.util.List
    Set           =>    java.util.Set
    Map           =>    java.util.Map
```

Поскольку Java не различает изменчивые и неизменяемые коллекции в своем типе, преобразование, скажем, 
`scala.immutable.List` даст `java.util.List`, где все операции мутации вызывают «UnsupportedOperationException». Вот пример:

```scala
    scala> val jul = List(1, 2, 3).asJava
    jul: java.util.List[Int] = [1, 2, 3]
    
    scala> jul.add(7)
    java.lang.UnsupportedOperationException
      at java.util.AbstractList.add(AbstractList.java:148)
```

_Если этот проект окажется полезным тебе - нажми на кнопочку **`★`** в правом верхнем углу._

[<= содержание](https://github.com/steklopod/Collections/blob/master/readme.md)