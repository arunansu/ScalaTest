package ScalaTestPackage

import scala.util.{Success, Failure}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FutureTest {
  def main(args: Array[String]) {
    val f = Future {
     Thread.sleep(500)
     42
    }
    f onComplete {
      case Success(i) => println(i)
      case Failure(t) => println("Error: " + t.getMessage)
    }
    val g = Future {
      Thread.sleep(400)
      "Hello"
    }
    g onSuccess {
      case s => println(s)
    }
    g onFailure {
      case e => println("Error: " + e.getMessage)
    }
  }
}