package eu.shooktea.eureka.func

import eu.shooktea.eureka.Constants
import eu.shooktea.eureka.func.Function._
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class ExpFunctionTest extends AnyFunSuite {
  test("Proper calculation of Euler's number") {
    Constants.E.doubleValue should be (Math.E +- 0.0001)
  }

  test("Calculating exp(x) values") {
    val x = Variable()
    val f = exp(x)

    for (value <- -100 to 100) {
      val realValue = value / 10.0
      val expectedResult = Math.exp(realValue)
      val result = f(x -> realValue)
      result.doubleValue should be (expectedResult +- 0.0001)
    }
  }

  test("simple derivative") {
    val x = Variable()
    val f = exp(x)
    val df = f d x
    // df(x) = exp(x)

    for (value <- -100 to 100) {
      val realValue = value / 10.0
      val expectedResult = Math.exp(realValue)
      val result = df(x -> realValue)
      result.doubleValue should be (expectedResult +- 0.0001)
    }
  }

  test("more advanced derivatives") {
    val x = Variable()
    val f = exp(exp(x))
    val df = f d x
    // df(x) = exp(x + exp(x))

    for (value <- -10 to 10) {
      val realValue = value / 10.0
      val expectedResult = Math.exp(realValue + Math.exp(realValue))
      val result = df(x -> realValue)
      result.doubleValue should be (expectedResult +- 0.001)
    }
  }
}
