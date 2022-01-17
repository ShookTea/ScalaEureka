package eu.shooktea.eureka.func
import eu.shooktea.eureka.constant.Constant

class DivideFunction(f1: Function, f2: Function) extends TwoOpFunction(f1, f2) {
  override def toString: String = s"($f1) / ($f2)"
  override protected def calculateResult(a1: Constant, a2: Constant): Constant = a1 / a2
  override def derivative: Function = (f1.derivative * f2 - f2.derivative * f1) / (f2 * f2)
}

object DivideFunction {
  def apply(f1: Function, f2: Function): DivideFunction = new DivideFunction(f1, f2)
}
