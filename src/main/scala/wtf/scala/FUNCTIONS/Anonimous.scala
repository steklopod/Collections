package wtf.scala.FUNCTIONS

class Anonimous {

}

object Function1Example2 extends App{

}

object Function1Example extends App {
//  (x: Int) => x + 1
  val ex = new Function[Int, Int] {
    def apply(x: Int): Int = x + 1
  }
  println("99 + 1 = " + ex(99))


}