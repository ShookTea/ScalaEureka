package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.DecimalNumber
import org.scalatest.funsuite.AnyFunSuite

class ConstantFunctionTest extends AnyFunSuite {
  test("Constant function returns itself") {
    val const = DecimalNumber(15)
    val func = ConstantFunction(const)
    assert(func() == const)
  }
}
