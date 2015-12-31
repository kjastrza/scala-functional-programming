package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || r == 0 || c == r) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def loop(balancer: Int, chars: List[Char]): Boolean = {
      if (balancer < 0) return false
      if (chars.isEmpty) return balancer == 0

      if (chars.head == '(') loop(balancer + 1, chars.tail)
      else if (chars.head == ')') loop(balancer - 1, chars.tail)
      else loop(balancer, chars.tail)
    }

    loop(0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    1
  }
}