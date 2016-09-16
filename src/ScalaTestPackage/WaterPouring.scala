package ScalaTestPackage

class WaterPouring(capacity: Vector[Int]) {
  type State = Vector[Int]
  val initialState = capacity.map(x => 0)
  
  trait Move {
    def change(state: State): State
  }
  case class Empty(glass: Int) extends Move {
    def change(state: State): State = state.updated(glass, 0)
  }
  case class Fill(glass: Int) extends Move {
    def change(state: State): State = state.updated(glass, capacity(glass))
  }
  case class Pour(from: Int, to: Int) extends Move {
    def change(state: State): State = {
      val amount = state(from).min(capacity(to) - state(to))
      state.updated(from, state(from) - amount).updated(state(to), state(to) + amount)
    }
  }
  
  val glasses = 0 until capacity.length
  
  val moves = (for (g <- glasses) yield Empty(g)) ++
              (for (g <- glasses) yield Fill(g)) ++
              (for (from <- glasses; to <- glasses if from != to) yield Pour(from, to))
  
  class Path(history: List[Move]) {
    def endState: State = trackState(history)
    private def trackState(xs: List[Move]): State = xs match {
      case Nil => initialState
      case move :: xs1 => move.change(trackState(xs1))
    }
  }
}



object WaterPouringTest {
  def main(args: Array[String]) {
    val problem = new WaterPouring(Vector(4,7))
  }
}