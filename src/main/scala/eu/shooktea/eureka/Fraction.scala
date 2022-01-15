package eu.shooktea.eureka

class Fraction private(val numerator: Int, val denominator: Int) {
  def toDouble: Double = numerator.toDouble / denominator.toDouble
  def roundToInt: Int = Math.round(numerator.toFloat / denominator.toFloat)
}

object Fraction {
  def apply(numerator: Int, denominator: Int): Fraction =
    if (denominator == 0) throw new ArithmeticException("Division by zero")
    else {
      val gcd = Utils.greatestCommonDivisor(numerator, denominator)
      val numAfterGcd = numerator / gcd
      val denAfterGcd = denominator / gcd
      new Fraction(
        if (numAfterGcd < 0 && denAfterGcd < 0 || numAfterGcd > 0 && denAfterGcd < 0) -numAfterGcd
        else numAfterGcd,
        if (numAfterGcd < 0 && denAfterGcd < 0 || numAfterGcd > 0 && denAfterGcd < 0) -denAfterGcd
        else denAfterGcd,
      )
    }
}
