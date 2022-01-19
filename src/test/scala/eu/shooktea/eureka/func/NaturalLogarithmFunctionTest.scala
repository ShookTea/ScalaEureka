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

  test("Calculating simple derivative") {
    val x = Variable()
    val f = ln(x)
    val df = f d x

    for (value <- 1 to 500) {
      val realValue = value / 10.0
      val expectedResult = 1.0 / realValue
      df(x -> realValue).doubleValue should be (expectedResult +- 0.01)
    }
  }

  test("Calculating more advanced derivatives") {
    val x = Variable()
    val y = Variable()
    val f = ln(abs(x * y + 1.0))
    val fdx = f d x
    // expected: fdx(x,y) = y / (x*y + 1)
    val fdy = f d y
    // expected: fdy(x,y) = x / (x*y + 1)

    for (valueX <- 1 to 100; valueY <- 1 to 100) {
      val realValueX = valueX / 5.0
      val realValueY = valueY / 5.0
      val expectedFdxResult = realValueY / (realValueX * realValueY + 1.0)
      val expectedFdyResult = realValueX / (realValueX * realValueY + 1.0)

      fdx(x -> realValueX, y -> realValueY).doubleValue should be (expectedFdxResult +- 0.01)
      fdy(x -> realValueX, y -> realValueY).doubleValue should be (expectedFdyResult +- 0.01)
    }
  }
}
