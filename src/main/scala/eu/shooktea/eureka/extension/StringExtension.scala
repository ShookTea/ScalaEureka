package eu.shooktea.eureka.extension

import eu.shooktea.eureka.constant.DecimalNumber

trait StringExtension {
  implicit class StringExtensions(self: String) {
    def toDecimalNumber: DecimalNumber = DecimalNumber(self)
  }
}
