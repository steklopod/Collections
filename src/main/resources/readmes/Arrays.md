## Массивы (Arrays)

[Массив](http://www.scala-lang.org/api/2.12.2/scala/Array.html) - это особый вид коллекции в Scala. С одной стороны, 
массивы Scala соответствуют массивам Java. То есть массив Scala `Array[Int]` представлен как Java `int[]`, а `Array[String]` 
представлен как Java `String[]`. Но в то же время массивы Scala предлагают гораздо больше, чем их Java-аналоги. 

* Во-первых, **массивы Scala могут быть обобщенными (generic)**. То есть вы можете иметь `Array[T]`, где `T` - тип типа или 
абстрактный тип. 

* Во-вторых, **массивы Scala совместимы с последовательностями** Scala - вы можете передать `Array[T]`, где требуется `Seq[T]`. 

* Наконец, **массивы Scala также поддерживают все операции последовательности**. Вот пример этого в действии:

```scala
    scala> val a1 = Array(1, 2, 3)
      a1: Array[Int] = Array(1, 2, 3)
    
    scala> val a2 = a1 map (_ * 3)
      a2: Array[Int] = Array(3, 6, 9)
    
    scala> val a3 = a2 filter (_ % 2 != 0)
      a3: Array[Int] = Array(3, 9)
    
    scala> a3.reverse
      res0: Array[Int] = Array(9, 3)
```

>Учитывая, что массивы Scala представлены так же, как массивы Java, как эти дополнительные функции могут поддерживаться в Scala?
 
 _Фактически, ответ на этот вопрос отличается между Scala 2.8 и более ранними версиями. Ранее компилятор Scala несколько 
 «магически» завернул и развернул массивы в объекты `Seq` и из них, когда это требуется в процессе, называемом упаковкой (boxing)
  и распаковкой (unboxing). Детали этого были довольно сложными, в частности, когда был создан новый массив массивного 
  типа `Array[T]`. Были некоторые загадочные угловые случаи, и производительность операций с массивами была не такой предсказуемой._

Дизайн Scala 2.8 намного проще. Почти вся магия компилятора исчезла. Вместо этого реализация массива Scala 2.8 обеспечивает
 систематическое использование неявных преобразований. В Scala 2.8 массив не претендует на последовательность. На самом 
 деле не может быть так, потому что представление типа данных собственного массива не является подтипом `Seq`. Вместо 
 этого существует неявное «обертывание» преобразования между массивами и экземплярами класса `scala.collection.mutable.WrappedArray`,
  который является подклассом `Seq`. Здесь вы видите это в действии:
  
```scala
    scala> val seq: Seq[Int] = a1
      seq: Seq[Int] = WrappedArray(1, 2, 3)
    
    scala> val a4: Array[Int] = seq.toArray
      a4: Array[Int] = Array(1, 2, 3)
    
    scala> a1 eq a4
      res1: Boolean = true
```

Взаимодействие выше показывает, что массивы совместимы с последовательностями, потому что существует неявное преобразование 
из массивов в `WrappedArrays`. Чтобы перейти в другую сторону, от `WrappedArray` до массива, вы можете использовать метод 
`toArray`, определенный в `Traversable`. Последняя строка `REPL` выше показывает, что упаковка, а затем развертывание с 
помощью `toArray` дает тот же массив, с которого вы начали.

Существует еще одно неявное преобразование, которое применяется к массивам. Это преобразование просто «добавляет» все 
методы последовательности в массивы, но не превращает массив в последовательность. «Добавление» означает, что массив 
обернут в другой объект типа `ArrayOps`, который поддерживает все методы последовательности. Как правило, этот объект `ArrayOps`
 недолговечен; он обычно будет недоступен после вызова метода последовательности, и его хранилище может быть переработано. 
 Современные виртуальные машины часто избегают создания этого объекта целиком.

Разница между двумя неявными преобразованиями в массивах показана в следующем диалоге REPL:
  
```scala
    scala> val seq: Seq[Int] = a1
      seq: Seq[Int] = WrappedArray(1, 2, 3)
    
    scala> seq.reverse
      res2: Seq[Int] = WrappedArray(3, 2, 1)
    
    scala> val ops: collection.mutable.ArrayOps[Int] = a1
      ops: scala.collection.mutable.ArrayOps[Int] = [I(1, 2, 3)
    
    scala> ops.reverse
      res3: Array[Int] = Array(3, 2, 1)
```

Вы видите, что вызов `reverse` на `seq`, который является `WrappedArray`, снова даст `WrappedArray`. Это логично, потому 
что обернутые массивы - это `Seq`, а вызов `reverse` на любом `Seq` снова даст `Seq`. С другой стороны, вызывать обратное 
значение `ops` класса `ArrayOps` даст `Array`, а не `Seq`.

Пример `ArrayOps` выше был довольно искусственным, предназначенным только для того, чтобы показать разницу с `WrappedArray`. 
Обычно вы никогда не определяете значение класса `ArrayOps`. Вы просто вызываете метод `Seq` в массиве:

```scala
    scala> intArrayOps(a1).reverse
      res5: Array[Int] = Array(3, 2, 1)
```

где `intArrayOps` - это неявное преобразование, которое было вставлено ранее. Возникает вопрос, как компилятор выбрал 
`intArrayOps` над другим неявным преобразованием в `WrappedArray` в строке выше. В конце концов, оба преобразования 
сопоставляют массив с типом, который поддерживает обратный метод, и это то, что указано в указанном входе. Ответ на этот 
вопрос заключается в том, что два неявных преобразования имеют приоритет. Преобразование `ArrayOps` имеет более высокий 
приоритет, чем преобразование `WrappedArray`. Первый определяется в объекте `Predef`, тогда как второй определяется в 
классе `scala.LowPriorityImplicits`, который наследуется `Predef`. Имплициты в подклассах и подобъектах имеют приоритет 
над имплицитами в базовых классах. Поэтому, если оба преобразования применимы, выбирается тот, который выбран в `Predef`.
 Очень похожая схема работает для строк.
 
Итак, теперь вы знаете, как массивы могут быть совместимы с последовательностями и как они могут поддерживать все операции 
последовательности. Как насчет общности? В Java вы не можете записать `T[]`, где `T` - параметр типа. Как же тогда 
представлен массив `Scala[T]`? Фактически, общий массив, такой как `Array[T]`, может быть во время выполнения любого из 
восьми примитивных типов массивов Java `byte[]`, `short[]`, `char[]`, `int[]`, `long[]`, `float[]`, `double[]`, `boolean[]`, 
или это может быть массив объектов. Единственным распространенным типом времени выполнения, охватывающим все эти типы, 
является `AnyRef` (или, что эквивалентно `java.lang.Object`), поэтому это тип, с которым компилятор Scala сопоставляет `Array[T]`.
 Во время выполнения, когда к элементу массива типа `Array[T]` обращаются или обновляются, существует последовательность
  типов тестов, которые определяют фактический тип массива, а затем правильную операцию массива в массиве Java. Эти 
  типовые тесты несколько замедляют работу массива. Вы можете ожидать, что доступ к общим массивам будет в три-четыре 
  раза медленнее, чем доступ к примитивным или объектным массивам. Это означает, что если вам нужна максимальная 
  производительность, вы должны предпочесть конкретный набор общих массивов. Однако представления типичного типа массива 
  недостаточно, но также должен быть способ создания общих массивов. Это еще более сложная проблема, которая требует от 
  вас немного помощи. Чтобы проиллюстрировать эту проблему, рассмотрите следующую попытку написать общий метод, 
  который создает массив.
  
```scala
    // это не верно!
    def evenElems[T](xs: Vector[T]): Array[T] = {
      val arr = new Array[T]((xs.length + 1) / 2)
      for (i <- 0 until xs.length by 2)
        arr(i / 2) = xs(i)
      arr
    }
```
  
Метод `evenElems` возвращает новый массив, состоящий из всех элементов вектора аргументов `xs`, которые находятся в 
четных положениях вектора. Первая строка тела `evenElems` создает массив результатов, который имеет тот же тип элемента, 
что и аргумент. Поэтому в зависимости от фактического параметра типа для `T` это может быть массив `Array[Int]` или 
`Array[Boolean]` или массив некоторых других примитивных типов в Java или массив некоторого ссылочного типа. Но эти типы 
имеют все разные представления времени исполнения, так как время выполнения Scala будет выбирать правильный? Фактически, 
он не может сделать это на основе информации, которую он задает, поскольку фактический тип, соответствующий типу параметра `T`,
 удаляется во время выполнения. Вот почему вы получите следующее сообщение об ошибке, если вы скомпилируете код выше:

```scala
    error: cannot find class manifest for element type T
      val arr = new Array[T]((arr.length + 1) / 2)
                ^
```

Что нужно здесь, так это то, что вы помогаете компилятору, предоставляя некоторую подсказку времени выполнения, каков 
фактический параметр типа `evenElems`. Этот намек времени выполнения принимает форму манифеста класса типа `scala.reflect.ClassTag`.
 Манифестом класса является объект дескриптора типа, который описывает тип класса верхнего уровня. В качестве альтернативы 
 манифестам класса присутствуют также полные проявления типа `scala.reflect.Manifest`, которые описывают все аспекты типа. 
 Но для создания массива нужны только классовые манифесты.

Компилятор Scala автоматически создаст манифесты классов, если вы попросите его сделать это:

```scala
def evenElems[T](xs: Vector[T])(implicit m: ClassTag[T]): Array[T] = ...
```

Используя альтернативный и более короткий синтаксис, вы также можете потребовать, чтобы тип появился с манифестом класса, 
используя привязку к контексту. Это означает, что после типа с двоеточием и именем класса `ClassTag`, например:

```scala
    import scala.reflect.ClassTag
    // это верно
    def evenElems[T: ClassTag](xs: Vector[T]): Array[T] = {
      val arr = new Array[T]((xs.length + 1) / 2)
      for (i <- 0 until xs.length by 2)
        arr(i / 2) = xs(i)
      arr
    }
```

Две пересмотренные версии `evenElems` означают то же самое. Что происходит в любом случае, так это то, что когда `Array[T]` 
строится, компилятор будет искать манифест класса для параметра типа `T`, то есть он будет искать неявное значение типа
 `ClassTag[T]`. Если такое значение найдено, манифест используется для построения правильного типа массива. В противном 
 случае вы увидите сообщение об ошибке, подобное приведенному выше.

Ниже приведено некоторое взаимодействие REPL, в котором используется метод `evenElems`.

```scala
    scala> def wrap[U](xs: Vector[U]) = evenElems(xs)
    
    <console>:6: error: No ClassTag available for U.
         def wrap[U](xs: Vector[U]) = evenElems(xs)
                                               ^
```

Что здесь произошло, так это то, что `evenElems` требует манифест класса для параметра типа `U`, но ни один не найден. 
Решение в этом случае, конечно, требует еще одного неявного манифеста класса для `U`. Таким образом, следующие работы:

```scala
    scala> def wrap[U: ClassTag](xs: Vector[U]) = evenElems(xs)
    
      wrap: [U](xs: Vector[U])(implicit evidence$1: scala.reflect.ClassTag[U])Array[U]
```

Этот пример также показывает, что контекст, связанный в определении `U`, является просто сокращением для неявного параметра, 
названного здесь `evidence$1` типа `ClassTag[U]`.

Таким образом, создание общего массива требует проявления класса. Поэтому всякий раз, когда вы создаете массив параметра 
типа `T`, вам также необходимо предоставить неявный манифест класса для `T`. Самый простой способ сделать это - объявить 
параметр type с привязкой к контексту `ClassTag`, как в `[T: ClassTag]`.



_Если этот проект окажется полезным тебе - нажми на кнопочку **`★`** в правом верхнем углу._

[<= содержание](https://github.com/steklopod/Collections/blob/master/readme.md)