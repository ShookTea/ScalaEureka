package eu.shooktea.eureka.func

import eu.shooktea.eureka.Constants
import eu.shooktea.eureka.func.Function._

class SineFunction(f1: Function) extends PeriodicOneOpFunction(f1, Constants.PI * 2) {
  override protected def calculateAfterPeriodReduction(a: BigDecimal): BigDecimal =
    Math sin a.doubleValue

  override def derivative(v: Variable): Function = f1.d(v) * cos(f1)
}

object SineFunction {
  def apply(f1: Function): SineFunction = new SineFunction(f1)
}
