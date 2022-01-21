package eu.shooktea.eureka.func

import eu.shooktea.eureka.Constants
import eu.shooktea.eureka.func.Function._

class TangentFunction(f1: Function) extends PeriodicOneOpFunction(f1, Constants.PI) {
  override protected def calculateAfterPeriodReduction(a: BigDecimal): BigDecimal =
    Math tan a.doubleValue

  override def derivative(v: Variable): Function = f1.d(v) * ((tan(f1) * tan(f1)) + 1)
}

object TangentFunction {
  def apply(f1: Function): TangentFunction = new TangentFunction(f1)
}
