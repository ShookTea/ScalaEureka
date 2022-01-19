package eu.shooktea.eureka.func

import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._
import eu.shooktea.eureka.func.Function._

class NaturalLogarithmFunctionTest extends AnyFunSuite {
  test("Calculating natural logarithm") {
    val x = Variable()
    val f = ln(x)
    for (value <- 1 to 500) {
      val realValue = value / 10.0
      val expectedResult = Math log realValue
      val result = f(x -> realValue)
      result.doubleValue should be (expectedResult +- 0.01)
    }
  }
}
