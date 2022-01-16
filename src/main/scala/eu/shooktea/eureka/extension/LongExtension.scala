package eu.shooktea.eureka.extension

import eu.shooktea.eureka.constant.DecimalNumber

trait LongExtension {
  implicit class LongExtensions(self: Long) extends AllExtensions.ConstantExtensions {
    def toDecimalNumber: DecimalNumber = DecimalNumber(self)
  }
}
