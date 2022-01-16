package eu.shooktea.eureka.constant

class DecimalNumber private(val decimal: BigDecimal) extends Constant {
  override def toBigDecimal: BigDecimal = decimal
}

object DecimalNumber {
  def apply(decimal: BigDecimal): DecimalNumber = new DecimalNumber(decimal)
  def apply(int: BigInt): DecimalNumber = DecimalNumber(BigDecimal(int))
  def apply(double: Double): DecimalNumber = DecimalNumber(BigDecimal(double))
  def apply(long: Long): DecimalNumber = DecimalNumber(BigInt(long))
  def apply(string: String): DecimalNumber = DecimalNumber(BigDecimal(string))
}
