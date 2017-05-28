object loops {
  // for loop execution with a range
  for (a <- 1 to 3; b <- 1 to 3) {
    println("a: " + a)
    println("b: " + b)
  }

  for (i <- 1 until 3; j <- "abc") println(i+ " " + j)
  //same as
  (1 until 3) foreach (i => "abc" foreach (j => println(i + " " + j)))

  var b = 10

  // while loop execution
  while( b < 20 ){
    println( "b: " + b )
    b = b + 1
  }

  var a = 10

  // do loop execution
  do {
    println( "a: " + a )
    a = a + 1
  }
  while( a < 20 )
}