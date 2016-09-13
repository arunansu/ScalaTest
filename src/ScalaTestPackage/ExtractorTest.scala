package ScalaTestPackage

object Twice {
  def apply(x: Int): Int = x * 2
  def unapply(z: Int): Option[Int] = if (z % 2 == 0) Some(z/2) else None 
}

object ExtractorTest {
  def main(args: Array[String]) {
    val x = Twice(20)
    x match { case Twice(n) => println(n) }
  }
}