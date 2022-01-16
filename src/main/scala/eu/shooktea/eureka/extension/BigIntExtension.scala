package eu.shooktea.eureka.extension

import eu.shooktea.eureka.constant._

trait BigIntExtension {
  implicit class BigIntExtensions(self: BigInt) extends AllExtensions.ConstantExtensions {
    override def toDecimalNumber: DecimalNumber = DecimalNumber(self)
    override def toIntegerNumber: IntegerNumber = IntegerNumber(self)
  }
}
