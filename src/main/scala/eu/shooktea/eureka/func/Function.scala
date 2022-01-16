package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.Constant
import eu.shooktea.eureka.extension.AllExtensions._

trait Function {
  def apply(args: (Variable, Constant)*): Constant = this(args.toMap)
  def apply(args: Map[Variable,Constant]): Constant

  def abs: Function = AbsoluteValueFunction(this)
  def +(other: Function): Function = AddFunction(this, other)
  def +(other: Constant): Function = AddFunction(this, ConstantFunction(other))
  def +(other: Long): Function = AddFunction(this, other.toDecimalNumber.toConstFunction)
  def +(other: Double): Function = AddFunction(this, other.toDecimalNumber.toConstFunction)

  def *(other: Function): Function = MultiplyFunction(this, other)
  def *(other: Constant): Function = MultiplyFunction(this, ConstantFunction(other))
}
