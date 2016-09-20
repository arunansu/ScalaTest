//package ScalaTestPackage
//
//import scala.util.DynamicVariable
//
//class Signal[T](expr: => T) {
//  import Signal._
//  private var myExpr: () => T = _
//  private var myValue: T = _
//  private var observers: Set[Signal[_]] = Set()
//  private var observed: List[Signal[_]] = Nil
//  update(expr)
//
//  protected def computeValue(): Unit = {
//    for (sig <- observed)
//      sig.observers -= this
//    observed = Nil
//    val newValue = caller.withValue(this)(myExpr())
//    /* Disable the following "optimization" for the assignment, because we
//     * want to be able to track the actual dependency graph in the tests.
//     */
//    //if (myValue != newValue) {
//      myValue = newValue
//      val obs = observers
//      observers = Set()
//      obs.foreach(_.computeValue())
//    //}
//  }
//
//  protected def update(expr: => T): Unit = {
//    myExpr = () => expr
//    computeValue()
//  }
//
//  def apply() = {
//    observers += caller.value
//    assert(!caller.value.observers.contains(this), "cyclic signal definition")
//    caller.value.observed ::= this
//    myValue
//  }
//}
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