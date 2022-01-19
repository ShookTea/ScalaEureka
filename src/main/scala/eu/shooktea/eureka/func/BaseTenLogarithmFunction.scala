package eu.shooktea.eureka.func

import eu.shooktea.eureka.func.Function._

class BaseTenLogarithmFunction(f: Function) extends OneOpFunction(f) {
  override protected def calculateResult(a1: BigDecimal): BigDecimal = ln(a1) / ln(10)
  override def derivative(v: Variable): Function = f.d(v) / (f * ln(10))
}

object BaseTenLogarithmFunction {
  def apply(f: Function): BaseTenLogarithmFunction = new BaseTenLogarithmFunction(f)
}