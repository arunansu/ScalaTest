package ScalaTestPackage

object Palindrome {
  def checkPalindrome(s: String): Boolean = {
    var retVal: Boolean = true
    val last: Int = s.length - 1
    for(i <- 0 to last if s.charAt(i) != s.charAt(last - i)) retVal = false
    retVal
  }
  def main(args: Array[String]) {
    println(checkPalindrome("ana"))
  }
}