## Стэки (Stacks)

Раньше вы видели неизменные стеки. Существует также измененная версия, поддерживаемая классом [mutable.Stack](http://www.scala-lang.org/api/2.12.2/scala/collection/mutable/Stack.html).
 Он работает точно так же, как и неизменяемая версия, за исключением того, что изменения происходят на месте.

```scala
    scala> val stack = new scala.collection.mutable.Stack[Int]           
        stack: scala.collection.mutable.Stack[Int] = Stack()
    
    scala> stack.push(1)
        res0: stack.type = Stack(1)
    
    scala> stack
        res1: scala.collection.mutable.Stack[Int] = Stack(1)
    
    scala> stack.push(2)
        res0: stack.type = Stack(1, 2)
    
    scala> stack
        res3: scala.collection.mutable.Stack[Int] = Stack(1, 2)
    
    scala> stack.top
        res8: Int = 2
    
    scala> stack
        res9: scala.collection.mutable.Stack[Int] = Stack(1, 2)
    
    scala> stack.pop    
        res10: Int = 2
    
    scala> stack    
        res11: scala.collection.mutable.Stack[Int] = Stack(1)
```

### Стэки-массивы (Array Stacks)

[ArrayStack](http://www.scala-lang.org/api/2.12.2/scala/collection/mutable/ArrayStack.html) - альтернативная реализация 
изменчивого стека, который поддерживается массивом, который при необходимости изменяется по размеру. Он обеспечивает 
быструю индексацию и, как правило, немного более эффективен для большинства операций, чем обычный изменяемый стек.

_Если этот проект окажется полезным тебе - нажми на кнопочку **`★`** в правом верхнем углу._

[<= содержание](https://github.com/steklopod/Collections/blob/master/readme.md)