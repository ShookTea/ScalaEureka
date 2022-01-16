package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.Constant

abstract class OneOpFunction(val function1: Function) extends Function {
  protected def calculateResult(argument1: Constant): Constant

  override def apply(args: Map[Variable, Constant]): Constant = calculateResult(function1(args))
}
