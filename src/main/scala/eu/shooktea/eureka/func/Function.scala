package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.Constant

trait Function {
  def apply(args: (Variable, Constant)*): Constant = this(args.toMap)
  def apply(args: Map[Variable,Constant]): Constant

  def abs: Function = AbsoluteValueFunction(this)
}
