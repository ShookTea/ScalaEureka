package eu.shooktea.eureka.extension

trait BigIntExtension {
  implicit class BigIntExtensions(self: BigInt) extends AllExtensions.ConstantExtensions {
    override def toBigDecimal: BigDecimal = BigDecimal(self)
  }
}
