package cph.meetup.datastructures

object OptionPlayground extends App {

  def mean(xs: Seq[Double]): Double =
    if (xs.isEmpty)
      throw new ArithmeticException("mean of empty list!")
    else xs.sum / xs.length

  def meanLenient(xs: Seq[Double]): Double = ???

  // implement via Option
  def meanOption(xs: Seq[Double]): Double = ???












  // lifting
  def Try[A](a: => A): Option[A] = ???

}
