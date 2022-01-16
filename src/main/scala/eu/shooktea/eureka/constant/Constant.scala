package eu.shooktea.eureka.constant

import eu.shooktea.eureka.extension.AllExtensions

import scala.language.implicitConversions
import scala.math.BigDecimal.RoundingMode

trait Constant extends AllExtensions.ConstantExtensions {
  def toBigDecimal: BigDecimal
  def roundToBigInt: BigInt = toBigDecimal.setScale(0, RoundingMode.HALF_UP).toBigInt
}

object Constant {
  implicit def longToDecimalNumber(long: Long): DecimalNumber = DecimalNumber(long)
}
