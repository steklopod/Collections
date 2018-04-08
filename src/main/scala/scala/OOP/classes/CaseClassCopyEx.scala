package scala.OOP.classes

class CaseClassCopy() {
}

case class ClassCopy(name: String, age: Int)

object CaseClassTest extends App{

  println(ClassCopy("Dima", 29))

}
