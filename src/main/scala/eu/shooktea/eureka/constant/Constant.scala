package eu.shooktea.eureka.constant

import eu.shooktea.eureka.extension.AllExtensions._
import eu.shooktea.eureka.func.ConstantFunction

import scala.language.implicitConversions
import scala.math.BigDecimal.RoundingMode

trait Constant extends ConstantExtensions {
  override def toBigDecimal: BigDecimal
  def roundToBigInt: BigInt = toBigDecimal.setScale(0, RoundingMode.HALF_UP).toBigInt

  def equals(obj: Any): Boolean
  def ==(l: Long): Boolean = equals(l)
  def ==(i: Int): Boolean = equals(i)
  def ==(d: Double): Boolean = equals(d)
  def toConstFunction: ConstantFunction = ConstantFunction(this)
}
