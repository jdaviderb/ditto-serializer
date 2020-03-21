package types

//object DittoMap2 {
//  val data: Map[String, Any] = Map()
//
//  def apply: DittoMap2 = new DittoMap2(data)
//}

case class DittoMap2 private (data: Map[String, Any] = Map()) {
  def set[T: DittoTypes](key: String, value: T): DittoMap2 = {
    this.copy(data + (key -> value))
  }

  def get[T: DittoTypes](key: String): Option[T] = data.get(key).asInstanceOf[Option[T]]

  def xdxd[T: DittoTypes]: (String, T) = {
    ("ok", (1).asInstanceOf[T])
  }

  def map[T: DittoTypes]()(transform: (String, Any) => (String, Any)): DittoMap2 = {
    val ok = data.map {  case (key, value) => transform(key, value) }
    this.copy(ok)
  }
}

object Shit {
  def main(args: Array[String]): Unit = {
    println("mela")

    val data = DittoMap2()
      .set("jorge", "hernandez")
      .set("andrea", "zambrano")//.map { case (key, value) =>  (key, value) }
//        .map() { _ =>
//
//          ("", "ass")
//        }

    println(data.get[String]("jorge"))
    println(data.get[String]("hernandez"))
    println(data.xdxd[String])
  }
}
