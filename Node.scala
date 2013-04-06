abstract class Node {
  var state: Int

  //list of all possible privileges and their associated moves
  protected val privileges: List[Pair[() => Boolean, () => Unit]]

  //state + 1 modulo machineSize
  def incremented: Int = { (state + 1) % 3 }
  //state - 1 modulo machineSize
  def decremented: Int = { (state + 2) % 3 }

  //move as accorded by the privilege chosen
  def moves: List[() => Unit] =
    privileges.filter(_._1()).map(_._2)

  override def toString = "["+state+"]"+moves.length
}