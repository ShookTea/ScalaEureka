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
}
