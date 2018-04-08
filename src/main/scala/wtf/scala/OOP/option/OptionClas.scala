package wtf.scala.OOP.option

class OptionClas() {
  val someMessage: Option[String] = Some("Hello")
  val noneMessage: Option[String] = None

  val existingMessage: Option[String] = Option("Hi") //Some("Hi")
  val absentMessagew: Option[String] = Option(null) //None

}


object OptionClassTest extends App {

  println(new OptionClas().someMessage) //Some(Hello)
  require(!new OptionClas().someMessage.isEmpty)

  println(new OptionClas().noneMessage) //None
  println(new OptionClas().noneMessage.getOrElse("Я пуст"))

  println(new OptionClas().existingMessage) //Some(Hi)

  println(new OptionClas().absentMessagew) //NONE

  val x = Some("S C A L A").map((s: String) => s.toLowerCase)
  x.foreach(println(_))
}


object OptionComprehansion extends App {
  val nameOpt = Some("Dima")
  val lastNameOpt = Some("Koltovich")

  val x = for {
    name <- nameOpt
    lastName <- lastNameOpt
  } yield name + " " + lastName

  x.foreach(println(_))

  val q = nameOpt.flatMap {
    name => lastNameOpt.map({
      lastName => name + lastName
    })
  }

  println(q)
}