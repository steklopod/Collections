package wtf.scala.OOP.object_example

class Companion(val name: String, val age: Int)

//Java/static class members == Scala/companion object, companion module
object Companion {
  val MAX_AGE = 99
  val MAX_NAME_LENGTH = 1024

  def apply(name: String, age: Int) = new Companion(name, age)
}

object Demo extends App{

  val comp0 = new Companion("Dima", 29)

  val comp1 = Companion.apply("Dima", 29)

  val comp2 = Companion("Dima", 29)
}



