class BottomNode(override var state: Int) extends Node {
  var right: Node = this

  override val privileges =
    List((() => incremented == right.state,
      () => state = decremented))
}