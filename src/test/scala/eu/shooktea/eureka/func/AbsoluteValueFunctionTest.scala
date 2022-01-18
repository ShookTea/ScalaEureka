package eu.shooktea.eureka.func

import org.scalatest.funsuite.AnyFunSuite

class AbsoluteValueFunctionTest extends AnyFunSuite {
  test("Evaluating absolute value function") {
    val v = Variable()
    val func = AbsoluteValueFunction(v)

    assert(func(v -> 5) == 5)
    assert(func(v -> -3) == 3)
  }
}
