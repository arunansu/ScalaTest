package ScalaTestPackage

class DiscountedShopper(name: String, address: String) extends Shopper(name, address) {
  override def Total: Double = {
    super.Total * 0.9
  }
}

object DiscountedCustomer {
  def main(args: Array[String]){
    val joe = new DiscountedShopper("Joe", "123 Main St")
    joe.add(new Item {
      price = 2.5
    })
    joe.add(new Item {
      price = 5.5
    })
  }
}
