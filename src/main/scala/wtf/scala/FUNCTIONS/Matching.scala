package wtf.scala.FUNCTIONS


class Matching {

}

object MatcherTest extends App {

  def matchInt(num: Int): String = {
    num match {
      case 1 => "one"
      case 2 => "two"
      case _ => "many" //все остальное
    }
  }

  println(matchInt(5))


  /**
    * Сопоставление с образцом
    */
  def matchIntCondition(num: Int): String = {
    num match {
      case i if i == 1 => "один"
      case i if i == 2 => "два"
      case _ => "много"
    }
  }

  println(matchIntCondition(2))
}

object CaseClassMatching extends App {
  val opt: Option[Int] = Some(4)

  opt match {
    case Some(n) if n > 5 => println(s"Мой номер $n > 5")
    case Some(_) => println("Число меньше чем 5")
    case None => println("No numbers")
  }

  println(opt)
  //  println(opt(6))

}

/**
  * extractors, unapply
  */
object Twice {
  def unapply(num: Int): Option[Int] = if (num % 2 == 0)
    Some(num / 2) else None
}

object TwiceExample extends App {
  val x = 34
  x match {
    case Twice(n) => println(s"Twice $n")
    case _ => println("Not twice")
  }
  println(x)

}




