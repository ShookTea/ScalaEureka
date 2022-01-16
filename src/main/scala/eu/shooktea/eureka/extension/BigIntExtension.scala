package eu.shooktea.eureka.extension

import eu.shooktea.eureka.constant.DecimalNumber

trait BigIntExtension {
  implicit class BigIntExtensions(self: BigInt) extends AllExtensions.ConstantExtensions {
    override def toDecimalNumber: DecimalNumber = DecimalNumber(self)
  }
}