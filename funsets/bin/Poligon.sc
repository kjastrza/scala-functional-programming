/**
 *
 * Date: 29.12.2013
 * Time: 23:37
 * User: Krzysztof Jastrzab
 */
class Rational(x: Int, y: Int) {
  require(y != 0, "Denomination must be positive")

  def this(x : Int) = this(x,1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  private val g = gcd(x,y)

  def numer = x / g

  def denom = y / g

  def add(that: Rational) =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def neg: Rational = new Rational(-numer, denom)

  def sub(that: Rational) = add(that.neg)

  def less(that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this.less(that)) that else this

  override def toString() = numer + "/" + denom
}

val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)

x.sub(y).sub(z)

y.add(y)










