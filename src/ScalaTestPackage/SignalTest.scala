//package ScalaTestPackage
//
//class BankAccount {
//  val balance = Var(0)
//  def deposit(amount: Int): Unit = {
//    if (amount > 0) {
//      balance() = balance() + amount
//    }
//  }
//  def withdraw(amount: Int): Unit = {
//    if (0 < amount && amount <= balance()) {
//      balance() = balance() - amount
//    }
//    else {
//      throw new Error("Insufficient Funds")
//    }
//  }
//}
//
//object Accounts {
//  def consolidated(accts: List[BankAccount]): Signal[Int] = Signal(accts.map(_.balance()).sum)
//  def main(args: Array[String]) {
//    val a = new BankAccount()
//    val b = new BankAccount()
//    val c = consolidated(List(a,b))
//    c()
//    a deposit 20
//    c()
//  }
//}