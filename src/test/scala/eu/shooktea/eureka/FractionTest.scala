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

  test("Converting to double") {
    assert(Fraction(1, 4).toDouble == 0.25)
  }

  test("Rounding to integers") {
    assert(Fraction(5, 3).roundToInt == 2)
  }

  test("Comparing two fractions") {
    assert(Fraction(-8, 12) == Fraction(-2, 3))
    assert(Fraction(-8, 12) != Fraction(1, 5))
  }

  test("Mixed number created properly") {
    assert(Fraction(1, 2, 3) == Fraction(5, 3))
  }
}
