import scala.annotation.tailrec

def sum(f: Int => Int)(a: Int, b: Int): Int = {
  @tailrec
  def sumIter(a: Int, acc: Int): Int = {
    if (a > b) acc
    else sumIter(a + 1, acc + f(a))
  }
  sumIter(a, 0)
}

def sum2(f: Int => Int)(a: Int, b: Int): Int =
  mapReduce(f, (x, y) => x + y, 0)(a, b)

sum(x => x)(1, 4)
sum2(x => x)(1, 4)

Array(1, 2, 3, 4).foldLeft(0)(_ + _)
Array(1, 2, 3, 4).foldRight(0)(_ + _)

sum(x => x)(1, 10)
sum2(x => x)(1, 10)


def product(f: Int => Int)(a: Int, b: Int): Int = {
  @tailrec
  def productIter(a: Int, acc: Int): Int = {
    if (a > b) acc
    else productIter(a + 1, acc * f(a))
  }
  productIter(a, 1)
}

def product2(f: Int => Int)(a: Int, b: Int): Int =
  mapReduce(f, (x, y) => x * y, 1)(a, b)

def sub(f: Int => Int)(a: Int, b: Int): Int =
  mapReduce(f, (x, y) => x - y, 0)(a, b)

sub(x => x)(1, 3)



"aaa"
Array(1, 2).foldLeft(0)(_ - _)
Array(1, 2).foldRight(0)(_ - _)

product(x => x)(1, 3)
product2(x => x)(1, 3)

Array(1, 2, 3).foldLeft(1)(_ * _)

product(x => x)(1, 10)
product2(x => x)(1, 10)

def mapReduce(f: Int => Int, combine: ((Int, Int) => Int), zero: Int)(a: Int, b: Int) = {
  @tailrec
  def mapReduceIter(a: Int, acc: Int): Int = {
    if (a > b) acc
    else mapReduceIter(a + 1, combine(acc, f(a)))
  }

  mapReduceIter(a, zero)
}