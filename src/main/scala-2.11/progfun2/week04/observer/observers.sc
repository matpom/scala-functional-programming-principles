import progfun2.week04.observer.{BankAccount, Consolidator}

object observers{
  val a = new BankAccount
  val b = new BankAccount

  val consolidator = new Consolidator(List(a,b))

  consolidator.totalBalance

  a.deposit(10)

  consolidator.totalBalance
}