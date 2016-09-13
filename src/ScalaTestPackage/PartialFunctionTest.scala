package ScalaTestPackage

object PartialFunctionTest {
  def main(args: Array[String]) {
    val divide = new PartialFunction[Int, Int] {
      def apply(x: Int) = 42 / x
      def isDefinedAt(x: Int) = x != 0 //Partial Function has to have apply and isDefined
    }
    val divide2: PartialFunction[Int,Int] = {
      case d: Int if d != 0 => 42/d //same as before and isDefinedAt implicitly defined
    }
    println(divide.isDefinedAt(0))
    println(divide2.isDefinedAt(1))
    val convert1to5 = new PartialFunction[Int, String]{
      val nums = Array("one", "two", "three", "four", "five")
      def apply(i: Int) = nums(i - 1)
      def isDefinedAt(i: Int) = i > 0 && i < 6
    }
    val convert6to10 = new PartialFunction[Int, String]{
      val nums = Array("six", "seven", "eight", "nine", "ten")
      def apply(i: Int) = nums(i - 6)
      def isDefinedAt(i: Int) = i > 5 && i < 11
    }
    val convert1to10 = convert1to5 orElse convert6to10
    println(convert1to10(3))
    println(convert1to10(8))
    try {
      List(0,1,2) map {divide}
    }
    catch {
      case e: Exception => println(e.getMessage)
    }
    println(List(0,1,2) collect { divide }) //collect uses isDefinedAt to apply function
  }
}