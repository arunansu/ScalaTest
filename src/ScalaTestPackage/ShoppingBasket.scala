package ScalaTestPackage

class ShoppingBasket {
  var value = 0.0;
  
  def add(item: Item) {
    value += item.price 
  }
}