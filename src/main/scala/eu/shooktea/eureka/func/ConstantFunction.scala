package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.{Constant, IntegerNumber}

class ConstantFunction(val constant: Constant) extends Function {
  override def toString: String = constant.toString
  override def apply(args: Map[Variable, Constant]): Constant = constant
  override def derivative: Function = ConstantFunction(IntegerNumber(0))
}

object ConstantFunction {
  def apply(constant: Constant): ConstantFunction = new ConstantFunction(constant)
}