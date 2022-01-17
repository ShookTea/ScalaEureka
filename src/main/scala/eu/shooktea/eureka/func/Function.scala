package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.Constant
import eu.shooktea.eureka.extension.AllExtensions._

trait Function {
  def apply(args: (Variable, Any)*): Constant =
    apply(args.map {
      case (k, v) => (k, v match {
        case c: Constant => c
        case i: BigInt => i.toIntegerNumber
        case l: Long => l.toIntegerNumber
        case i: Int => i.toIntegerNumber
        case s: Short => s.toIntegerNumber
        case b: Byte => b.toIntegerNumber
        case d: BigDecimal => d.toDecimalNumber
        case d: Double => d.toDecimalNumber
        case f: Float => f.toDecimalNumber
      })
    }.toMap)
  def apply(args: Map[Variable,Constant]): Constant

  def +(other: Function): Function = AddFunction(this, other)
  def +(other: Constant): Function = this + other.toConstFunction
  def +(other: BigInt): Function = this + other.toDecimalNumber
  def +(other: Long): Function = this + other.toDecimalNumber
  def +(other: BigDecimal): Function = this + other.toDecimalNumber
  def +(other: Double): Function = this + other.toDecimalNumber

  def -(other: Function): Function = SubtractFunction(this, other)
  def -(other: Constant): Function = this - other.toConstFunction
  def -(other: BigInt): Function = this - other.toDecimalNumber
  def -(other: Long): Function = this - other.toDecimalNumber
  def -(other: BigDecimal): Function = this - other.toDecimalNumber
  def -(other: Double): Function = this - other.toDecimalNumber

  def *(other: Function): Function = MultiplyFunction(this, other)
  def *(other: Constant): Function = this * other.toConstFunction
  def *(other: BigInt): Function = this * other.toDecimalNumber
  def *(other: Long): Function = this * other.toDecimalNumber
  def *(other: BigDecimal): Function = this * other.toDecimalNumber
  def *(other: Double): Function = this * other.toDecimalNumber

  def /(other: Function): Function = DivideFunction(this, other)
  def /(other: Constant): Function = this / other.toConstFunction
  def /(other: BigInt): Function = this / other.toDecimalNumber
  def /(other: Long): Function = this / other.toDecimalNumber
  def /(other: BigDecimal): Function = this / other.toDecimalNumber
  def /(other: Double): Function = this / other.toDecimalNumber
}

object Function {
  def abs(f: Function): Function = AbsoluteValueFunction(f)
  def abs(c: Constant): Constant = c.abs
  def abs(i: BigInt): Constant = i.toIntegerNumber.abs
  def abs(l: Long): Constant = l.toIntegerNumber.abs
  def abs(d: BigDecimal): Constant = d.toDecimalNumber.abs
  def abs(d: Double): Constant = d.toDecimalNumber.abs
}
