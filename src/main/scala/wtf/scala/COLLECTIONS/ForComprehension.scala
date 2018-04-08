package wtf.scala.COLLECTIONS

class ForComprehension {

}

object ForExample extends App {

  val names = Array("Dima", "Kolya", "Vasya")

  for (n <- names) {
    println("NAME: " + n + "\n")
  }

//  ANOTHER VARIANT:
  println("Другой способ: \n")
  (0 until 10).foreach(a => println(a))

  // 1. YIELD:
  println("YIELD [увеличиваем первую букву каждого слова]: \n")
  val capNames = for( e <- names) yield  e.capitalize

  capNames.foreach(println(_))

  // 2. YIELD:
  val length = for ( e <- names) yield {
    e.length
  }
  length.foreach(println(_))



}