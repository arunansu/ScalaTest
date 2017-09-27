package ScalaTestPackage

class ThreadTest extends Thread {
  override def run() {
    println("Hello World!")
  }
}

object ThreadTest {
  private var uidCount: Long = 0L
  private val x: AnyRef = new AnyRef {}
  def getUniqueID(): Long = x.synchronized {
    uidCount = uidCount + 1
    uidCount
  }
  def startThread() = {
    val t = new Thread {
      override def run() {
        val uids = for (i <- 0 until 10) yield getUniqueID()
        println(uids)
      }
    }
    t.start()
    t
  }
  def main(args: Array[String]) {
    val t = new ThreadTest
    t.start()
    t.join()
    startThread()
  }
}