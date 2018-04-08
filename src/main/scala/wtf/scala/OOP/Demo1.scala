package wtf.scala.OOP

class Demo1 {
  val property = 29
  def propertyDef = 29
}

object Demo1Test extends App{
  val age = new Demo1().property
  println(age)
}
