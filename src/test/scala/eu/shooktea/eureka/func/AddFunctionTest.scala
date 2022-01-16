package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.IntegerNumber
import org.scalatest.funsuite.AnyFunSuite

class AddFunctionTest extends AnyFunSuite {
  test("Adding function") {
    val v1 = Variable()
    val v2 = Variable()
    val f = AddFunction(v1, v2)

    val result = f.apply(v1 -> IntegerNumber(3), v2 -> IntegerNumber(4))
    assert(result == IntegerNumber(7))
  }
}
