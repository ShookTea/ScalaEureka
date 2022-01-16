package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.{DecimalNumber, IntegerNumber}
import org.scalatest.funsuite.AnyFunSuite

class MultiplyFunctionTest extends AnyFunSuite {
  test("Multiplying values") {
    val x = Variable()
    val y = Variable()
    val f = MultiplyFunction(x, y)

    assert(f(x -> IntegerNumber(3), y -> DecimalNumber(2.5)) == DecimalNumber(7.5))
  }
}
