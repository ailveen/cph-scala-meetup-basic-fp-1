package cph.meetup.datastruct.edu

sealed trait List[+A] {

  def prepend[B >: A](elem: B): List[B] = ???

  def append[B >: A](other: List[B]): List[B] = ???

  def length: Int = ???
}
case object Nil extends List[Nothing]
case class ::[+A](head: A, tail: List[A]) extends List[A]

object List {

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else ::(as.head, apply(as.tail: _*))
}
