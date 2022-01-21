package eu.shooktea.eureka.func

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._
import eu.shooktea.eureka.extension.AllExtensions._

class PowerFunctionTest extends AnyFunSuite {
  test("Calculating powers") {
    val x = Variable()
    val y = Variable()
    val f = x ^ y

    for (xval <- 5 to 100; yval <- -10 to 10) {
      val realX = xval / 10.0
      val realY = yval / 5.0

      val expected = Math.pow(realX, realY)
      val result = f(x -> realX, y -> realY)
      result.doubleValue should be (expected +- 0.001)
    }
  }

  test("Calculating derivative") {
    val x = Variable()
    val f = 2 * (x ^ 3)
    val df = f d x
    // df(x) = 6x^2

    for (v <- 5 to 100) {
      val realX = v / 10.0
      val expected = 6.0 * Math.pow(realX, 2.0)
      val result = df(x -> realX)

      result.doubleValue should be (expected +- 0.001)
    }
  }
}
