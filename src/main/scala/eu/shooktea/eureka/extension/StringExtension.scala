package eu.shooktea.eureka.extension

trait StringExtension {
  implicit class StringExtensions(self: String) extends AllExtensions.ConstantExtensions {
    override def toBigDecimal: BigDecimal = BigDecimal(self)
  }
}
