package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.IntegerNumber
import org.scalatest.funsuite.AnyFunSuite

class SubtractFunctionTest extends AnyFunSuite {
  test("Subtracting function") {
    val v1 = Variable()
    val v2 = Variable()
    val f = SubtractFunction(v1, v2)

    val result = f.apply(v1 -> IntegerNumber(3), v2 -> IntegerNumber(4))
    assert(result == IntegerNumber(-1))
  }
}
