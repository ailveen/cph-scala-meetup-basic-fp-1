package cph.meetup.monads

case class Person(name: String, telephone: Option[Int])

object ForComprehension extends App {

  val personMap = (
    List(Person("Abby", Some(11111111)),
      Person("James", None), Person("Rick", Some(33333))) foldLeft Map.empty[String, Person]) {
    (m, p) => m + (p.name -> p)
  }

  def findPerson(name: String): Option[Person] =
    personMap.get(name)

  val maybeInt = for {
    p <- findPerson("Abby")
    tel <- p.telephone
  } yield tel
  Console println maybeInt
}
