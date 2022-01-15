package eu.shooktea.eureka

object TypeExtensions {
  implicit class IntExtension(val i: Int) {
    def +(f: Fraction): Fraction = f + i
  }
}
