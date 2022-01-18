package eu.shooktea.eureka.extension

trait DoubleExtension {
  implicit class DoubleExtensions(self: Double) extends AllExtensions.ConstantExtensions {
    override def toBigDecimal: BigDecimal = BigDecimal(self)
  }
}
