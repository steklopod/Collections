package wtf.scala.OOP.strings

object PrintF extends App {

  val floatVar = 12.456

  val intVar = 2000

  val multiString =
    """
  Hello,
  Scala!
  """"

  val fs = printf("" +
    "Float = - %f, \n" +
    "Integer = - %d, \n" +
    "String = - %s, \n"
    , floatVar
    , intVar
    ,multiString
  )

  println(fs)

}
