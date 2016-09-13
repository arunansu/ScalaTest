package ScalaTestPackage

trait Similar {
  def isSimilar(x: Any): Boolean
}

case class MyInt(x: Int) extends Similar {
  def isSimilar(m: Any): Boolean = m.isInstanceOf[MyInt] && m.asInstanceOf
}

class Stack[+A] { //+ => covariant if B is subtype of A Stack[B] is subtype of Stack[A]
  def push[B >: A](elem: B): Stack[B] = new Stack[B] { //push a supertype
    override def top: B = elem
    override def pop: Stack[B] = Stack.this
    override def toString() = elem.toString() + " " + Stack.this.toString()
  }
  def top: A = sys.error("no element on stack")
  def pop: Stack[A] = sys.error("no element on stack")
  override def toString() = ""
}

object VarianceTest {
  def main(args: Array[String]) {
    def findSimilar[T <: Similar](e: T, xs: List[T]): Boolean = 
      if (xs.isEmpty) false
      else if (e.isSimilar(xs.head)) true
      else findSimilar[T](e, xs.tail)
    var s: Stack[Any] = new Stack().push("hello")
    s = s.push(new Object())
    s = s.push(7)
    println(s)
  }
}