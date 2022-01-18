package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.DecimalNumber
import org.scalatest.funsuite.AnyFunSuite

class VariableTest extends AnyFunSuite {
  test("Applying value to a single variable returns that value") {
    val variable = Variable()
    val input = BigDecimal(3.4)
    val output = variable((variable, input))
    assert(DecimalNumber(input) == output)
  }
}
