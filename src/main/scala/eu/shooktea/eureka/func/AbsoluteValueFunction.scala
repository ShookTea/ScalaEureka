package eu.shooktea.eureka.func
import eu.shooktea.eureka.constant.Constant

class AbsoluteValueFunction(f1: Function) extends OneOpFunction(f1) {
  override def toString: String = s"abs($f1)"

  override protected def calculateResult(a1: Constant): Constant = a1.abs
  override def derivative: Function = (f1 / AbsoluteValueFunction(f1)) * f1.derivative
}

object AbsoluteValueFunction {
  def apply(function1: Function): AbsoluteValueFunction = new AbsoluteValueFunction(function1)
}