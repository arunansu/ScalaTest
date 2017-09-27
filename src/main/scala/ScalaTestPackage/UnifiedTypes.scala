package ScalaTestPackage

object UnifiedTypes {
  val set = new scala.collection.mutable.LinkedHashSet[Any]
  set += "This is a string"
  set += 732
  set += 'c'
  set += true
  val iter: Iterator[Any] = set.iterator
  while (iter.hasNext) {
    println(iter.next.toString())
  }
}