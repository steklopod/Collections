## Строковый сборщик (StringBuilder)

Подобно тому, как буфер массива полезен для построения массивов, а буфер списка полезен для построения списков,
 [StringBuilder](http://www.scala-lang.org/api/2.12.2/scala/collection/mutable/StringBuilder.html) полезен для построения 
 строк. `Строковые сборщики` настолько часто используются, что они уже импортированы в пространство имен по умолчанию. 
 Создайте их с помощью простого `new StringBuilder`, например:
 
 ```scala
    scala> val buf = new StringBuilder
        buf: StringBuilder =
    
    scala> buf += 'a'
        res38: buf.type = a
    
    scala> buf ++= "bcdef"
        res39: buf.type = abcdef
    
    scala> buf.toString
        res41: String = abcdef
 ```

_Если этот проект окажется полезным тебе - нажми на кнопочку **`★`** в правом верхнем углу._

[<= содержание](https://github.com/steklopod/Collections/blob/master/readme.md)