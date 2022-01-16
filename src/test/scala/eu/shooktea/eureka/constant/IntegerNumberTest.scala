package eu.shooktea.eureka.constant

import org.scalatest.funsuite.AnyFunSuite

class IntegerNumberTest extends AnyFunSuite {
  test("Creating from big int") {
    assert(IntegerNumber(BigInt(15)).integer == BigInt(15))
  }

  test("Creating from long") {
    assert(IntegerNumber(15).integer == BigInt(15))
  }

  test("Creating from string") {
    assert(IntegerNumber("15").integer == BigInt(15))
  }

  test("Comparing values") {
    assert(IntegerNumber("33") == IntegerNumber(33))
    assert(IntegerNumber(5) > IntegerNumber(4))
    assert(IntegerNumber(-3) < IntegerNumber(7.5))
    assert(IntegerNumber(5) >= IntegerNumber(3))
    assert(IntegerNumber(5) >= IntegerNumber(5))
    assert(IntegerNumber(5) <= IntegerNumber(5))
  }

  test("Converting to decimal number") {
    assert(IntegerNumber("33").toDecimalNumber == DecimalNumber(33.0))
  }

  test("Converting to integer number") {
    assert(IntegerNumber(33).toIntegerNumber == IntegerNumber(33))
  }

  test("Adding integers") {
    assert(IntegerNumber(15) + IntegerNumber(33) == IntegerNumber(48))
  }

  test("Subtracting integers") {
    assert(IntegerNumber(15) - IntegerNumber(33) == IntegerNumber(-18))
  }

  test("Multiplying integers") {
    assert(IntegerNumber(15) * IntegerNumber(33) == IntegerNumber(495))
  }

  test("Dividing integers") {
    assert(IntegerNumber(6) / IntegerNumber(3) == IntegerNumber(2))
    assert(IntegerNumber(6) / IntegerNumber(4) == DecimalNumber(1.5))
  }

  test("Calculating GCD") {
    assert((IntegerNumber(5) gcd IntegerNumber(1)) == IntegerNumber(1))
    assert((IntegerNumber(4) gcd IntegerNumber(6)) == IntegerNumber(2))
  }

  test("Calculating LCM") {
    assert((IntegerNumber(3) lcm IntegerNumber(5)) == IntegerNumber(15))
    assert((IntegerNumber(6) lcm IntegerNumber(8)) == IntegerNumber(24))
  }

  test("Mixed operations with decimal numbers") {
    assert(IntegerNumber(5) == DecimalNumber(5))
    assert(IntegerNumber(5) + DecimalNumber(3) == IntegerNumber(8))
    assert(IntegerNumber(3) - DecimalNumber(0.2) == DecimalNumber(2.8))
    assert(IntegerNumber(3) * DecimalNumber(0.2) == DecimalNumber(0.6))
    assert(IntegerNumber(3) / DecimalNumber(0.1) == DecimalNumber(30))
  }

  test("Calculating negation") {
    assert(-IntegerNumber(5) == IntegerNumber(-5))
  }

  test("Calculating reciprocal") {
    assert(IntegerNumber(25).reciprocal == DecimalNumber(0.04))
  }
}
