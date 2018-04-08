package wtf.scala.OOP.constructor

class ClassConstructor {

}
class Foo(a: Int, val b: Int, var c: Int){
  def summ = a + b + c
}

/**
  * @note  _ - поле
  *     val  - поле + аксессор
  *     var -  поле + аксессор + мутатор
  */
object FooTest extends App{
  val x = new Foo(1,2,3)

  /**
    *  @note  - Нельзя вызвать x.a
    */
  println(x.b)   // 2

  println(x.c)   // 3

  println(x.summ) // 6

  x.c = 97

  println(x.summ) // 100

}
