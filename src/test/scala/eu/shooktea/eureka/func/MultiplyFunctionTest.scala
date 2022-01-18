package eu.shooktea.eureka.func

import org.scalatest.funsuite.AnyFunSuite

class MultiplyFunctionTest extends AnyFunSuite {
  test("Multiplying values") {
    val x = Variable()
    val y = Variable()
    val f = MultiplyFunction(x, y)

    assert(f(x -> 3, y -> 2.5) == 7.5)
  }
}
