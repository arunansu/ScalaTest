package ScalaTestPackage

object ListTest {
  def main(args: Array[String]) {
    val xs = List(1,2,3)
    println(xs)
    def squareList(xs: List[Int]): List[Int] = {
      xs match {
        case Nil => Nil
        case x :: ts =>  (x * x) :: squareList(ts)
      }
    }
    def reverseList(xs: List[Int]): List[Int] = {
      xs match {
        case Nil => Nil
        case h :: tail => reverseList(tail) ::: List(h) 
      }
    }
    println(squareList(xs))
    println(reverseList(xs))
    println(xs.foldLeft(List[Int]())((a,b) => b :: a))
    println(xs.foldRight(List[Int]())((a,b) => b ::: List(a)))
    println(xs.map(x => x * x))
    println(xs.foldLeft(1)((a,b) => a * b))
    println(xs.foldRight(1)((a,b) => a * b))
    println(xs.reduce((a,b) => a * b))
  }
}