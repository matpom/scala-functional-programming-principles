object LazyEvaluation{
  def streamRange(lo: Int, hi: Int): Stream[Int] =
    if (lo >= hi) Stream.empty
    else Stream.cons(lo, streamRange(lo + 1, hi))

  val st =  streamRange(5,20)
  st.take(2).toList

  //x :: xs always produces a list, never a stream.
  //x #:: xs == Stream.cons(x, xs)

  val xs = Stream.cons(1, Stream.cons(2, Stream.empty))
  0 #:: xs

  Stream(1,2) == xs

  def from(n: Int): Stream[Int] = n #:: from(n+1)

  val nats = from(0)

  val m4s = nats map (_ * 4)

  (m4s take 100).toList

  //prime numbers The Sieve of Erathostenes

  def sieve(s: Stream[Int]): Stream[Int] =
    s.head #:: sieve(s.tail filter (_ % s.head != 0))

  val primes = sieve(from(2))

  (primes take 100).toList

  //square roots approximation
  def sqrtStream(x: Double): Stream[Double] = {
    def improve(guess: Double) = (guess + x / guess) / 2
    lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
    guesses
  }

  sqrtStream(4).take(10).toList
  sqrtStream(2).take(10).toList

  def isGoodEnough(guess: Double, x: Double) =
    math.abs((guess * guess - x) / x) < 0.0001

  (sqrtStream(2) filter (isGoodEnough(_, 2))).take(1).toList


}