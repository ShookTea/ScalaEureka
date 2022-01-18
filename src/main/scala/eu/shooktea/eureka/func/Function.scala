package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.Constant
import eu.shooktea.eureka.extension.AllExtensions._

trait Function {
  def apply(args: (Variable, Any)*): Constant =
    apply(args.map {
      case (k, v) => (k, v match {
        case i: BigInt => i.toDecimalNumber
        case l: Long => l.toDecimalNumber
        case i: Int => i.toDecimalNumber
        case s: Short => s.toDecimalNumber
        case b: Byte => b.toDecimalNumber
        case d: BigDecimal => d.toDecimalNumber
        case d: Double => d.toDecimalNumber
        case f: Float => f.toDecimalNumber
      })
    }.toMap)
  def apply(args: Map[Variable,Constant]): Constant =
    apply(args.map {
      case (k, v) => (k, v.toBigDecimal)
    }).toDecimalNumber

  def apply(args: Map[Variable,BigDecimal]): BigDecimal
  def derivative(v: Variable): Function
  def d(v: Variable): Function = derivative(v)

  def +(other: Function): Function = AddFunction(this, other)
  def +(other: BigDecimal): Function = this + ConstantFunction(other)
  def +(other: BigInt): Function = this + BigDecimal(other)
  def +(other: Long): Function = this + BigDecimal(other)
  def +(other: Double): Function = this + BigDecimal(other)

  def -(other: Function): Function = SubtractFunction(this, other)
  def -(other: BigDecimal): Function = this - ConstantFunction(other)
  def -(other: BigInt): Function = this - BigDecimal(other)
  def -(other: Long): Function = this - BigDecimal(other)
  def -(other: Double): Function = this - BigDecimal(other)

  def *(other: Function): Function = MultiplyFunction(this, other)
  def *(other: BigDecimal): Function = this * ConstantFunction(other)
  def *(other: BigInt): Function = this * BigDecimal(other)
  def *(other: Long): Function = this * BigDecimal(other)
  def *(other: Double): Function = this * BigDecimal(other)

  def /(other: Function): Function = DivideFunction(this, other)
  def /(other: BigDecimal): Function = this / ConstantFunction(other)
  def /(other: BigInt): Function = this / BigDecimal(other)
  def /(other: Long): Function = this / BigDecimal(other)
  def /(other: Double): Function = this / BigDecimal(other)
}

object Function {
  def abs(f: Function): Function = AbsoluteValueFunction(f)
  def abs(d: BigDecimal): BigDecimal = d.abs
  def abs(i: BigInt): BigDecimal = abs(BigDecimal(i))
  def abs(l: Long): BigDecimal = abs(BigDecimal(l))
  def abs(d: Double): BigDecimal = abs(BigDecimal(d))
}
