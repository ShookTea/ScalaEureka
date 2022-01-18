package eu.shooktea.eureka.func

import org.scalatest.funsuite.AnyFunSuite

class VariableTest extends AnyFunSuite {
  test("Applying value to a single variable returns that value") {
    val v = Variable()
    assert(v(v -> 3.4) == 3.4)
  }
}
