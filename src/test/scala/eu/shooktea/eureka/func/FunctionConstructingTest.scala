package eu.shooktea.eureka.func

import org.scalatest.funsuite.AnyFunSuite
import eu.shooktea.eureka.extension.AllExtensions._
import eu.shooktea.eureka.func.Function._

class FunctionConstructingTest extends AnyFunSuite {
  test("Building sample function with arithmetics") {
    val x = Variable()
    val y = Variable()

    val func = -1 * abs(x + y) + 5
    val result = func(
      x -> -1,
      y -> -2,
    )

    assert(result == 2)
  }

  test("Composing functions") {
    val x = Variable()
    val y = Variable()

    val func1 = -1 * abs(x + y) + 5
    val func2 = 3 * x + 5 * y
    val f = (func1 + func2) * 0.5

    val result = f(
      x -> -3,
      y -> 15,
    )

    assert(result == 29.5)
  }
}
