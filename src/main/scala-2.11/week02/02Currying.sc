object currying {
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int = {
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    }
    sumF
  }

  def sumCubes = sum(x => x * x * x)

  def cube(x: Int): Int = x * x * x

  //are same
  sumCubes(1, 3)
  sum(cube)(1, 3)

  def sumCurr(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sumCurr(f)(a + 1, b)
  }

  sumCurr(cube)(1, 3)

  //exercise
  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  }

  product(x => x * x)(1, 4)

  def fact(n: Int) = product(x => x)(1, n)

  fact(4)

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }

  def productWithMapReduce(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)

  productWithMapReduce(x => x * x)(1, 4)

}
