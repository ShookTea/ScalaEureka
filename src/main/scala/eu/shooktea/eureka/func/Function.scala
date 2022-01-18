package eu.shooktea.eureka.func

trait Function {
  def apply(args: (Variable, Any)*): BigDecimal =
    apply(args.map {
      case (k, v) => (k, v match {
        case v: BigInt => BigDecimal(v)
        case v: Long => BigDecimal(v)
        case v: Int => BigDecimal(v)
        case v: Short => BigDecimal(v)
        case v: Byte => BigDecimal(v)
        case v: BigDecimal => v
        case v: Double => BigDecimal(v)
        case v: Float => BigDecimal(v)
      })
    }.toMap)

  def apply(args: Map[Variable,BigDecimal]): BigDecimal
  def derivative(v: Variable): Function
  def d(v: Variable): Function = derivative(v)

  def +(other: Function): Function = AddFunction(this, other)
  def +(other: BigDecimal): Function = this + ConstantFunction(other)
  def +(other: BigInt): Function = this + BigDecimal(other)
  def +(other: Long): Function = this + BigDecimal(other)
  def +(other: Double): Function = this + BigDecimal(other)

  def -(other: Function): Function = SubtractFunction(this, other)
  def -(other: BigDecimal): Function = this - ConstantFunction(other)
  def -(other: BigInt): Function = this - BigDecimal(other)
  def -(other: Long): Function = this - BigDecimal(other)
  def -(other: Double): Function = this - BigDecimal(other)

  def *(other: Function): Function = MultiplyFunction(this, other)
  def *(other: BigDecimal): Function = this * ConstantFunction(other)
  def *(other: BigInt): Function = this * BigDecimal(other)
  def *(other: Long): Function = this * BigDecimal(other)
  def *(other: Double): Function = this * BigDecimal(other)

  def /(other: Function): Function = DivideFunction(this, other)
  def /(other: BigDecimal): Function = this / ConstantFunction(other)
  def /(other: BigInt): Function = this / BigDecimal(other)
  def /(other: Long): Function = this / BigDecimal(other)
  def /(other: Double): Function = this / BigDecimal(other)
}

object Function {
  def abs(f: Function): Function = AbsoluteValueFunction(f)
  def abs(d: BigDecimal): BigDecimal = d.abs
  def abs(i: BigInt): BigDecimal = abs(BigDecimal(i))
  def abs(l: Long): BigDecimal = abs(BigDecimal(l))
  def abs(d: Double): BigDecimal = abs(BigDecimal(d))
}
