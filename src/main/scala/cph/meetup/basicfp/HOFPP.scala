package cph.meetup.basicfp

object HOFPP extends App {

  def indexOf(strings: Array[String], stringToFind: String): Int = {
    for (i <- 0 until strings.length) {
      if (stringToFind == strings(i))
        i
    }
    -1
  }

  // another requirement
  def indexOfCertainLength(strings: Array[String], length: Int): Int = {
    for (i <- 0 until strings.length) {
      if (strings(i).length == length) {
        i
      }
    }
    -1
  }

  // implement with HOF
  // add generics
  def findIndex(strings: Array[String], f: String => Boolean): Int = {
    for (i <- 0 until strings.length) {
      if (f(strings(i))) {
        i
      }
    }
    -1
  }

  def findElem[A](elems: Array[A], f: A => Boolean): Int = {
    def loop(i: Int): Int =
      if (i == elems.length) -1
      else if (f(elems(i))) i
      else loop(i + 1)
    loop(0)
  }

}

