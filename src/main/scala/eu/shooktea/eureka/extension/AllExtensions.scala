package eu.shooktea.eureka.extension

import eu.shooktea.eureka.constant._

object AllExtensions extends LongExtension
                        with StringExtension
                        with BigDecimalExtension
                        with BigIntExtension
                        with DoubleExtension
{

  trait ConstantExtensions {
    def toDecimalNumber: DecimalNumber
    def toIntegerNumber: IntegerNumber
    def +(constant: Constant): Constant = toDecimalNumber + constant
    def -(constant: Constant): Constant = toDecimalNumber - constant
    def *(constant: Constant): Constant = toDecimalNumber * constant
    def /(constant: Constant): Constant = toDecimalNumber / constant
  }

}
