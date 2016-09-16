package ScalaTestPackage

object Factorial {
  def factorialRec(n: Int): Int = {
    n match {
      case 1 => 1
      case _ => n * factorialRec(n-1)
    }
  }
  def factorialTailRec(n: Int): Int = {
    def factorialInt(n: Int, acc: Int): Int = {
      if(n == 1) acc
      else if(n < 1) 0
      else factorialInt(n - 1, n * acc)
    }
    factorialInt(n, 1)
  }
  def main(args: Array[String]) {
    println(factorialRec(3))
    println(factorialTailRec(3))
  }
}