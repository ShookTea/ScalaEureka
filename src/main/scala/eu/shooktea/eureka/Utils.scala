package eu.shooktea.eureka

import scala.annotation.tailrec

object Utils {
  @tailrec
  def greatestCommonDivisor(a: Int, b: Int): Int =
    if (b == 0) a
    else greatestCommonDivisor(b, a % b)
}
