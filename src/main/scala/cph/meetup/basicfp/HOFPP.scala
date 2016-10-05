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

  // implement with HOF
  // add generics
}

