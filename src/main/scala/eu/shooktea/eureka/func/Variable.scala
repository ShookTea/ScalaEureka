package eu.shooktea.eureka.func
import eu.shooktea.eureka.constant.{Constant, DecimalNumber}

class Variable extends Function {
  override def apply(args: Map[Variable, Constant]): Constant = args(this)
  override def derivative(v: Variable): Function =
    if (v == this) DecimalNumber(1).toConstFunction
    else DecimalNumber(0).toConstFunction
}

object Variable {
  def apply(): Variable = new Variable()
}