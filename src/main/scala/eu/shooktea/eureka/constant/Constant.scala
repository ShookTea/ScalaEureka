package eu.shooktea.eureka.constant

import eu.shooktea.eureka.extension.AllExtensions._

import scala.language.implicitConversions
import scala.math.BigDecimal.RoundingMode

trait Constant extends ConstantExtensions {
  def toBigDecimal: BigDecimal
  def roundToBigInt: BigInt = toBigDecimal.setScale(0, RoundingMode.HALF_UP).toBigInt

  override def toDecimalNumber: DecimalNumber = DecimalNumber(toBigDecimal)
  override def toIntegerNumber: IntegerNumber = IntegerNumber(roundToBigInt)

  def equals(obj: Any): Boolean

  def add(other: Constant): Constant
  override def +(other: Constant): Constant = add(other)

  def subtract(other: Constant): Constant
  override def -(other: Constant): Constant = subtract(other)

  def multiply(other: Constant): Constant
  override def *(other: Constant): Constant = multiply(other)

  def divideBy(other: Constant): Constant
  override def /(other: Constant): Constant = divideBy(other)

  def negation: Constant = IntegerNumber(0) - this
  def unary_- : Constant = negation

  def reciprocal: Constant = IntegerNumber(1) / this
}
