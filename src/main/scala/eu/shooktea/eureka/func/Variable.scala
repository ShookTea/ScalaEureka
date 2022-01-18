package eu.shooktea.eureka.func

class Variable extends Function {
  override def apply(args: Map[Variable, BigDecimal]): BigDecimal = args(this)
  override def derivative(v: Variable): Function =
    if (v == this) ConstantFunction(1)
    else ConstantFunction(0)
}

object Variable {
  def apply(): Variable = new Variable()
}