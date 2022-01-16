package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.IntegerNumber
import org.scalatest.funsuite.AnyFunSuite

class FunctionConstructingTest extends AnyFunSuite {
  test("Building sample function with arithmetics") {
    val x = Variable()
    val y = Variable()

    val func = (x + y).abs + IntegerNumber(-5)
    assert(func(x -> IntegerNumber(-3), y -> IntegerNumber(-6)) == IntegerNumber(4))
  }
}
