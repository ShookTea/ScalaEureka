package eu.shooktea.eureka.constant

class IntegerNumber private(val integer: BigInt) extends Constant {
  override def toBigDecimal: BigDecimal = BigDecimal(integer)
  override def roundToBigInt: BigInt = integer
  override def toDecimalNumber: DecimalNumber = DecimalNumber(toBigDecimal)
  override def toIntegerNumber: IntegerNumber = this

  override def hashCode(): Int = integer.hashCode()
  override def toString: String = integer.toString()
  override def equals(obj: Any): Boolean = obj match {
    case IntegerNumber(i) => i == integer
    case DecimalNumber(d) => d.toBigIntExact contains integer
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

  def gcd(other: IntegerNumber): IntegerNumber =
    IntegerNumber(integer gcd other.integer)

  def lcm(other: IntegerNumber): IntegerNumber =
    if (integer == BigInt(0) && other.integer == BigInt(0)) IntegerNumber(0)
    else IntegerNumber((integer * other.integer).abs / (integer gcd other.integer))
}

object IntegerNumber {
  def apply(integer: BigInt): IntegerNumber = new IntegerNumber(integer)
  def unapply(arg: IntegerNumber): Option[BigInt] = Some(arg.integer)

  def apply(long: Long): IntegerNumber = IntegerNumber(BigInt(long))
  def apply(bigDecimal: BigDecimal): IntegerNumber = DecimalNumber(bigDecimal).toIntegerNumber
  def apply(string: String): IntegerNumber = IntegerNumber(BigDecimal(string))
  def apply(double: Double): IntegerNumber = IntegerNumber(BigDecimal(double))
}
