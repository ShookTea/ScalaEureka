package eu.shooktea.eureka.func

import eu.shooktea.eureka.Constants
import eu.shooktea.eureka.func.Function._

class CosineFunction(f1: Function) extends PeriodicOneOpFunction(f1, Constants.PI * 2) {
  override protected def calculateAfterPeriodReduction(a: BigDecimal): BigDecimal =
    Math cos a.doubleValue

  override def derivative(v: Variable): Function = f1.d(v) * sin(f1) * -1
}

object CosineFunction {
  def apply(f1: Function): CosineFunction = new CosineFunction(f1)
}
