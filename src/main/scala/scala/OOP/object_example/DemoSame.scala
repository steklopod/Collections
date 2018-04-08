package scala.OOP.object_example

class DemoSame {
  def f(): Int = 0

  val k: Int = 1
}


object DemoSame {
  def f(): Int = 0

//  val k: Int = 1
}

class X{
  new DemoSame().k
//  not working:
//  new DemoSame.k

}