package wtf.scala.imports

class Person(val name: String, val age: Int)

object Demo2 {
  def f(p: Person): Unit = {
    import p._
    println("name: " + name + ", age: " + age)
  }
}
