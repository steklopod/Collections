package scala.COLLECTIONS

class Basics {

}

object CollectionTypesEx extends App {

  //  LIST
  val numbers = List(1, 2, 3, 4)
  println(">LIST: \n" + numbers)

  //  SET
  val sets = Set(1, 2, 3)
  println(">SET: \n" + sets)

  //  MAP:
  println(">MAP: \n" + Map(1 -> 2))

  //  ARRAY
  println(">ARRAY: \n" + Array(1, 2))

  //  CORTEZ
  val hostPort = ("localhost", 80)

  println(">CORTEZ: \n" + hostPort)
  println("-only first element: " + hostPort._1)
  println("-second element: " + hostPort._2)


}




