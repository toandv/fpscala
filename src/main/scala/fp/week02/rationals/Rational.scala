package fp.week02.rationals

/**
  * Created by toan on 5/21/16.
  */
object Rational extends App {
  println(new Rational(1, 2))

  def addRationals(a: Rational, b: Rational): Rational = {
    new Rational(a.numer * b.denom + a.denom * b.numer, a.denom * b.denom)
  }

  val two = addRationals(new Rational(1, 2), new Rational(5, 10))
  println(two)

  val x = new Rational(1, 2)
  println(new Rational(1, 2).add(new Rational(1, 2000000000)))

  val r1 = new Rational(1, 2) add new Rational(2, 3);
  val r2 = new Rational(1, 2) + new Rational(2, 3);


  print(-r2)
}


class Rational(x: Int, y: Int) {

  require(y != 0, "y must not be zero")

  //require(y != 0,  "y must not be zero")

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a
    else gcd(b, a % b)
  }

  private val g = gcd(x, y)

  val numer = x / g

  // Call only once
  val denom = y / g

  def add(that: Rational) =
    new Rational(numer * that.denom + denom * that.numer, denom * that.denom)

  def +(that: Rational) = add(that)

  def unary_- = new Rational(-numer, denom)

  def sub(that: Rational) =
    add(-that)

  def less(that: Rational) = this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) = if (this.less(that)) that else this

  override def toString: String = {
    if (denom == 1) numer.toString
    else numer + "/" + denom
  }

}


