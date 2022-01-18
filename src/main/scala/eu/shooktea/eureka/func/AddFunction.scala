package eu.shooktea.eureka.func

class AddFunction(f1: Function, f2: Function) extends TwoOpFunction(f1, f2) {
  override def toString: String = s"($f1) + ($f2)"
  override protected def calculateResult(a1: BigDecimal, a2: BigDecimal): BigDecimal = a1 + a2
  override def derivative(v: Variable): Function = f1.d(v) + f2.d(v)
}

object AddFunction {
  def apply(f1: Function, f2: Function): AddFunction = new AddFunction(f1, f2)
}
