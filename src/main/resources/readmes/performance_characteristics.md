## Характеристики производительности коллекций

> _Проблема_: при выборе коллекции для приложения, где производительность чрезвычайно важна, вы хотите выбрать нужную коллекцию Scala 
для своего алгоритма.

Во многих случаях вы можете рассуждать о производительности коллекции, понимая ее базовую структуру. Например, `List` 
является односвязным списком. Он не индексируется, поэтому, если вам нужно получить доступ к миллионному 
элементу списка `List(1000000)`, это будет медленнее, чем доступ к одному миллионному элементу `Array`, потому что массив 
индексируется, тогда как доступ к элементу в в списке требуется пройти 999999 элементов, прежде чем перейти к последнему. 
В других случаях можете посмотреть на таблицы. Например, можно увидеть, что операция «добавления» (`append`)
в векторе - это `eC`, «эффективное постоянное время». В результате я знаю, что могу очень быстро создать большой `Vector` в 
REPL следующим образом:

```scala
    var v = Vector[Int]()
    for (i <- 1 to 50000) v = v :+ i
```

Однако, как показывает таблица, операция «добавить» (`append`) в списке требует линейного времени, поэтому попытка создания 
списка такого же размера занимает много (очень!) времени.

Перед рассмотрением производительности в таблице показаны **рабочие характеристики**, которые используются в последующих таблицах.

![alt text](https://github.com/steklopod/Collections/blob/master/src/main/resources/images/disclamer_for_perfomance.png "Performance characteristics keys")

#### Характеристики производительности для операций с неизменяемыми и изменяемыми последовательностями

Таблица показывает характеристики производительности для операций с неизменяемыми и изменяемыми **последовательными** коллекциями.

> Характеристики производительности для последовательных коллекций:

![alt text](https://github.com/steklopod/Collections/blob/master/src/main/resources/images/seq_perfomance.png "Performance of seq")

> Тип операций над последовательностями (Sequence operations):

![alt text](https://github.com/steklopod/Collections/blob/master/src/main/resources/images/perfomance_descr.png "Perfomance description")

### Отображения и  множества

> Характеристики производительности для отображений и наборов (Maps & Sets):

![alt text](https://github.com/steklopod/Collections/blob/master/src/main/resources/images/map_operations_perfomance.png "The performance characteristics for maps and sets")

> Тип операций над отображениями и множествами:

![alt text](https://github.com/steklopod/Collections/blob/master/src/main/resources/images/Descriptions_of_the_column_headings.png "Descriptions of the column headings")


_Если этот проект окажется полезным тебе - нажми на кнопочку **`★`** в правом верхнем углу._

[<= содержание](https://github.com/steklopod/Collections/blob/master/readme.md)