package eu.shooktea.eureka.func
import eu.shooktea.eureka.constant.Constant

abstract class TwoOpFunction(val f1: Function, val f2: Function) extends Function {
  protected def calculateResult(a1: Constant, a2: Constant): Constant

  override def apply(args: Map[Variable, Constant]): Constant = calculateResult(
    f1(args),
    f2(args),
  )
}
