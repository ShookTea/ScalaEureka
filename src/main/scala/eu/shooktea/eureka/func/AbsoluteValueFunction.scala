package eu.shooktea.eureka.func
import eu.shooktea.eureka.constant.{Constant, IntegerNumber}

class AbsoluteValueFunction(function1: Function) extends OneOpFunction(function1) {
  override protected def calculateResult(argument1: Constant): Constant =
    if (argument1 > IntegerNumber(0)) argument1
    else -argument1
}

object AbsoluteValueFunction {
  def apply(function1: Function): AbsoluteValueFunction = new AbsoluteValueFunction(function1)
}