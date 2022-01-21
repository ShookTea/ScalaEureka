package eu.shooktea.eureka.func

import eu.shooktea.eureka.func.Function._
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class CosineFunctionTest extends AnyFunSuite {
  test("Calculating cos(x)") {
    val x = Variable()
    val f = cos(x)

    for (i <- 0 until 100) {
      val radians = i * Math.PI / 10.0
      val expected = Math.cos(radians)
      val result = f(x -> radians)

      result.doubleValue should be (expected +- 0.001)
    }
  }

  test("Derivative of cos(x)") {
    val x = Variable()
    val f = cos(x)
    val df = f d x

    for (i <- 0 until 100) {
      val radians = i * Math.PI / 10.0
      val expected = -Math.sin(radians)
      val result = df(x -> radians)

      result.doubleValue should be (expected +- 0.001)
    }
  }
}
