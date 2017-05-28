import progfun2.week03.circuits.{Circuits, Parameters}

object DiscreteEventSimulation {

  //performs actions, specified by the user at given moment
  //action is a function that doesn't take any parameters
  // and returns Unit

  object sim extends Circuits with Parameters

  import sim._

  val in1, in2, sum, carry = new Wire

  halfAdder(in1, in2, sum, carry)
  probe("sum", sum)
  probe("carry", carry)

  in1 setSignal true
  run()

  in2 setSignal true
  run()

  in1 setSignal false
  run()

}