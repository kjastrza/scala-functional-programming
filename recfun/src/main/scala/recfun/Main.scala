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
  def pascal(c: Int, r: Int): Int = if (c < 1 || r < 2 || c == r) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def iter(chars: List[Char], num: Int): Boolean = {
      if (chars.isEmpty && num == 0) true
      else if (num < 0) false
      else {
        chars.head match {
          case '(' => iter(chars.tail, num + 1)
          case ')' => iter(chars.tail, num - 1)
          case _ => iter(chars.tail, num)
        }
      }
    }

    iter(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def count(capacity: Int, remainingCoins: List[Int]): Int = {
      if (capacity == 0) 1
      else if (remainingCoins.isEmpty && capacity > 0 || capacity < 0) 0
      else {
        count(capacity, remainingCoins.tail) + count(capacity - remainingCoins.head, remainingCoins)
      }
    }

    if (money == 0 || coins.isEmpty) 0 else count(money, coins.sortWith(_ < _))
  }
}
