package eu.shooktea.eureka.extension

import eu.shooktea.eureka.constant.DecimalNumber

trait BigDecimalExtension {
  implicit class BigDecimalExtensions(self: BigDecimal) extends AllExtensions.ConstantExtensions {
    override def toDecimalNumber: DecimalNumber = DecimalNumber(self)
  }
}
