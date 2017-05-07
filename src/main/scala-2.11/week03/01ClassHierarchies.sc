object intsets {
  val t1 = new NonEmpty(3, new Empty, new Empty)
  val t2 = t1 incl 4
  t1 incl 1 incl 4 incl 7 incl 2

  abstract class IntSet {
    def contains(x: Int): Boolean

    def incl(x: Int): IntSet
  }

  object SingletonEmpty extends IntSet {
    def contains(x: Int): Boolean = false

    def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

    override def toString = "."
  }

  SingletonEmpty

  class Empty extends IntSet {
    def contains(x: Int): Boolean = false

    def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

    override def toString = "."
  }

  class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
    def contains(x: Int): Boolean = {
      if (x > elem) right contains x
      else if (x < elem) left contains x
      else true
    }

    def incl(x: Int): IntSet = {
      if (x > elem) new NonEmpty(elem, left, right incl x)
      else if (x < elem) new NonEmpty(elem, left incl x, right)
      else this
    }

    override def toString = "{" + left + elem + right + "}"
  }
}
object overrides{

  abstract class Base{
    def foo = 1
    def bar: Int
  }

  class Sub extends Base{
    override def foo = 2
    def bar = 3
  }
}


