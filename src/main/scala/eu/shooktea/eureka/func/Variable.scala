package eu.shooktea.eureka.func
import eu.shooktea.eureka.constant.Constant

class Variable extends Function {
  override def apply(args: Map[Variable, Constant]): Constant = args(this)
}

object Variable {
  def apply(): Variable = new Variable()
}