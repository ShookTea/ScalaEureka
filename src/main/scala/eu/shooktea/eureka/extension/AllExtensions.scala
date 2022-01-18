package eu.shooktea.eureka.extension

import eu.shooktea.eureka.func._

object AllExtensions extends LongExtension
                        with StringExtension
                        with BigDecimalExtension
                        with BigIntExtension
                        with DoubleExtension
{

  trait ConstantExtensions {
    def toBigDecimal: BigDecimal

    def +(f: Function): Function = AddFunction(ConstantFunction(toBigDecimal), f)
    def -(f: Function): Function = SubtractFunction(ConstantFunction(toBigDecimal), f)
    def *(f: Function): Function = MultiplyFunction(ConstantFunction(toBigDecimal), f)
    def /(f: Function): Function = DivideFunction(ConstantFunction(toBigDecimal), f)
  }
}
