package types

case class DittoMap private (data: Map[String, Any] = Map()) {
  def set[T: DittoTypes](key: String, value: T): DittoMap = this.copy(data + (key -> value))
  def get[T: DittoTypes](key: String): Option[T] = data.get(key).asInstanceOf[Option[T]]
  def each()(callback: (String, Any) => Unit): Unit = data.foreach { case (k, v) => callback(k, v) }

  def toPrimitive: DittoMap = {

    val newData = data.map {
      case (key, value) => (key, value)
    }


    this.copy(newData)
  }


}
