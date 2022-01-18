package eu.shooktea.eureka.func

import org.scalatest.funsuite.AnyFunSuite

class ConstantFunctionTest extends AnyFunSuite {
  test("Constant function returns itself") {
    val const = BigDecimal(15)
    val func = ConstantFunction(const)
    assert(func() == const)
  }
}
