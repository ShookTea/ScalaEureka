package eu.shooktea.eureka.constant

import scala.math.BigDecimal.RoundingMode

trait Constant {
  def toBigDecimal: BigDecimal
  def roundToBigInt: BigInt = toBigDecimal.setScale(0, RoundingMode.HALF_UP).toBigInt
}
