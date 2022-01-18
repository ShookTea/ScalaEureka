package eu.shooktea.eureka.constant

import scala.language.implicitConversions
import eu.shooktea.eureka.extension.AllExtensions._

class DecimalNumber private(val decimal: BigDecimal) extends Constant {
  override def toBigDecimal: BigDecimal = decimal
  override def toDecimalNumber: DecimalNumber = this

  override def hashCode(): Int = decimal.hashCode()
  override def toString: String = decimal.toString()
  override def equals(obj: Any): Boolean = obj match {
    case c: Constant => decimal == c.toDecimalNumber.decimal
    case i: BigInt => decimal == i.toDecimalNumber.decimal
    case l: Long => decimal == l.toDecimalNumber.decimal
    case i: Int => decimal == i.toDecimalNumber.decimal
    case d: BigDecimal => decimal == d.toDecimalNumber.decimal
    case d: Double => decimal == d.toDecimalNumber.decimal
    case _ => false
  }

  override def add(other: Constant): Constant =
    new DecimalNumber(decimal + other.toDecimalNumber.decimal)

  override def subtract(other: Constant): Constant =
    new DecimalNumber(decimal - other.toDecimalNumber.decimal)

  override def multiply(other: Constant): Constant =
    new DecimalNumber(decimal * other.toDecimalNumber.decimal)

  override def divideBy(other: Constant): Constant =
    new DecimalNumber(decimal / other.toDecimalNumber.decimal)

  override def greaterThan(other: Constant): Boolean =
    decimal > other.toDecimalNumber.decimal
}

object DecimalNumber {
  def apply(decimal: BigDecimal): DecimalNumber = new DecimalNumber(decimal)
  def unapply(arg: DecimalNumber): Option[BigDecimal] = Some(arg.decimal)

  def apply(int: BigInt): DecimalNumber = DecimalNumber(BigDecimal(int))
  def apply(double: Double): DecimalNumber = DecimalNumber(BigDecimal(double))
  def apply(long: Long): DecimalNumber = DecimalNumber(BigInt(long))
  def apply(string: String): DecimalNumber = DecimalNumber(BigDecimal(string))
}
