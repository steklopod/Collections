package wtf.scala.OOP.object_example

import wtf.scala.OOP.object_example.IntLab.max
//���� ������� �1 - ����������� ������� � ���������:
object Demo {
  def main(args: Array[String]): Unit = {
    println(max(7, 3))
  }
}

//�������� �������� � �������:
object IntLab {
  val MAX_INT = java.lang.Integer.MAX_VALUE

  def max(x: Int, y: Int) = if (x > y) x else y
}
