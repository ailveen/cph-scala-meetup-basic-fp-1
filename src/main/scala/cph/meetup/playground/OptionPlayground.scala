package cph.meetup.playground

object OptionPlayground extends App {

  def mean(xs: Seq[Double]): Double =
    if (xs.isEmpty)
      throw new ArithmeticException("mean of empty list!")
    else xs.sum / xs.length

  def meanLenient(xs: Seq[Double]): Double =
    xs.sum / xs.length

  // implement via Option
  def meanOption(xs: Seq[Double]): Double = ???

  Console println mean(Seq(2, 3, 4, 5))
  Console println mean(Seq(2, 3, 4, 5))

  val p = meanLenient(Seq())


}

case class