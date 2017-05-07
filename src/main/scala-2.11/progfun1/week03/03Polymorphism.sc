import progfun1.week03.Nil
import progfun1.week03.Const

object polymorphism {

  def singleton[T](element: T) = new Const[T](element,new Nil[T])

  singleton[Int](1)

  val list = new Const(1, new Const(2, new Const(3,new Nil)))

  def nth[T](n: Int, list: List[T]): T = {
    if(list.isEmpty) throw new ArrayIndexOutOfBoundsException()
    else if(n==0) list.head
    else nth(n - 1, list.tail)
  }

  nth(2,list)
  nth(3,list)

}