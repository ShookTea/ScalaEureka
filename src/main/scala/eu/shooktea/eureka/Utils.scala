package eu.shooktea.eureka

import scala.annotation.tailrec

object Utils {
  @tailrec
  def greatestCommonDivisor(a: Int, b: Int): Int =
    if (b == 0) a
    else greatestCommonDivisor(b, a % b)

  def leastCommonMultiple(a: Int, b: Int): Int =
    if (a == 0 && b == 0) 0
    else Math.abs(a * b) / greatestCommonDivisor(a, b)
}
