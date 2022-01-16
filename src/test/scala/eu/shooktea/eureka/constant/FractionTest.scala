package eu.shooktea.eureka.constant

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

  test("Converting to decimal") {
    assert(Fraction(1, 4).toBigDecimal == BigDecimal(0.25))
  }

  test("Rounding to integer") {
    assert(Fraction(5, 3).roundToBigInt == BigInt(2))
  }

  test("Comparing two fractions") {
    assert(Fraction(-8, 12) == Fraction(-2, 3))
    assert(Fraction(-8, 12) != Fraction(1, 5))
  }

  test("Mixed number created properly") {
    assert(Fraction(1, 2, 3) == Fraction(5, 3))
  }

  test("Adding two fractions") {
    assert(Fraction(2, 3) + Fraction(3, 5) == Fraction(19, 15))
    assert(Fraction(5, 6) + Fraction(3, 8) == Fraction(29, 24))
  }

  test("Adding fraction and an integer") {
    assert(Fraction(2, 3) + 5 == Fraction(5, 2, 3))
  }
}
