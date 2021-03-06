package eu.shooktea.eureka.func

class DivideFunction(f1: Function, f2: Function) extends TwoOpFunction(f1, f2) {
  override def toString: String = s"($f1) / ($f2)"
  override protected def calculateResult(a1: BigDecimal, a2: BigDecimal): BigDecimal = a1 / a2
  override def derivative(v: Variable): Function = (f1.d(v) * f2 - f2.d(v) * f1) / (f2 * f2)
}

object DivideFunction {
  def apply(f1: Function, f2: Function): DivideFunction = new DivideFunction(f1, f2)
}
