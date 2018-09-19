# Коллекции в Скала

**Коллекция** – это сущность, которая хранит множество однотипных _(за исключением кортежей, которые позволяют хранить элементы 
разных типов)_ элементов. Также, обеспечивается последовательный или случайный доступ к элементам коллекциям.

![alt text](https://github.com/steklopod/Collections/blob/master/src/main/resources/images/collections.png "collections")

## Содержание:

### 1. Типажи коллекций:

* [Мутабельные и неизменяемые коллекции](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/mutable_immutable.md)

* [Типаж Traversable](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Traversable.md)

* [Типаж Iterable](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Iterable.md)

* [Типаж Seq](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Seq.md)

* [Типаж Set](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Set.md)

* [Типаж Map](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Map.md)

### 2.1 Конкретные неизменяемые классы коллекций (Immutable Collection Classes):

Scala предоставляет множество конкретных неизменяемых классов коллекций на выбор. Они отличаются типажами, которые они 
реализуют (отображения, наборы, последовательности), конечностью и скоростью различных операций. Вот некоторые из наиболее 
распространенных неизменяемых типов коллекций, используемых в Скала:

* [Списки (Lists)](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Concrete-Lists.md)

* [Потоки (Streams)](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Concrete-Streams.md)

* [Векторы (Vectors)](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Concrete-Vectors.md)

* [Стеки и очереди](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Concrete-Stacks_and_Queues.md)

* [Диапозоны (Ranges)](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Concrete-Ranges.md)

* [Хэш-деревья, красно-черные деревья, бинарные множества, отображения-списки](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Concrete-Other_immutables.md)

### 2.2 Конкретные изменяемые классы коллекций (Mmutable Collection Classes):

* [Буфферы](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Concrete-Mutable_Array_Buffers.md)

* [Строковый сборщик (StringBuilder)](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Concrete-Mutable_StringBuilders.md)

* [Списки (Linked Lists, Double Linked Lists, Mutable Lists)](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Concrete-Mutable_Lists.md)

* [Стэк (Stacks)](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Concrete-Stacks.md)

* [Отображения (Weak Hash Maps, Concurrent Maps, Hash Tables)](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Concrete-Mutable-Maps.md)

### 3 Массивы

* [Массивы (Arrays)](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Arrays.md)

### 4 Строки

* [Строки (Strings)](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/Strings.md)

### 5 Характеристики производительности (perfomance)

* [Производительность коллекций](https://github.com/steklopod/Collections/blob/master/src/main/resources/readmes/performance_characteristics.md)


### Характеристики коллеций скала:

**Простота в использовании:** Небольшой лексикон 20-50 методов достаточно для решения большинства проблем. Не нужно 
обертывать голову (head) коллекции вокруг сложных циклов или рекурсий. Стойкие коллекции и `операции без побочных эффектов`
 означают, что вам не нужно беспокоиться о случайном повреждении существующих коллекций новыми данными. 

**Краткость:** вы можете достичь цели одним словом, вместо одного или нескольких циклов. 
Вы можете выразить функциональные операции с легким синтаксисом и объединить операции без особых усилий, чтобы результат 
выглядел как обычная алгебра.

**Безопасность:** статически типизированный и функциональный характер коллекций Скала означает, что подавляющее 
большинство ошибок, которые вы могли бы сделать, будут пойманы во время компиляции. 

**Скорость**: операции сбора настраиваются и оптимизируются в библиотеках. В результате использование коллекций, 
как правило, довольно эффективно. Возможно, вы сможете сделать немного лучше с тщательно обработанными вручную 
структурами данных и операциями, но вы также можете сделать намного хуже, сделав некоторые субоптимальные решения 
по реализации на этом пути. Параллельные коллекции поддерживают те же операции, что и последовательные, поэтому 
 новые операции не нужно изучать, и код не требуется переписывать. Вы можете превратить последовательную коллекцию 
 в параллельную, просто используя метод `par`.

**Универсальность**: Коллекции предоставляют те же операции для любого типа, где это имеет смысл. Таким образом, 
вы можете добиться многого с довольно небольшим лексиконом операций. Например, `строка` является концептуально 
последовательностью `символов`. Следовательно, в коллекциях Скала строки поддерживают все операции последовательности.
 То же самое относится к массивам.

_Пример. Вот одна строка кода, которая демонстрирует многие преимущества коллекций Скала._

<!-- code -->
```scala
  val (несовершеннолетние, взрослые) = люди partition (_.возраст < 18)
  
```

Сразу видно, что делает эта операция: она разбивает коллекцию людей на несовершеннолетних и взрослых в зависимости от 
их возраста. Поскольку метод разделения определен в корневом наборе типа `TraversableLike`, этот код работает для любой 
коллекции, включая массивы. Полученные `коллекции несовершеннолетних и взрослых` будут иметь тот же тип, что и коллекция людей.

Этот код намного более краткий, чем от одной до трех циклов, необходимых для традиционной обработки коллекции 
(три цикла для массива, потому что промежуточные результаты нужно буферизировать где-то в другом месте).
 После того, как вы изучили базовые операции, вы также найдете, что этот код намного проще и безопаснее, чем писать явные циклы. 
**В этом проекте подробно рассматривается API-интерфейс классов коллекций Скала с точки зрения пользователя.** 

![alt text](https://github.com/steklopod/Collections/blob/master/src/main/resources/images/perfomance.png "perfomance")


_Если этот проект окажется полезным тебе - нажми на кнопочку **`★`** в правом верхнем углу._
