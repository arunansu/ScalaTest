package ScalaTestPackage

import scala.collection.mutable._

abstract class BinaryTree 

case class Node(value: Int, left: BinaryTree, right: BinaryTree) extends BinaryTree

case class Leaf(value: Int) extends BinaryTree

object InOrder {
  def inorderRecursive(t: BinaryTree) {
  t match {
    case Node(v, left, right) => 
      inorderRecursive(left)
      print("%d ".format(v))
      inorderRecursive(right)
    case Leaf(v) => 
      print("%d ".format(v))
    }
  }
  def inorderIterative(t: BinaryTree) {
    val st = Stack[BinaryTree]()
    st.push(t)
    while(!st.isEmpty) {
      st.pop() match {
        case Node(v, left, right) =>
          st.push(right)
          st.push(Leaf(v))
          st.push(left)
        case Leaf(v) =>
          print("%d ".format(v))
      }
    }
  }
  def main(args: Array[String]) {
    val t = Node(4, Node(2,Leaf(1),Leaf(3)), Node(6,Leaf(5),Leaf(7)));

    println("inorderRecursive:")
    inorderRecursive(t)
    println("\ninorderIterative:")
    inorderIterative(t)
  }
}
