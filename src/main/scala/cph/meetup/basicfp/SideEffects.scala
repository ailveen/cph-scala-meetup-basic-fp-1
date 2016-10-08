package cph.meetup.basicfp

class PlayerOld(val name: String, val score: Int, var winner: Boolean = false)

// immutable class (notice we dont need the var)
case class Player(name: String, score: Int)

object SideEffects extends App {

  // Ugly, side effectful program
  def findWinner(p1: PlayerOld, p2: PlayerOld): PlayerOld = {
    if (p1.score > p2.score) {
      p1.winner = true
      Console println s"Player ${p1.name} is the winner"
      p1
    } else if (p2.score > p1.score) {
      p2.winner = true
      Console println s"Player ${p2.name} is the winner"
      p2
    } else {
      throw new Exception("No winner")
    }
  }

  val winner = findWinner(new PlayerOld("A", 3, false), new PlayerOld("B", 5, false))
  // process winner further (i.e. serialize, etc)

  // refactor to single responsibility principle
  def winner(p1: Player, p2: Player): Option[Player] =
    if (p1.score > p2.score)
      Some(p1)
    else if (p2.score > p1.score)
      Some(p2)
    else
      None

  // less idiomatic
  def winnerMessageMeh(winner: Option[Player]): String =
    winner match {
      case Some(p) => s"${p.name} is the winner"
      case None => "No winner"
    }

  // idiomatic
  def winnerMessage(winner: Option[Player]): String =
    winner.map(p => s"${p.name} is the winner") getOrElse "No winner"

  // function composition, note player is a case class
  Console println winnerMessage(winner(Player("Bob", 19), Player("Jim", 34)))

  // much, much later...
  // remove side effects via the IO monad
  import cph.meetup.monads.IO
  import cph.meetup.monads.IO.PrintLine
  val io : IO[Unit] = PrintLine(winnerMessage(winner(Player("Bob", 19), Player("Jim", 34))))
  io.run // prints like println

  // The take-away is, pure FP has the side effects encapsulated as IO, with the core being pure no-side effects
}
