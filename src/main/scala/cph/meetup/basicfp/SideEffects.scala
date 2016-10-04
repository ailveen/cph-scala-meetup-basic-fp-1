package cph.meetup.basicfp

class Playerold(val name: String, val score: Int, var winner: Boolean = false)

case class Player(name: String, score: Int)

case class Contestant(name: String, score: Int)

object SideEffects extends App {

  def findWinner(p1: Player, p2: Player): Player = {
    if (p1.score > p2.score) {
//      p1.winner = true
      Console println s"Player ${p1.name} is the winner"
      p1
    } else if (p2.score > p1.score) {
//      p2.winner = true
      Console println s"Player ${p2.name} is the winner"
      p2
    } else {
      throw new Exception("No winner")
    }
  }

//  val winner = findWinner(new Player("A", 3, false), new Player("B", 5, false))
  // process winner further (i.e. serialize, etc)

  // refactor to SRP, then FP
  def winner(p1: Player, p2: Player): Option[Player] =
    if (p1.score > p2.score) Some(p1)
    else if (p2.score > p1.score) Some(p2)
    else None

  def winnerMessage(winner: Option[Player]): String =
    winner.map(p => s"Player ${p.name} is the winner").getOrElse("No Winner")

//  Console println winnerMessage(winner(Player("A", 3), Player("B", 5)))

  import cph.meetup.monads.IO._

  val printIo = PrintLine(winnerMessage(winner(Player("A", 3), Player("B", 5))))
  //printIo.run

  def echo = for {
    _ <- PrintLine(s"Enter your name: ")
    s <- ReadLine
    _ <- PrintLine(s"Your name is: $s")
  } yield s

  echo.run
}
