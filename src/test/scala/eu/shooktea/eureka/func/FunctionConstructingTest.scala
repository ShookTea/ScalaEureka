package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.IntegerNumber
import org.scalatest.funsuite.AnyFunSuite
import eu.shooktea.eureka.extension.AllExtensions._

class FunctionConstructingTest extends AnyFunSuite {
  test("Building sample function with arithmetics") {
    val x = Variable()
    val y = Variable()

    val func = -1 * (x + y).abs + 5
    val result = func(
      x -> IntegerNumber(-1),
      y -> IntegerNumber(-2),
    )

    assert(result == IntegerNumber(2))
  }
}
