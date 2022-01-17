package eu.shooktea.eureka.func
import eu.shooktea.eureka.constant.Constant

class MultiplyFunction(f1: Function, f2: Function) extends TwoOpFunction(f1, f2) {
  override def toString: String = s"($f1) * ($f2)"
  override protected def calculateResult(a1: Constant, a2: Constant): Constant = a1 * a2
  override def derivative: Function = f1.derivative * f2 + f1 * f2.derivative
}

object MultiplyFunction {
  def apply(f1: Function, f2: Function): MultiplyFunction = new MultiplyFunction(f1, f2)
}