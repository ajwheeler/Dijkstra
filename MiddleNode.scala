import scala.collection.immutable.List

class MiddleNode(override var state: Int) extends Node {
  //neighbors
  var left: Node = this
  var right: Node = this

  override val privileges = List(
    ((() => incremented == left.state),
      () => state = left.state),
    (() => incremented == right.state,
      () => state = right.state))
}