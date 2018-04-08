package wtf.scala.OOP.object_example

//Companion class:
class Companion2 {
  private val breakIncapsilation = 10

  val tmp = Companion2.objPrivate
}

//Companion object:
object Companion2{
  private val objPrivate = 100

  val tmp = new Companion2().breakIncapsilation
}
