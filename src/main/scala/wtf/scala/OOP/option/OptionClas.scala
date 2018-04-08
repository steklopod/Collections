package wtf.scala.OOP.option

class OptionClas() {
  val someMessage: Option[String] = Some("Hello")
  val noneMessage: Option[String] = None

  val existingMessage: Option[String] = Option("Hi") //Some("Hi")
  val absentMessagew: Option[String] = Option(null)  //None

}


object OptionClassTest extends App{

  println(new OptionClas().someMessage)

  println(new OptionClas().noneMessage)

  println(new OptionClas().existingMessage)

  println(new OptionClas().absentMessagew)

}
