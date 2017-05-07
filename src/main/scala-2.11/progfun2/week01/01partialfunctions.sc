object partialfunctions {

  val f: String => String =  {case "ping" => "pong"}

  f("ping")
  //f("abc") //scala.MatchError: abc (of class java.lang.String)

  val p: PartialFunction[String, String] = {case "ping" => "pong"}
  p.isDefinedAt("ping")
  p.isDefinedAt("abc")

  //only applies to outermost matching block
  //for nested pattern matching you can still get match error
  val g: PartialFunction[List[Int], String] = {
    case Nil => "one"
    case x :: rest =>
      rest match {
        case Nil => "two"
      }
  }

  g.isDefinedAt(List(1, 2, 3)) //true
  //g(List(1,2,3)) //scala.MatchError

}