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

  test("Mixed operations with decimal numbers") {
    assert(IntegerNumber(5) == DecimalNumber(5))
    assert(IntegerNumber(5) + DecimalNumber(3) == IntegerNumber(8))
    assert(IntegerNumber(3) - DecimalNumber(0.2) == DecimalNumber(2.8))
    assert(IntegerNumber(3) * DecimalNumber(0.2) == DecimalNumber(0.6))
  }
}
