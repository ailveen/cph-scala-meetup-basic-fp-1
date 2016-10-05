package cph.meetup.datastructures

object StreamPlayground extends App {

  def fib(n: Long): Long = {
    @annotation.tailrec
    def loop(n: Long, prev: Long, cur: Long): Long =
      if (n == 0) prev
      else loop(n - 1, cur, prev + cur)
    loop(n, 0, 1)
  }

  // stream of infinite fibonaccis
  def fibStream(n: Long): Stream[Long] = ???
}