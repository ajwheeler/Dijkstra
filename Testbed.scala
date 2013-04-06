import scala.util.Random

object Testbed extends App {
  val Steps = 100
  val InitialStates = List(0, 1, 2, 0, 2, 1)
  val INodes = InitialStates.length - 2

  val top = new TopNode(InitialStates.head)
  val bottom = new BottomNode(InitialStates.last)
  val middleNodes = InitialStates.slice(1, INodes + 1).map(new MiddleNode(_))
  val all = bottom :: (middleNodes :+ top)

  top.right = bottom
  top.left = middleNodes(INodes - 1)
  bottom.right = middleNodes(0)
  middleNodes(0).left = bottom
  middleNodes(INodes - 1).right = top
  for (i <- 0 to INodes - 2) {
    middleNodes(i).right = middleNodes(i + 1)
  }
  for (i <- 1 to INodes - 1) {
    middleNodes(i).left = middleNodes(i - 1)
  }

  val rand = new Random();

  for (i <- 0 to Steps - 1) {
    val moves = all.map(_.moves).reduceLeft(_ ++ _)

    println("step "+i)
    println("privileges present:"+moves.length)
    println(all.map(_.toString))
    println()

    moves(rand.nextInt(moves.length))()
  }
}