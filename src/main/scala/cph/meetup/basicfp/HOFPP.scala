package cph.meetup.basicfp

object HOFPP extends App {

  def indexOf(strings: Array[String], stringToFind: String): Int = {
    def loop(n: Int): Int =
      if (n == strings.length) -1
      else if (strings(n) == stringToFind) n
      else loop(n + 1)
    loop(0)
  }

  // another requirement, index of certain length
  def indexOf(strings: Array[String], lengthToFind: Int): Int = {
    def loop(n: Int): Int =
      if (n == strings.length) -1
      else if (strings(n).length == lengthToFind) n
      else loop(n + 1)
    loop(0)
  }

  // implement with Higher order function
  def indexOf(strings: Array[String], comparison: String => Boolean): Int = {
    def loop(n: Int): Int =
      if (n == strings.length) -1
      else if (comparison(strings(n))) n
      else loop(n + 1)
    loop(0)
  }

  // add generics, notice the currying
  // we need to curry (separate arguments via parenthesis) the function so Scala can infer the type of the collection properly
  def indexOf[A](elems: Array[A])(comparison: A => Boolean): Int = {
    def loop(n: Int): Int =
      if (n == elems.length) -1
      else if (comparison(elems(n))) n
      else loop(n + 1)
    loop(0)
  }

  // now the client code looks nicer
  indexOf(Array("foo", "bar"))(s => s == "bar") // checks for equality
  indexOf(Array("foo", "foobar"))(s => s.length == 6) // checks for element of a certain length
}

