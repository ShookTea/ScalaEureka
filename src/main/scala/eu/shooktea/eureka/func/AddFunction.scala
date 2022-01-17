package eu.shooktea.eureka.func
import eu.shooktea.eureka.constant.Constant

class AddFunction(f1: Function, f2: Function) extends TwoOpFunction(f1, f2) {
  override def toString: String = s"($f1) + ($f2)"
  override protected def calculateResult(a1: Constant, a2: Constant): Constant = a1 + a2
  override def derivative: Function = f1.derivative + f2.derivative
}

object AddFunction {
  def apply(f1: Function, f2: Function): AddFunction = new AddFunction(f1, f2)
}
