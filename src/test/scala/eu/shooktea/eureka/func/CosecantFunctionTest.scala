package eu.shooktea.eureka.func

import eu.shooktea.eureka.func.Function._
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class CosecantFunctionTest extends AnyFunSuite {
  test("Calculating csc(x)") {
    val x = Variable()
    val f = csc(x)

    for (i <- 0 until 100) {
      val radians = (i + 0.5) * Math.PI / 21.0
      val expected = 1.0 / Math.sin(radians)
      val result = f(x -> radians)

      result.doubleValue should be (expected +- 0.001)
    }
  }

  test("Derivative of csc(x)") {
    val x = Variable()
    val f = csc(x)
    val df = f d x

    for (i <- 0 until 100) {
      val radians = (i + 0.5) * Math.PI / 21.0
      val expected = -1.0 / (Math.sin(radians) * Math.tan(radians))
      val result = df(x -> radians)

      result.doubleValue should be (expected +- 0.001)
    }
  }
}
