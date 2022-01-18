package eu.shooktea.eureka.func

class ConstantFunction(val constant: BigDecimal) extends Function {
  override def toString: String = constant.toString
  override def apply(args: Map[Variable, BigDecimal]): BigDecimal = constant
  override def derivative(v: Variable): Function = ConstantFunction(0)
}

object ConstantFunction {
  def apply(constant: BigDecimal): ConstantFunction = new ConstantFunction(constant)
}