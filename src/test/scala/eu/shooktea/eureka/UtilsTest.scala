package eu.shooktea.eureka

import org.scalatest.funsuite.AnyFunSuite

class UtilsTest extends AnyFunSuite {
  test("Greatest common divisor") {
    assert(Utils.greatestCommonDivisor(5, 1) == 1)
    assert(Utils.greatestCommonDivisor(4, 6) == 2)
  }
}
