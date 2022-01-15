package eu.shooktea.eureka

class Fraction private(val numerator: Int, val denominator: Int) {
  def toDouble: Double = numerator.toDouble / denominator.toDouble
  def roundToInt: Int = Math.round(numerator.toFloat / denominator.toFloat)

  def add(f: Fraction): Fraction = {
    val lcm = Utils.leastCommonMultiple(f.denominator, denominator)
    Fraction(
      numerator * lcm / denominator + f.numerator * lcm / f.denominator,
      lcm
    )
  }
  def +(f: Fraction): Fraction = add(f)

  def add(i: Int): Fraction = Fraction(i, numerator, denominator)
  def +(i: Int): Fraction = add(i)

  override def equals(obj: Any): Boolean = obj match {
    case Fraction(num, den) => num == numerator && den == denominator
    case _ => false
  }
}

object Fraction {
  def apply(integer: Int, numerator: Int, denominator: Int): Fraction =
    Fraction(integer * denominator + numerator, denominator)

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

  def unapply(arg: Fraction): Option[(Int, Int)] = Some(arg.numerator, arg.denominator)
}
