package ScalaTestPackage

import scala.concurrent.Promise
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}
import java.util.concurrent.Executors
import scala.concurrent.ExecutionContext

case class TaxCut(reduction: Int)
case class LameExcuse(excuse: String)  extends Exception

object PromiseTest {
  val taxcut = Promise[TaxCut]()
  val taxcut2: Promise[TaxCut] = Promise() //another way to declare
  val taxcutF: Future[TaxCut] = taxcut.future
  taxcut.success(TaxCut(20)) //calls Future onSuccess method
  val executorService = Executors.newFixedThreadPool(4)
  val executionContext = ExecutionContext.fromExecutorService(executorService)
  
  def redeemCampaignPledge(): Future[TaxCut] = {
    val p = Promise[TaxCut]()
    Future {
      println("Starting new leglislative period.")
      Thread.sleep(2000)
      //p.success(TaxCut(20))
      //println("We reduced taxes")
      p.failure(LameExcuse("economy crisis"))
      println("We didn't fulfill the promise") 
    }
    p.future
  }
  def main(args: Array[String]) {
    val taxcutF: Future[TaxCut] = redeemCampaignPledge()
    println("Now that they are elected lets see if they keep their promise")
    taxcutF.onComplete { 
      case Success(TaxCut(reduction)) => println(s"They cut our taxes by $reduction points")
      case Failure(ex) => println(s"The broke promises because ${ex.getMessage}")
    }
  }
}