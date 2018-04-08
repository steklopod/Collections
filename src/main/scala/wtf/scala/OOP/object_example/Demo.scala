package wtf.scala.OOP.object_example

import wtf.scala.OOP.object_example.IntLab.max
//Роль объекта №1 - утилитарные функции и константы:
object Demo {
  def main(args: Array[String]): Unit = {
    println(max(7, 3))
  }
}

//Хранение констант и функций:
object IntLab {
  val MAX_INT = java.lang.Integer.MAX_VALUE

  def max(x: Int, y: Int) = if (x > y) x else y
}
