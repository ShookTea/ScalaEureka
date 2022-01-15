package eu.shooktea.eureka

import org.scalatest.funsuite.AnyFunSuite

class FractionTest extends AnyFunSuite {
  test("Fraction created properly") {
    val fraction = Fraction(5, 3)
    assert(5 == fraction.numerator)
    assert(3 == fraction.denominator)
  }

  test("Normalization of double-negative values") {
    val fraction = Fraction(-7, -2)
    assert(7 == fraction.numerator)
    assert(2 == fraction.denominator)
  }

  test("Normalization of negative denominator into negative numerator") {
    val fraction = Fraction(5, -7)
    assert(-5 == fraction.numerator)
    assert(7 == fraction.denominator)
  }

  test("Reducing greatest common divisors") {
    val fraction = Fraction(-8, 12)
    assert(-2 == fraction.numerator)
    assert(3 == fraction.denominator)
  }
}
