package eu.shooktea.eureka.func

abstract class PeriodicOneOpFunction(f1: Function, period: BigDecimal) extends OneOpFunction(f1) {
  override protected def calculateResult(a: BigDecimal): BigDecimal =
    calculateAfterPeriodReduction(a % period)

  protected def calculateAfterPeriodReduction(a: BigDecimal): BigDecimal
}
