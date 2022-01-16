package eu.shooktea.eureka.extension

import eu.shooktea.eureka.constant.DecimalNumber

trait LongExtension {
  implicit class LongExtensions(self: Long) {
    def toDecimalNumber: DecimalNumber = DecimalNumber(self)
  }
}
