package eu.shooktea.eureka.extension

trait LongExtension {
  implicit class LongExtensions(self: Long) extends AllExtensions.ConstantExtensions {
    override def toBigDecimal: BigDecimal = BigDecimal(self)
  }
}
