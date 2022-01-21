package eu.shooktea.eureka.func

import eu.shooktea.eureka.func.Function._

class ExpFunction(f1: Function, iterations: Int) extends OneOpFunction(f1) {
  if (iterations < 1) {
    throw new ArithmeticException("Iterations in Exp function must be a positive integer")
  }

  override protected def calculateResult(a1: BigDecimal): BigDecimal = {
    // Using Horner's method:
    // e^x = 1 + x * (1 + x/2 * (1 + x/3 * (1 + x/4 * (... * (1 + x/iterations)))
    // approximation here stops at s
    var c = BigDecimal(1)
    for (i <- iterations to 1 by -1)
      c = c * (a1 / i) + 1
    c
  }

  override def derivative(v: Variable): Function = f1.d(v) * exp(f1, iterations)
}

object ExpFunction {
  def apply(f1: Function, iterations: Int): ExpFunction = new ExpFunction(f1, iterations)
}
