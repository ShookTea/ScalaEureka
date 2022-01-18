package eu.shooktea.eureka.func

import org.scalatest.funsuite.AnyFunSuite

class DivideFunctionTest extends AnyFunSuite {
  test("Dividing function") {
    val v1 = Variable()
    val v2 = Variable()
    val f = DivideFunction(v1, v2)

    val result = f.apply(v1 -> 3, v2 -> 4)
    assert(result == 0.75)
  }
}
