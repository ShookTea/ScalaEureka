package eu.shooktea.eureka.extension

import eu.shooktea.eureka.constant._
import eu.shooktea.eureka.extension.AllExtensions._
import org.scalatest.funsuite.AnyFunSuite

class BigIntExtensionTest extends AnyFunSuite {
  test("Converting to decimal number") {
    assert(BigInt(5).toDecimalNumber == DecimalNumber(5))
  }
}
