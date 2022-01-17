package eu.shooktea.eureka.func
import eu.shooktea.eureka.constant.{Constant, IntegerNumber}

class Variable extends Function {
  override def apply(args: Map[Variable, Constant]): Constant = args(this)
  override def derivative: Function = IntegerNumber(1).toConstFunction
}

object Variable {
  def apply(): Variable = new Variable()
}