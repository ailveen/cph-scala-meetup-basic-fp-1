package cph.meetup.functors

object FunctorLaws extends App {

  val l = List(1, 2, 3)

  Console println (l == l.map(x => x))

  val f : Int => String = x => x + 3 + ""

  // reimplement this on the meetup
  Console println l.map(f)

  val g: String => String = s => s"$s appended"

  Console println l.map(f).map(g)

  Console println l.map(x => g(f(x)))
}
