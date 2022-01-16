package eu.shooktea.eureka

import org.scalatest.funsuite.AnyFunSuite
import eu.shooktea.eureka.TypeExtensions._
import eu.shooktea.eureka.constant._

class TypeExtensionsTest extends AnyFunSuite {
  test("Adding fraction to int") {
    assert(1 + Fraction(2, 3) == Fraction(1, 2, 3))
  }
}
