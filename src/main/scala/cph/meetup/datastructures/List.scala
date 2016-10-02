package cph.meetup.datastructures

sealed trait List[+A] {
  def prepend[B >: A](elem: B): List[B] = ::(elem, this)

  def append[B >: A](other: List[B]): List[B] =
    this match {
      case Nil => other
      case ::(h, t) => ::(h, t.append(other))
    }

  def length: Int = ???
}
case object Nil extends List[Nothing]
case class ::[+A](head: A, tail: List[A]) extends List[A]

object List {
  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else ::(as.head, apply(as.tail: _*))
}
