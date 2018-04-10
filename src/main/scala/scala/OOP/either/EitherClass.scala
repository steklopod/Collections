package scala.OOP.either

import scala.io._

class EitherClass {
}

object EitherObj_1 extends App {

  val in = StdIn.readLine("Введите Either - строку или Int:")
  val result: Either[String, Int] = try {
    Right(in.toInt)
  } catch {
    case e: Exception =>
      Left(in)
  }
  println(result match {
    case Right(x) => s"Вы ввели число: $x"
    case Left(x) => s"Вы ввели строку: $x"
  })
}

object EitherObj_2 extends App {
  def right: Either[String, Int] = Right(10)

  def left: Either[String, Int] = Left("Left")

  val x = right.map(s => s"I've got $s") // Right (I'vve got 10)
  val y = left.map(s => s"I've got $s") // Left("Left")

  //  TODO - непонятно стр. 91
  val z = left.left.map(s => s"I've got $s") // Left("I'vve got")

  println(x)
  println(y)
  println(z)
}