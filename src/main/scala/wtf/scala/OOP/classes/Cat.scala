package wtf.scala.OOP.classes

class Cat extends Animal {
  val name: String = "Vasya"

  def say(): String = "Meow"
}

class Cat2(name: String ){
  def say(): String = "Meow"
}

class Animal{
  def isHuman: Boolean = false
}

class Human extends Animal{
  override def isHuman: Boolean = true
}

object DemoOfAnim extends App{
  println("Is cat Human - "+ new Cat().isHuman)

  println("Is human Animal - "+ new Human().isHuman)
}
