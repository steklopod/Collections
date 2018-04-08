package wtf.scala.OOP.object_example

class StaticFromJava {

}

object MyObject {
  val x = "scala"
  def foo(str: String) = s"hi, $str"
}

object MyObjTest extends  App {

  val res1 = MyObject.foo("Дима \n")
  println(res1)

  val res = MyObject.foo(MyObject.x)
  println(res)
}
