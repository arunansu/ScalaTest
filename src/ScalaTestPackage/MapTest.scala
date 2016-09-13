package ScalaTestPackage

object MapTest {
  def main(args: Array[String]) {
    val colors1 = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
    val colors2 = Map("blue" -> "#0033FF", "yellow" -> "#FFFF00", "red" -> "#FF0000")
  
    var colors = colors1 ++ colors2
    println(colors) 
    colors.keys.foreach {
      i => print("Key = " + i)
      println(" Value = " + colors(i))
    }
  }
}