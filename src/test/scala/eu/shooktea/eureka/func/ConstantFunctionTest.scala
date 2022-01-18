package eu.shooktea.eureka.func

import org.scalatest.funsuite.AnyFunSuite

class ConstantFunctionTest extends AnyFunSuite {
  test("Constant function returns itself") {
    val func = ConstantFunction(15)
    assert(func() == 15)
  }
}
