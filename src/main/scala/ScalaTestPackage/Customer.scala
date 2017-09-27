package ScalaTestPackage

class Customer(val firstname: String, val middlename: String = "", val lastname: String) {
  val address = ""
  var ssn = ""
  def this(firstname: String, lastname: String) {
    this(firstname, "", lastname)
  }
  private val uid = Customer.nextId
  private var age = 0
  private var _id = ""
  def id = _id
  def id_=(value: String) {
    if(_id.isEmpty()) {
      _id = value
    }
  }
  def name = firstname + " " + middlename + " " + lastname
}

//companion object can access private members of companion class
object Customer {
  private var sequenceId = 0
  private def nextId() {
    sequenceId += 1
    sequenceId
  }
  def main(args: Array[String]) {
    val eric = new Customer("Eric", "Smith")
    eric.id = "001"
    eric.ssn = "123-56-6789"
    println(eric.address + " " + eric.id)
  }
  def apply(firstname: String, middlename: String = "", lastname: String) = new Customer(firstname, middlename, lastname)
}