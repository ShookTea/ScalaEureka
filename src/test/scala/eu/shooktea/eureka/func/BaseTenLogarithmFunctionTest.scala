package eu.shooktea.eureka.func

import eu.shooktea.eureka.func.Function._
import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class BaseTenLogarithmFunctionTest extends AnyFunSuite {
  test("Calculating logarithm") {
    val x = Variable()
    val f = log(x)
    for (value <- 1 to 500) {
      val realValue = value / 10.0
      val expectedResult = Math log10 realValue
      val result = f(x -> realValue)
      result.doubleValue should be (expectedResult +- 0.01)
    }
  }

  test("Calculating simple derivative") {
    val x = Variable()
    val f = log(x)
    val df = f d x

    for (value <- 1 to 500) {
      val realValue = value / 10.0
      val expectedResult = 1.0 / (realValue * Math.log(10))
      df(x -> realValue).doubleValue should be (expectedResult +- 0.01)
    }
  }

  test("Calculating more advanced derivatives") {
    val x = Variable()
    val y = Variable()
    val f = log(abs(x * y + 1.0))
    val fdx = f d x
    // expected: fdx(x,y) = y / (x*y*ln(10) + ln(10))
    val fdy = f d y
    // expected: fdy(x,y) = x / (x*y*ln(10) + ln(10))

    for (valueX <- 1 to 100; valueY <- 1 to 100) {
      val realValueX = valueX / 5.0
      val realValueY = valueY / 5.0
      val expectedFdxResult = realValueY / (realValueX * realValueY * Math.log(10) + Math.log(10))
      val expectedFdyResult = realValueX / (realValueX * realValueY * Math.log(10) + Math.log(10))

      fdx(x -> realValueX, y -> realValueY).doubleValue should be (expectedFdxResult +- 0.01)
      fdy(x -> realValueX, y -> realValueY).doubleValue should be (expectedFdyResult +- 0.01)
    }
  }
}
