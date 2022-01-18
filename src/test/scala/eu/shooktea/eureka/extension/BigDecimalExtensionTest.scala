package eu.shooktea.eureka.extension

import eu.shooktea.eureka.constant._
import eu.shooktea.eureka.extension.AllExtensions._
import org.scalatest.funsuite.AnyFunSuite

class BigDecimalExtensionTest extends AnyFunSuite {
  test("Converting to decimal number") {
    assert(BigDecimal(4.3).toDecimalNumber == DecimalNumber(4.3))
  }

  test("Operations with constants") {
    assert(BigDecimal(4.3) + DecimalNumber(5) == DecimalNumber(9.3))
  }
}
