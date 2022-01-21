package eu.shooktea.eureka.func

import eu.shooktea.eureka.func.Function._
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class CotangentFunctionTest extends AnyFunSuite {
  test("Calculating cot(x)") {
    val x = Variable()
    val f = cot(x)

    for (i <- 1 until 100) {
      val radians = (i + 0.5) * Math.PI / 21.0
      val expected = 1.0 / Math.tan(radians)
      val result = f(x -> radians)

      result.doubleValue should be (expected +- 0.001)
    }
  }

  test("Derivative of cot(x)") {
    val x = Variable()
    val f = cot(x)
    val df = f d x

    for (i <- 1 until 100) {
      val radians = (i + 0.5) * Math.PI / 21.0
      val expected = -1.0 - (1.0 / Math.pow(Math.tan(radians), 2))
      val result = df(x -> radians)

      result.doubleValue should be (expected +- 0.001)
    }
  }
}
