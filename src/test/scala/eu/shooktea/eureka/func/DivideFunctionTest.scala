package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.{DecimalNumber, IntegerNumber}
import org.scalatest.funsuite.AnyFunSuite

class DivideFunctionTest extends AnyFunSuite {
  test("Dividing function") {
    val v1 = Variable()
    val v2 = Variable()
    val f = DivideFunction(v1, v2)

    val result = f.apply(v1 -> IntegerNumber(3), v2 -> IntegerNumber(4))
    assert(result == DecimalNumber(0.75))
  }
}
