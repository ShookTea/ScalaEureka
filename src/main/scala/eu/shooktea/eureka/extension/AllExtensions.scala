package eu.shooktea.eureka.extension

import eu.shooktea.eureka.constant.DecimalNumber

object AllExtensions extends LongExtension
                        with StringExtension
{

  trait ConstantExtensions {
    def toDecimalNumber: DecimalNumber
  }

}
