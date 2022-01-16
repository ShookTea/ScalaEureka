package eu.shooktea.eureka.extension

import eu.shooktea.eureka.constant._
import eu.shooktea.eureka.extension.AllExtensions._
import org.scalatest.funsuite.AnyFunSuite

class LongExtensionTest extends AnyFunSuite {
  test("Converting to decimal number") {
    assert(5.toDecimalNumber == DecimalNumber(5))
  }

  test("Converting to integer number") {
    assert(5.toIntegerNumber == IntegerNumber(5))
  }
}
