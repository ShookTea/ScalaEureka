package eu.shooktea.eureka.constant

import eu.shooktea.eureka.extension.AllExtensions._

import scala.language.implicitConversions
import scala.math.BigDecimal.RoundingMode

trait Constant extends ConstantExtensions {
  def toBigDecimal: BigDecimal
  def roundToBigInt: BigInt = toBigDecimal.setScale(0, RoundingMode.HALF_UP).toBigInt

  def add(other: Constant): Constant
  def +(other: Constant): Constant = add(other)
}

object Constant {
  // Conversions to decimal numbers
  implicit def bigDecimalToDecimalNumber(bd: BigDecimal): DecimalNumber = DecimalNumber(bd)
  implicit def bigIntToDecimalNumber(bi: BigInt): DecimalNumber = DecimalNumber(bi)
  implicit def doubleToDecimalNumber(d: Double): DecimalNumber = DecimalNumber(d)
  implicit def longToDecimalNumber(l: Long): DecimalNumber = DecimalNumber(l)
  implicit def stringToDecimalNumber(s: String): DecimalNumber = DecimalNumber(s)
}
