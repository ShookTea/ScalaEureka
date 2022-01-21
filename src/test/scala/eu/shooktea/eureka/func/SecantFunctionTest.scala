package eu.shooktea.eureka.func

import eu.shooktea.eureka.func.Function._
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class SecantFunctionTest extends AnyFunSuite {
  test("Calculating sec(x)") {
    val x = Variable()
    val f = sec(x)

    for (i <- 0 until 100) {
      val radians = i * Math.PI / 21.0
      val expected = 1.0 / Math.cos(radians)
      val result = f(x -> radians)

      result.doubleValue should be (expected +- 0.001)
    }
  }

  test("Derivative of sec(x)") {
    val x = Variable()
    val f = sec(x)
    val df = f d x

    for (i <- 0 until 100) {
      val radians = i * Math.PI / 21.0
      val expected = Math.tan(radians) / Math.cos(radians)
      val result = df(x -> radians)

      result.doubleValue should be (expected +- 0.001)
    }
  }
}
