package eu.shooktea.eureka.extension

import eu.shooktea.eureka.constant.DecimalNumber

object AllExtensions extends LongExtension
                        with StringExtension
                        with BigDecimalExtension
                        with BigIntExtension
                        with DoubleExtension
{

  trait ConstantExtensions {
    def toDecimalNumber: DecimalNumber
  }

}
