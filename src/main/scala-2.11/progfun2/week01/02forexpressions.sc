object forexpressions{

  val n = 10

  def isPrime(i: Int): Boolean = {
    if (i <= 1)
      false
    else if (i == 2)
      true
    else
      !(2 until i).exists(x => i % x == 0)
  }

  (1 until n) flatMap (i =>
    (1 until i) filter (j => isPrime(i+j)) map
      (j => (i, j)))

  //same as

  for {
    i <- (1 until n)
    j <- (1 until i)
    if isPrime(i + j)
  } yield (i, j)
}