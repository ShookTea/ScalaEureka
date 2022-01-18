package eu.shooktea.eureka.func

import org.scalatest.funsuite.AnyFunSuite

class SubtractFunctionTest extends AnyFunSuite {
  test("Subtracting function") {
    val v1 = Variable()
    val v2 = Variable()
    val f = SubtractFunction(v1, v2)

    assert(f(v1 -> 3, v2 -> 4) == -1)
  }
}
