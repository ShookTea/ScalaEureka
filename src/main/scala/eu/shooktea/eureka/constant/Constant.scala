package eu.shooktea.eureka.constant

import eu.shooktea.eureka.extension.AllExtensions._

import scala.language.implicitConversions
import scala.math.BigDecimal.RoundingMode

trait Constant extends ConstantExtensions {
  def toBigDecimal: BigDecimal
  def roundToBigInt: BigInt = toBigDecimal.setScale(0, RoundingMode.HALF_UP).toBigInt

  def equals(obj: Any): Boolean

  def add(other: Constant): Constant
  def +(other: Constant): Constant = add(other)

  def subtract(other: Constant): Constant
  def -(other: Constant): Constant = subtract(other)

  def multiply(other: Constant): Constant
  def *(other: Constant): Constant = multiply(other)
}
