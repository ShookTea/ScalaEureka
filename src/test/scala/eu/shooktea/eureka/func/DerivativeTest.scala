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

    val df = f.derivative
    assert(df(x -> 3) == 0)
    assert(df(x -> 4) == 2)
    assert(df(x -> 5) == 4)
  }
}
