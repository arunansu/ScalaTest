package ScalaTestPackage

trait Similarity {
  def isSimilar(x: Any): Boolean 
  def isNotSimilar(x: Any): Boolean = !isSimilar(x)
}

class Point(xc: Int, yc: Int) extends Similarity {
  var x: Int = xc
  var y: Int = yc
  
  def isSimilar(obj: Any) = 
    obj.isInstanceOf[Point] && 
    obj.asInstanceOf[Point].x == x 
    
  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
  }
  override def toString(): String = "(" + x + "," + y + ")";
}

object Classes {
  def main(args: Array[String]) {
    val pt = new Point(1,2)
    println(pt)
    pt.move(10, 10)
    println(pt)
    val p1 = new Point(2,3)
    val p2 = new Point(2, 4)
    val p3 = new Point(3, 3)
    println(p1.isNotSimilar(p2))
    println(p1.isNotSimilar(p3))
    println(p1.isNotSimilar(2))
  }
}
