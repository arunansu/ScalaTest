package ScalaTestPackage

class Shopper(val name: String, val address: String) extends Ordered[Customer] {
  private final val basket = new ShoppingBasket
  
  def add(item: Item) {
    basket.add(item)
  }
  
  def Total: Double = {
    basket.value
  }
  
  def compare(that: Customer): Int = name.compare(that.name)
  
  override def toString = name + " $ " + Total
}