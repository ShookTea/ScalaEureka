package eu.shooktea.eureka.extension

import eu.shooktea.eureka.constant.DecimalNumber
import eu.shooktea.eureka.extension.AllExtensions._
import org.scalatest.funsuite.AnyFunSuite

class DoubleExtensionTest extends AnyFunSuite {
  test("Converting to decimal number") {
    assert((-5.7).toDecimalNumber == DecimalNumber(-5.7))
  }
}
