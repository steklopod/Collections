package wtf.scala.OOP.classes

class TupleEx() {
  val tuple: (Int, String, Double) = (1, "Scala", 2.22)
}


object TupleClassTest extends App {

  println(new TupleEx().tuple._1) // 1


}
