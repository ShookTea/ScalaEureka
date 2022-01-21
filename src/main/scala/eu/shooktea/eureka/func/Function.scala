package eu.shooktea.eureka.func

import eu.shooktea.eureka.extension.AllExtensions._
import eu.shooktea.eureka.func.Function._

trait Function {
  def apply(args: (Variable, Any)*): BigDecimal =
    apply(args.map {
      case (k, v) => (k, v match {
        case v: BigDecimal => v
        case v: BigInt => BigDecimal(v)
        case v: Long => BigDecimal(v)
        case v: Int => BigDecimal(v)
        case v: Short => BigDecimal(v)
        case v: Byte => BigDecimal(v)
        case v: Double => BigDecimal(v)
        case v: Float => BigDecimal(v)
      })
    }.toMap)

  def apply(args: Map[Variable,BigDecimal]): BigDecimal

  def derivative(v: Variable): Function
  def d(v: Variable): Function = derivative(v)

  def +(other: Function): Function = AddFunction(this, other)
  def +(other: BigDecimal): Function = this + ConstantFunction(other)

  def -(other: Function): Function = SubtractFunction(this, other)
  def -(other: BigDecimal): Function = this - ConstantFunction(other)

  def *(other: Function): Function = MultiplyFunction(this, other)
  def *(other: BigDecimal): Function = this * ConstantFunction(other)

  def /(other: Function): Function = DivideFunction(this, other)
  def /(other: BigDecimal): Function = this / ConstantFunction(other)

  def ^(other: Function): Function = exp(other * ln(this))
  def ^(other: BigDecimal): Function = this ^ ConstantFunction(other)
}

object Function {
  def abs(f: Function): Function = AbsoluteValueFunction(f)
  def abs(d: BigDecimal): BigDecimal = d.abs

  def ln(f: Function): Function = NaturalLogarithmFunction(f)
  def ln(d: BigDecimal): BigDecimal = NaturalLogarithmFunction(ConstantFunction(d))()

  def log(f: Function): Function = BaseTenLogarithmFunction(f)
  def log(d: BigDecimal): BigDecimal = BaseTenLogarithmFunction(ConstantFunction(d))()

  def log(base: Function, value: Function): Function = ln(value) / ln(base)
  def log(base: BigDecimal, value: Function): Function = ln(value) / ln(base)
  def log(base: Function, value: BigDecimal): Function = ln(value) / ln(base)
  def log(base: BigDecimal, value: BigDecimal): BigDecimal = ln(value) / ln(base)

  def exp(f: Function, iterations: Int): Function = ExpFunction(f, iterations)
  def exp(f: Function): Function = exp(f, 100)
  def exp(d: BigDecimal, iterations: Int): BigDecimal = ExpFunction(ConstantFunction(d), iterations)()
  def exp(d: BigDecimal): BigDecimal = exp(d, 100)
}
