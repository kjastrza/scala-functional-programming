/**
 *
 * Date: 26.06.2015
 * Time: 22:24
 * User: Krzysztof Jastrzab
 */
class PoligonKJ {
  def main(args: Array[String]) {
    val argsKJ = Array("a", "b", "c")
    val res = for (a <- argsKJ) yield a.toUpperCase
    println("Arguments: " + res.toString)
  }
}
