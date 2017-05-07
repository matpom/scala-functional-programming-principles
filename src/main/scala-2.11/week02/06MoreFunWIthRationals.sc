object rationals {
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)
  x.sub(y).sub(z)
  y.add(y)
  x.max(y)
//  val strange = new Rational(1,0)
//  strange.add(strange)

  class Rational(x: Int, y: Int) {
    //predefined function
    require(y != 0, "denominator must be nonzero")

    //different constructor
    def this(x: Int) = this(x, 1)

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    //normalization is better here (to avoid exceeding int range)
    def numer = x
    def denom = y

    def less(that: Rational) = this.numer * that.denom < that.numer * this.denom

    def max(that: Rational) = if (this.less(that)) that else this
    def add(that: Rational) =
      new Rational(numer * that.denom + denom * that.numer,
        denom * that.denom)

    def neg: Rational = new Rational(-numer, denom)

    def sub(that: Rational) = add(that.neg)

    override def toString = {
      val g = gcd(numer, denom)
      numer/g + "/" + denom/g
    }

  }

}


