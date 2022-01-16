package eu.shooktea.eureka.constant

class DecimalNumber private(val decimal: BigDecimal) extends Constant {
  override def toBigDecimal: BigDecimal = decimal
}

object DecimalNumber {
  def apply(decimal: BigDecimal): DecimalNumber = new DecimalNumber(decimal)
}
