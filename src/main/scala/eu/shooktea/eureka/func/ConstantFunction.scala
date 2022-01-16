package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.Constant

class ConstantFunction(val constant: Constant) extends Function {
  override def apply(args: Map[Variable, Constant]): Constant = constant
}

object ConstantFunction {
  def apply(constant: Constant): ConstantFunction = new ConstantFunction(constant)
}