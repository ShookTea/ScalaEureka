package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.IntegerNumber
import org.scalatest.funsuite.AnyFunSuite

class AbsoluteValueFunctionTest extends AnyFunSuite {
  test("Evaluating absolute value function") {
    val v = Variable()
    val func = AbsoluteValueFunction(v)

    assert(func((v, IntegerNumber(5))) == IntegerNumber(5))
    assert(func((v, IntegerNumber(-3))) == IntegerNumber(3))
  }
}
