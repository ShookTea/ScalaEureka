package eu.shooktea.eureka.constant

import eu.shooktea.eureka.extension.AllExtensions._

class IntegerNumber private(val integer: BigInt) extends Constant {
  override def toBigDecimal: BigDecimal = BigDecimal(integer)
  override def roundToBigInt: BigInt = integer
  override def toDecimalNumber: DecimalNumber = DecimalNumber(toBigDecimal)

  override def hashCode(): Int = integer.hashCode()
  override def toString: String = integer.toString()
  override def equals(obj: Any): Boolean = obj match {
    case IntegerNumber(i) => i == integer
    case DecimalNumber(d) => d.toBigIntExact contains integer
    case i: BigInt => i == integer
    case l: Long => toDecimalNumber == l.toDecimalNumber
    case i: Int => toDecimalNumber == i.toDecimalNumber
    case d: BigDecimal => toDecimalNumber.decimal == d.toDecimalNumber.decimal
    case d: Double => toDecimalNumber.decimal == d.toDecimalNumber.decimal
    case _ => false
  }

  override def add(other: Constant): Constant = other match {
    case other: IntegerNumber => IntegerNumber(integer + other.integer)
    case other: DecimalNumber => this.toDecimalNumber + other
  }

  override def subtract(other: Constant): Constant = other match {
    case other: IntegerNumber => IntegerNumber(integer - other.integer)
    case other: DecimalNumber => this.toDecimalNumber - other
  }

  override def multiply(other: Constant): Constant = other match {
    case other: IntegerNumber => IntegerNumber(integer * other.integer)
    case other: DecimalNumber => this.toDecimalNumber * other
  }

  override def divideBy(other: Constant): Constant = other match {
    case other: IntegerNumber if integer % other.integer == 0 => IntegerNumber(integer / other.integer)
    case c: Constant => this.toDecimalNumber / c.toDecimalNumber
  }

  override def greaterThan(other: Constant): Boolean =
    this.toDecimalNumber > other.toDecimalNumber

  def gcd(other: IntegerNumber): IntegerNumber =
    IntegerNumber(integer gcd other.integer)

  def lcm(other: IntegerNumber): IntegerNumber =
    if (integer == BigInt(0) && other.integer == BigInt(0)) IntegerNumber(0)
    else IntegerNumber((integer * other.integer).abs / (integer gcd other.integer))
}

object IntegerNumber {
  def apply(integer: BigInt): IntegerNumber = new IntegerNumber(integer)
  def unapply(arg: IntegerNumber): Option[BigInt] = Some(arg.integer)
}
