package wtf.scala.COLLECTIONS

class ForComprehension {

}

object ForExample extends App {

  val names = Array("Dima", "Kolya", "Vasya")

  for (n <- names) {
    println("NAME: " + n + "\n")
  }
}