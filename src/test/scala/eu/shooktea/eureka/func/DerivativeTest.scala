package eu.shooktea.eureka.func

import org.scalatest.funsuite.AnyFunSuite
import eu.shooktea.eureka.extension.AllExtensions._

class DerivativeTest extends AnyFunSuite {
  test("Building simple derivative") {
    val x = Variable()

    val f = x * x - 6 * x + 8
    assert(f(x -> 3) == -1)
    assert(f(x -> 4) == 0)
    assert(f(x -> 5) == 3)

    val df = f.d(x)
    assert(df(x -> 3) == 0)
    assert(df(x -> 4) == 2)
    assert(df(x -> 5) == 4)
  }

  test("Partial derivatives") {
    val x = Variable()
    val y = Variable()

    val f = x * x * y * y
    for (i <- -5 to 5; j <- -5 to 5) {
      val result = f(x -> i, y -> j)
      val expected = i * i * j * j
      assert(result == expected)
    }

    val fdx = f d x
    for (i <- -5 to 5; j <- -5 to 5) {
      val result = fdx(x -> i, y -> j)
      val expected = 2 * i * j * j
      assert(result == expected)
    }

    val fdy = f d y
    for (i <- -5 to 5; j <- -5 to 5) {
      val result = fdy(x -> i, y -> j)
      val expected = 2 * i * i * j
      assert(result == expected)
    }
  }
}
