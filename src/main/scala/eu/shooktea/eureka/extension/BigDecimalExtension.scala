package eu.shooktea.eureka.extension

trait BigDecimalExtension {
  implicit class BigDecimalExtensions(self: BigDecimal) extends AllExtensions.ConstantExtensions {
    override def toBigDecimal: BigDecimal = self
  }
}
