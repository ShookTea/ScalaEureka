package eu.shooktea.eureka.func

import eu.shooktea.eureka.constant.Constant

trait Function {
  def argumentsCount: Int
  def evaluate(constants: Constant*): Constant
}
