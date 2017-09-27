//package ScalaTestPackage
//
//import scala.concurrent._
//
//object ParallelTest {
//  val threshold: Int = 10
//  
//  def parallel[A,B](taskA: => A, taskB: => B): (A,B) = {
//    val tB: Task[B] = Task { taskB }
//    val tA: A = taskA
//    (tA, tB.join())
//  }
//  
//  def power(x: Int, p: Double): Int = Math.exp(p * Math.log(Math.abs(x))).toInt
//  def sumSegment(a: Array[Int], p: Double, s: Int, t: Int) = {
//    var i = s; var sum: Int = 0;
//    while (i < t) {
//      sum = sum + power(a(i), p)
//      i = i + 1
//    }
//    sum
//  }
//  def segmentRec(a: Array[Int], p: Double, s: Int, t: Int): Int = {
//    if ((t - s) < threshold) sumSegment(a, p, s, t)
//    else {
//      val m = s + (t - s) / 2
//      val (sum1, sum2) = parallel(segmentRec(a, p, s, m), segmentRec(a, p, m, t))
//    }
//    sum1 + sum2
//  }
//  
//  def pNormRec(a: Array[Int], p: Double): Int = power(segmentRec(a, p, 0, a.length), 1/p))
//  def main(args: Array[String]) {
//   val t1 = Task {}
//   val t2 = Task {}
//   t1.join()
//   t2.join()
//  }
//}