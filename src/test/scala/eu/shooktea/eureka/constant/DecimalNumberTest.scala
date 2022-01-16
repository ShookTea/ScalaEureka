package eu.shooktea.eureka.constant

import org.scalatest.funsuite.AnyFunSuite

class DecimalNumberTest extends AnyFunSuite {
  test("Creating from big decimal") {
    assert(DecimalNumber(BigDecimal(-15.25)).toBigDecimal == BigDecimal(-15.25))
  }
}
