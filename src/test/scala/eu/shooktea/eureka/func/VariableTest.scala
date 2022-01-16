package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.DecimalNumber
import org.scalatest.funsuite.AnyFunSuite

class VariableTest extends AnyFunSuite {
  test("Applying value to a single variable returns that value") {
    val variable = Variable()
    val input = DecimalNumber(3.4)
    val output = variable((variable, input))
    assert(input == output)
  }

  test("Creating abs function") {
    val v = Variable()
    val function = v.abs

    assert(function(v -> DecimalNumber(5.3)) == DecimalNumber(5.3))
    assert(function(v -> DecimalNumber(-7.1)) == DecimalNumber(7.1))
  }
}
