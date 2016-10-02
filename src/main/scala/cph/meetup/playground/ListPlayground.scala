package cph.meetup.playground

object ListPlayground extends App {

  import cph.meetup.datastructures._

  val p = List(3, 4, 5, 6, 7)
  Console println p.length

  Console println p.prepend(2)
}
