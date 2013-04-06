class TopNode(override var state: Int) extends Node {
  var right: Node = this
  var left: Node = this

  override val privileges = List(
    (() => ((left.state == right.state) && (left.incremented != state)),
      () => state = left.incremented))
}