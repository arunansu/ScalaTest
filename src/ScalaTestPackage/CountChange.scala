package ScalaTestPackage

object CountChange {

  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 
      1
    else if (money > 0 && !coins.isEmpty) {
      println("countChange(", money - coins.head, coins, ") + countChange(", money, coins.tail, ")")
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
    else 
      0
  }
  
  def main(args: Array[String]) {
    val coins = List(1, 5, 10, 25)
    println(countChange(5, coins))
  }
}