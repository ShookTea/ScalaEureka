package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.Constant
import eu.shooktea.eureka.extension.AllExtensions._

trait Function {
  def apply(args: (Variable, Constant)*): Constant = this(args.toMap)
  def apply(args: Map[Variable,Constant]): Constant

  def +(other: Function): Function = AddFunction(this, other)
  def +(other: Constant): Function = AddFunction(this, ConstantFunction(other))
  def +(other: BigInt): Function = AddFunction(this, other.toDecimalNumber.toConstFunction)
  def +(other: Long): Function = AddFunction(this, other.toDecimalNumber.toConstFunction)
  def +(other: BigDecimal): Function = AddFunction(this, other.toDecimalNumber.toConstFunction)
  def +(other: Double): Function = AddFunction(this, other.toDecimalNumber.toConstFunction)

  def *(other: Function): Function = MultiplyFunction(this, other)
  def *(other: Constant): Function = MultiplyFunction(this, ConstantFunction(other))
  def *(other: BigInt): Function = MultiplyFunction(this, other.toIntegerNumber.toConstFunction)
  def *(other: Long): Function = MultiplyFunction(this, other.toIntegerNumber.toConstFunction)
  def *(other: BigDecimal): Function = MultiplyFunction(this, other.toDecimalNumber.toConstFunction)
  def *(other: Double): Function = MultiplyFunction(this, other.toDecimalNumber.toConstFunction)
}

object Function {
  def abs(f: Function): Function = AbsoluteValueFunction(f)
  def abs(c: Constant): Constant = c.abs
  def abs(i: BigInt): Constant = i.toIntegerNumber.abs
  def abs(l: Long): Constant = l.toIntegerNumber.abs
  def abs(d: BigDecimal): Constant = d.toDecimalNumber.abs
  def abs(d: Double): Constant = d.toDecimalNumber.abs
}
