package ScalaTestPackage

object Anagram {
  def checkAnagram(a: String, b: String): Boolean = {
    def charHash(s: String): Map[Char, Int] = {
      s.toLowerCase().groupBy(x => x).mapValues(l => l.length)
    }
    val aHash = charHash(a)
    val bHash = charHash(b)
    var retVal: Boolean = true
    if(aHash.size != bHash.size) return false
    else { 
      for(k <- aHash.keys if retVal == true; if !aHash.get(k).equals(bHash.get(k))) {
        println("k = " + k.toString())
        println("aHash.get(k) = " + aHash.get(k).toString())
        println("bHash.getOrElse(k, 0) = " + bHash.getOrElse(k, 0).toString())  
        retVal = false
      }
    }
    return retVal
  }
  
  def main(args: Array[String]) {
   println(checkAnagram("Ana", "Naa"))
  }
}