package wtf.scala

object HelloWorld extends App {
  println("Hello world")

  val a = if (true) {
    1
  } else {
    "1"
  }
  println(a.isInstanceOf[Int])
}