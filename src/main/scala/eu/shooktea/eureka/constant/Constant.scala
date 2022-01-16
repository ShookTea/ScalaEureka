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

  def greaterThan(other: Constant): Boolean
  def >(other: Constant): Boolean = greaterThan(other)

  def greaterThanOrEqual(other: Constant): Boolean = this > other || this == other
  def >=(other: Constant): Boolean = greaterThanOrEqual(other)

  def lesserThanOrEqual(other: Constant): Boolean = !greaterThan(other)
  def <=(other: Constant): Boolean = lesserThanOrEqual(other)

  def lesserThan(other: Constant): Boolean = lesserThanOrEqual(other) && !equals(other)
  def <(other: Constant): Boolean = lesserThan(other)

  def negation: Constant = IntegerNumber(0) - this
  def unary_- : Constant = negation

  def reciprocal: Constant = IntegerNumber(1) / this
}
