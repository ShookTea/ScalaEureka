package eu.shooktea.eureka.constant

import eu.shooktea.eureka.extension.AllExtensions
import scala.math.BigDecimal.RoundingMode

trait Constant extends AllExtensions.ConstantExtensions {
  def toBigDecimal: BigDecimal
  def roundToBigInt: BigInt = toBigDecimal.setScale(0, RoundingMode.HALF_UP).toBigInt
}
