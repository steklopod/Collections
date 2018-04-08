package scala.OOP.imports

import java.lang.Integer.valueOf
import java.lang.Double.{isFinite => isInf, isNaN}
import java.lang.Float._

object Demo1 {
  val x = valueOf("  45 ")

//  def y (d:Double) = isInf(_) || isNaN(_)

  val z = floatToIntBits(0.1f)

}
