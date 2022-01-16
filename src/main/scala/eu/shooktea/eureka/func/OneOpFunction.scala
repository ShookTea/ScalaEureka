package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.Constant

abstract class OneOpFunction(val f1: Function) extends Function {
  protected def calculateResult(a1: Constant): Constant

  override def apply(args: Map[Variable, Constant]): Constant = calculateResult(f1(args))
}
