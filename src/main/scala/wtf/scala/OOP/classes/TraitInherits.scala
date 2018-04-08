package wtf.scala.OOP.classes

class TraitInherits {

}

/**
  * @note - sealed говорит о том, что наследники могут
  *       быть назначены только в этом же классе
  */
sealed trait RunOne{ def run(): Unit = println("Run")}
trait RunTwo { def run(): Unit = println("Run, Forest!")}

class GoodRunner extends RunOne with RunTwo {
  override def run(): Unit = println("Run, Forest, run!")
}

object GoodRunnerTest extends App {

  println(new GoodRunner().run())

}