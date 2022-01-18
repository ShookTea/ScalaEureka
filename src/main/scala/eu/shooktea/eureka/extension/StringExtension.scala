package eu.shooktea.eureka.extension

import eu.shooktea.eureka.constant._

trait StringExtension {
  implicit class StringExtensions(self: String) extends AllExtensions.ConstantExtensions {
    override def toDecimalNumber: DecimalNumber = DecimalNumber(self)
  }
}
