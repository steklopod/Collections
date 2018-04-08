package wtf.scala.OOP.object_example

class Companion3_BinDis {}

object SomePerson {
  private val hello = "Hello"
  def apply(firstName: String, lastName: String, age: Int): SomePerson
  = new SomePerson(firstName, lastName, age)
}

class SomePerson(firstName: String, lastName: String, age: Int){
  import SomePerson._
  def greet(question: String) = hello + firstName + "!" + question
}

object SomePersonTest extends App{
  //КРАТКИЙ СПОСОБ:
  val hiSimple = SomePerson("Dima", "Aka", 29).greet("Понял пример? ")
  println(hiSimple)

  //Первый способ:
  val hi = SomePerson.apply("Dima", "Aka", 29).greet("Понял пример? ")
  println(hi)

  //Второй способ:
  val hiAgain = new SomePerson("Dima", "Aka", 29).greet("Понял пример? ")
  println(hiAgain)
}