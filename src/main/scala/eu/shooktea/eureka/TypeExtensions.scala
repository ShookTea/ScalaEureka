package eu.shooktea.eureka

import eu.shooktea.eureka.constant.Fraction

object TypeExtensions {
  implicit class IntExtension(val i: Int) {
    def +(f: Fraction): Fraction = f + i
  }
}
