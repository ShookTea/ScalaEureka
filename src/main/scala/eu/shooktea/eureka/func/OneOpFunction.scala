package eu.shooktea.eureka.func

abstract class OneOpFunction(val f1: Function) extends Function {
  protected def calculateResult(a1: BigDecimal): BigDecimal
  override def apply(args: Map[Variable, BigDecimal]): BigDecimal = calculateResult(f1(args))
}
