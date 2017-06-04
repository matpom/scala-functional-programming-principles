import progfun2.week04.signals.{BankAccount, Signal, Var}

object signals {

  def consolidated(accounts: List[BankAccount]): Signal[Int] =
    Signal(accounts.map(_.balance()).sum)

  val a = new BankAccount
  val b = new BankAccount

  val c = consolidated(List(a,b))
  c()
  a.deposit(20)
  c()
  b.deposit(30)
  c()

  val xchange = Signal(246.00)
  val inDollar = Signal(c() * xchange())
  inDollar()
  b withdraw 10
  inDollar()
}