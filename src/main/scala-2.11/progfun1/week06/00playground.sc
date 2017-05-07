object playground{
  val txt :String = "tesTstring"

  txt.groupBy(ch => ch.toLower).mapValues(str => str.length).toList.sorted
}