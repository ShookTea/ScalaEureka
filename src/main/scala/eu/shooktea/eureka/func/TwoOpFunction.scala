package eu.shooktea.eureka.func

abstract class TwoOpFunction(val f1: Function, val f2: Function) extends Function {
  protected def calculateResult(a1: BigDecimal, a2: BigDecimal): BigDecimal

  override def apply(args: Map[Variable, BigDecimal]): BigDecimal = calculateResult(
    f1(args),
    f2(args),
  )
}
