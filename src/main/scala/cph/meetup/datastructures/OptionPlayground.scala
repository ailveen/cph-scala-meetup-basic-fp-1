package cph.meetup.datastructures

object OptionPlayground extends App {

  // bad because the client will need to catch the Runtime exception
  def mean(xs: Seq[Double]): Double =
    if (xs.isEmpty)
      throw new ArithmeticException("mean of empty list!")
    else xs.sum / xs.length

  // Bad due to many reasons.
  // This will return a Double.Nan which will allow errors to silently propagate if the client FORGETS to check the value
  // It forces the client to have boilerplate if-checks if the value is a Nan
  // Sometimes a sentinel value like Nan is not possible, for example in actual Data classes
  def meanLenient(xs: Seq[Double]): Double = xs.sum / xs.length

  // client
  val res = meanLenient(Seq()) // client does not know if this will have a value or not
  if (res != Double.NaN) { // ouch, really?
      // business logic
  }

  // the way to go
  def meanOption(xs: Seq[Double]): Option[Double] =
    if (xs.isEmpty)
      None
    else Some(xs.sum / xs.length)

  // client
  // the possibility of failure is reflected in the data type so the client is forced to handle it in a typesafe way
  val result = meanOption(Seq()) getOrElse 0 // handling of failure

  // lifting, can turn any function that throws an exception to one that returns an Option instead
  // Notice this is a by name parameter (a: => A) so a is evaluated only when TRY is called and not before if we do it like (a: A)
  def Try[A](a: => A): Option[A] =
    try Some(a)
    catch {
      case (e: Exception) => None
    }

  // apply to the original mean
  Console println Try(mean(Seq()))
}
