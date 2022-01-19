package eu.shooktea.eureka.func

class NaturalLogarithmFunction(f: Function) extends OneOpFunction(f) {
  override protected def calculateResult(x: BigDecimal): BigDecimal = {
    if (x.signum <= 0) {
      throw new ArithmeticException("Cannot calculate natural logarithm of non-positive value")
    }

    // convert x => a * 10^b
    val unscaled = BigDecimal(x.bigDecimal.unscaledValue())
    val scale = -x.scale // BigDecimal stores number as unscaledValue * 10^-scale, so - is necessary here

    val digitsCount = unscaled.toString().length
    val a = unscaled / BigDecimal(10).pow(digitsCount)
    val b = scale + digitsCount

    // using the fact that ln(x) = ln(a * 10^b) = ln(a) + b * ln(10)
    // "a" is now a number between 0 and 1

    val lnA = BigDecimal(Math log a.doubleValue)
    val ln10 = BigDecimal(Math log 10)

    lnA + b * ln10
  }
  override def derivative(v: Variable): Function = f.d(v) / f
}

object NaturalLogarithmFunction {
  def apply(f: Function): NaturalLogarithmFunction = new NaturalLogarithmFunction(f)
}
