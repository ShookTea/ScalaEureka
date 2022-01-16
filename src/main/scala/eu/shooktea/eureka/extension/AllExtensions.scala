package eu.shooktea.eureka.extension

import eu.shooktea.eureka.constant._
import eu.shooktea.eureka.func._

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

    def +(f: Function): Function = AddFunction(ConstantFunction(toDecimalNumber), f)
    def *(f: Function): Function = MultiplyFunction(ConstantFunction(toDecimalNumber), f)
  }
}
