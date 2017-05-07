object mergesort {
  def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
      val (fst, snd) = xs splitAt n
      merge(msort(fst)(lt), msort(snd)(lt))
    }
  }

  val nums = List(12, 3, -2, 1, 1, 7)
  val fruits = List("apple", "orange", "banana")
  msort(nums)((x: Int, y: Int) => x < y)
  msort(fruits)((x: String, y: String) => x.compareTo(y) < 0)
  msort(fruits)((x, y) => x.compareTo(y) < 0)

  def msort2[T](xs: List[T])(ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x,y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
      val (fst, snd) = xs splitAt n
      merge(msort2(fst)(ord), msort2(snd)(ord))
    }
  }

  val nums2 = List(12, 3, -2, 1, 1, 7)
  val fruits2 = List("apple", "orange", "banana")
  msort2(nums2)(Ordering.Int)
  msort2(fruits2)(Ordering.String)
}
