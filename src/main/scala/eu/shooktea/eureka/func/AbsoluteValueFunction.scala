package eu.shooktea.eureka.func

class AbsoluteValueFunction(f1: Function) extends OneOpFunction(f1) {
  override def toString: String = s"abs($f1)"

  override protected def calculateResult(a1: BigDecimal): BigDecimal = a1.abs
  override def derivative(v: Variable): Function = (f1 / AbsoluteValueFunction(f1)) * f1.d(v)
}

object AbsoluteValueFunction {
  def apply(function1: Function): AbsoluteValueFunction = new AbsoluteValueFunction(function1)
}