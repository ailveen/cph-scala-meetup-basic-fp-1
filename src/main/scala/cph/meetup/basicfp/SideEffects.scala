package cph.meetup.basicfp

class Player(val name: String, val score: Int, var winner: Boolean = false)


object SideEffects extends App {

  def findWinner(p1: Player, p2: Player): Player = {
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

  val winner = findWinner(new Player("A", 3, false), new Player("B", 5, false))
  // process winner further (i.e. serialize, etc)

  // refactor to SRP, then FP











  // remove side effects
}
