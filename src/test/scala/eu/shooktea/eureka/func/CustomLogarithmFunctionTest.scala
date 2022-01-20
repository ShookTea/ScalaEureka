package eu.shooktea.eureka.func

import eu.shooktea.eureka.func.Function._
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class CustomLogarithmFunctionTest extends AnyFunSuite {
  test("Calculating logarithm") {
    val x = Variable()
    val f = log(2, x)
    for (value <- 1 to 500) {
      val realValue = value / 10.0
      val expectedResult = (Math log realValue) / (Math log 2)
      val result = f(x -> realValue)
      result.doubleValue should be (expectedResult +- 0.01)
    }
  }

  test("Calculating simple derivative") {
    val x = Variable()
    val f = log(2, x)
    val df = f d x

    for (value <- 1 to 500) {
      val realValue = value / 10.0
      val expectedResult = 1.0 / (realValue * Math.log(2))
      df(x -> realValue).doubleValue should be (expectedResult +- 0.01)
    }
  }

  test("Calculating more advanced derivatives") {
    val x = Variable()
    val y = Variable()
    val f = log(x, abs(y - 10))
    val fdx = f d x
    // expected: fdx(x,y) = - ln(y - 10) / (x * ln(x)^2)
    val fdy = f d y
    // expected: fdy(x,y) = 1 / ((y - 10) * ln(x))

    for (valueX <- 55 to 150; valueY <- 55 to 150) {
      val realValueX = valueX / 5.0
      val realValueY = valueY / 5.0
      val expectedFdxResult = - Math.log(realValueY - 10) / (realValueX * Math.pow(Math.log(realValueX), 2))
      val expectedFdyResult = 1 / ((realValueY - 10) * Math.log(realValueX))

      fdx(x -> realValueX, y -> realValueY).doubleValue should be (expectedFdxResult +- 0.01)
      fdy(x -> realValueX, y -> realValueY).doubleValue should be (expectedFdyResult +- 0.01)
    }
  }
}
