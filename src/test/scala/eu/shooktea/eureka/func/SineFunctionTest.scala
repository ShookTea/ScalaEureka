package eu.shooktea.eureka.func

import eu.shooktea.eureka.func.Function._
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class SineFunctionTest extends AnyFunSuite {
  test("Calculating sin(x)") {
    val x = Variable()
    val f = sin(x)

    for (i <- 0 until 100) {
      val radians = i * Math.PI / 10.0
      val expected = Math.sin(radians)
      val result = f(x -> radians)

      result.doubleValue should be (expected +- 0.001)
    }
  }

  test("Derivative of sin(x)") {
    val x = Variable()
    val f = sin(x)
    val df = f d x

    for (i <- 0 until 100) {
      val radians = i * Math.PI / 10.0
      val expected = Math.cos(radians)
      val result = df(x -> radians)

      result.doubleValue should be (expected +- 0.001)
    }
  }
}
