package ScalaTestPackage

object StreamTest {
  def sqrtStream(x: Double): Stream[Double] = {
    def improve(guess: Double): Double = (guess + x / guess) / 2
    lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
    guesses
  }
  def main(args: Array[String]) {
    println(sqrtStream(4).take(10).toList)
  }
}