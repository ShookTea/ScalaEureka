package eu.shooktea.eureka.extension

import eu.shooktea.eureka.constant._

trait DoubleExtension {
  implicit class DoubleExtensions(self: Double) extends AllExtensions.ConstantExtensions {
    override def toDecimalNumber: DecimalNumber = DecimalNumber(self)
    override def toIntegerNumber: IntegerNumber = DecimalNumber(self).toIntegerNumber
  }
}
