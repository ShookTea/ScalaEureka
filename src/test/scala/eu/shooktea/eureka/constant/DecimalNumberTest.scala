package eu.shooktea.eureka.constant

import org.scalatest.funsuite.AnyFunSuite

class DecimalNumberTest extends AnyFunSuite {
  test("Creating from big decimal") {
    val decimal = DecimalNumber(BigDecimal(-15.25))
    assert(decimal.decimal == BigDecimal(-15.25))
    assert(decimal.toBigDecimal == BigDecimal(-15.25))
    assert(decimal.roundToBigInt == BigInt(-15))
  }

  test("Creating from big integer") {
    val decimal = DecimalNumber(BigInt(13))
    assert(decimal.decimal == BigDecimal(13))
    assert(decimal.toBigDecimal == BigDecimal(13))
    assert(decimal.roundToBigInt == BigInt(13))
  }

  test("Creating from double") {
    val decimal = DecimalNumber(-15.75)
    assert(decimal.decimal == BigDecimal(-15.75))
    assert(decimal.toBigDecimal == BigDecimal(-15.75))
    assert(decimal.roundToBigInt == BigInt(-16))
  }

  test("Creating from long") {
    val decimal = DecimalNumber(Long.MaxValue)
    assert(decimal.decimal == BigDecimal(Long.MaxValue))
    assert(decimal.toBigDecimal == BigDecimal(Long.MaxValue))
    assert(decimal.roundToBigInt == BigInt(Long.MaxValue))
  }

  test("Creating from string") {
    val decimal = DecimalNumber("0.3")
    assert(decimal.decimal == BigDecimal("0.3"))
    assert(decimal.toBigDecimal == BigDecimal("0.3"))
    assert(decimal.roundToBigInt == BigInt(0))
  }

  test("Comparing decimal numbers") {
    assert(DecimalNumber(5.3) == DecimalNumber("5.3"))
    assert(DecimalNumber(-3.5) != DecimalNumber("5.3"))
  }

  test("to decimal number conversion returns self") {
    assert(DecimalNumber(5.3).toDecimalNumber == DecimalNumber(5.3))
  }

  test("adding decimal numbers") {
    assert(DecimalNumber(5.3) + DecimalNumber(0.7) == DecimalNumber(6.0))
  }

  test("adding integer") {
    assert(DecimalNumber(5.3) + 7 == DecimalNumber(12.3))
  }
}
