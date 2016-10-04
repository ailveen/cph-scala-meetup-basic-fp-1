package cph.meetup.monads

object MonadLaws extends App {

  // left identity
  val f = (i: Int) => List(i * 8)
  Console println List(2).flatMap(f)
  Console println f(2)

  // right identity
  Console println List(2).flatMap(i => List(i))

  // associativity
  val double = (x: Int) => List(x * x)
  val duplicate = (x: Int) => List(x, x)
  Console println List(1, 2, 3).flatMap(double).flatMap(duplicate)
  Console println List(1, 2, 3).flatMap(x => double(x).flatMap(duplicate))

}
