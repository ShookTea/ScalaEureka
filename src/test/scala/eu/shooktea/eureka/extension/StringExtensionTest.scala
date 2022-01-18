package eu.shooktea.eureka.extension

import eu.shooktea.eureka.constant._
import org.scalatest.funsuite.AnyFunSuite
import eu.shooktea.eureka.extension.AllExtensions._

class StringExtensionTest extends AnyFunSuite {
  test("Converting to decimal number") {
    assert("-15.33".toDecimalNumber == DecimalNumber("-15.33"))
  }
}
