package eu.shooktea.eureka.extension

import eu.shooktea.eureka.constant._

trait BigDecimalExtension {
  implicit class BigDecimalExtensions(self: BigDecimal) extends AllExtensions.ConstantExtensions {
    override def toDecimalNumber: DecimalNumber = DecimalNumber(self)
    override def toIntegerNumber: IntegerNumber = DecimalNumber(self).toIntegerNumber
  }
}
