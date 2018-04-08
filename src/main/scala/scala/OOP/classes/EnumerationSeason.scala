package scala.OOP.classes

class EnumerationSeason {
}


object Season extends Enumeration {
  val Winter, Spring, Summer,
  Autumn = Value
}

object EnumTest extends App {

  //  TODO - стр. 25 - recursive value name needs type
//  val name = Season.withName(name: String)
//  println(name)

  
  val vals = Season.values
  println(vals)

//  TODO - стр. 25
//  val applyT = Season.apply(x: Int)

  val maxId = Season.maxId
  println(maxId)

  val id = Season.Winter.id
  println(id)

  //  TODO - стр. 25
//  println(Season.Winter.compareTo(that:Season))

  println(Season.Winter + Season.Autumn)
  println(Season.Winter < Season.Autumn)

}
