package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.IntegerNumber
import org.scalatest.funsuite.AnyFunSuite
import eu.shooktea.eureka.extension.AllExtensions._
import eu.shooktea.eureka.func.Function._

class FunctionConstructingTest extends AnyFunSuite {
  test("Building sample function with arithmetics") {
    val x = Variable()
    val y = Variable()

    val func = -1 * abs(x + y) + 5
    val result = func(
      x -> IntegerNumber(-1),
      y -> IntegerNumber(-2),
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
      x -> IntegerNumber(-3),
      y -> IntegerNumber(15),
    )

    assert(result == 29.5)
  }
}
