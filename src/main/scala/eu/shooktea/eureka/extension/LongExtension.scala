package eu.shooktea.eureka.extension

import eu.shooktea.eureka.constant._

trait LongExtension {
  implicit class LongExtensions(self: Long) extends AllExtensions.ConstantExtensions {
    override def toDecimalNumber: DecimalNumber = DecimalNumber(self)
    override def toIntegerNumber: IntegerNumber = IntegerNumber(self)
  }
}
