package eu.shooktea.eureka.func

import eu.shooktea.eureka.func.Function._
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class TangentFunctionTest extends AnyFunSuite {
  test("Calculating tan(x)") {
    val x = Variable()
    val f = tan(x)

    for (i <- 0 until 100) {
      val radians = i * Math.PI / 21.0
      println(i, radians, Math.toDegrees(radians))
      val expected = Math.tan(radians)
      val result = f(x -> radians)

      result.doubleValue should be (expected +- 0.001)
    }
  }

  test("Derivative of tan(x)") {
    val x = Variable()
    val f = tan(x)
    val df = f d x

    for (i <- 0 until 100) {
      val radians = i * Math.PI / 21.0
      val expected = 1.0 + Math.pow(Math.tan(radians), 2)
      val result = df(x -> radians)

      result.doubleValue should be (expected +- 0.001)
    }
  }
}
