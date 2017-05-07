object polynomials{

  class Poly(val terms: Map[Int,Double]){
    def this(bindings: (Int,Double)*) = this(bindings.toMap)
    def + (other: Poly) = new Poly(terms ++ other.terms map adjust)

    def adjust(term: (Int, Double)): (Int,Double) = {
      val (exp,coeff) = term;
      terms get exp match {
        case None => (exp, coeff)
        case Some(coeff1) => exp -> (coeff + coeff1)
      }
    }
    override def toString: String = {
     // terms map { case (coefficient,exponent) => coefficient+"x^"+exponent }  mkString " + "
      (for((exp,coeff) <- terms.toList.sorted.reverse) yield coeff + "x^"+exp) mkString(" + ")
    }
  }

  val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.0))
  val p2 = new Poly(0 -> 3.0, 3 -> 7.0)
  p1 + p2
}

