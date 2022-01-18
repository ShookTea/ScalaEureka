package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.{Constant, DecimalNumber}

class ConstantFunction(val constant: Constant) extends Function {
  override def toString: String = constant.toString
  override def apply(args: Map[Variable, BigDecimal]): BigDecimal = constant.toBigDecimal
  override def derivative(v: Variable): Function = ConstantFunction(DecimalNumber(0))
}

object ConstantFunction {
  def apply(constant: Constant): ConstantFunction = new ConstantFunction(constant)
}