package cph.meetup.datastruct.edu

// this is a small re-implementation of List to illustrate the slowness of some of its operations
// List in the standard library is a singly Linked List
sealed trait List[+A] {

  def prepend[B >: A](elem: B): List[B] = ::(elem, this)

  // look how slow
  def append[B >: A](other: List[B]): List[B] = this match {
    case Nil => other
    case ::(h, t) => ::(h, t.append(other))
  }

  // look how slow
  def length: Int = this match {
    case Nil => 0
    case ::(h, t) => 1 + t.length
  }
}
case object Nil extends List[Nothing]
case class ::[+A](head: A, tail: List[A]) extends List[A]

object List {

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else ::(as.head, apply(as.tail: _*))
}
