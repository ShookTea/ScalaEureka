package eu.shooktea.eureka.constant

import eu.shooktea.eureka.extension.AllExtensions._

abstract class IntegerNumber private(val integer: BigInt) extends Constant {
  override def toBigDecimal: BigDecimal = BigDecimal(integer)
  override def roundToBigInt: BigInt = integer
  override def toDecimalNumber: DecimalNumber = DecimalNumber(toBigDecimal)

  override def hashCode(): Int = integer.hashCode()
  override def toString: String = integer.toString()
  override def equals(obj: Any): Boolean = obj match {
    case DecimalNumber(d) => d.toBigIntExact contains integer
    case i: BigInt => i == integer
    case l: Long => toDecimalNumber == l.toDecimalNumber
    case i: Int => toDecimalNumber == i.toDecimalNumber
    case d: BigDecimal => toDecimalNumber.decimal == d.toDecimalNumber.decimal
    case d: Double => toDecimalNumber.decimal == d.toDecimalNumber.decimal
    case _ => false
  }

  override def greaterThan(other: Constant): Boolean =
    this.toDecimalNumber > other.toDecimalNumber
}

object IntegerNumber
