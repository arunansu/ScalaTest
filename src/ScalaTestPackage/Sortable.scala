package ScalaTestPackage
import math.Ordering

trait Sortable[A <: Ordered[A]] extends Iterable[A]{
  def sort: Seq[A] = {
    this.toList.sorted
  }
}

object MergeSortList {
  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match { 
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
            if (ord.lt(x, y)) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
      }
      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }
  def main(args: Array[String]){
    //val nums = List(1, 6, 8, 2, 4, 0, 7, 3, 5)
    val fruits = List("apple", "orange", "banana", "pineapple")
    //val xsSorted = msort(nums)
    val xsSorted = msort(fruits)
    xsSorted.foreach { x => println(x) }
  }
}