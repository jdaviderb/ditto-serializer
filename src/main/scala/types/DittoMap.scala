package types

case class DittoMap private (data: Map[String, Any] = Map()) {
  def set[T: DittoTypes](key: String, value: T): DittoMap = copy(data + (key -> value))
  def get[T: DittoTypes](key: String): Option[T] = data.get(key).asInstanceOf[Option[T]]
  def each()(callback: (String, Any) => Unit): Unit = data.foreach { case (k, v) => callback(k, v) }
  def primitive: Map[String, Any] = data
  def primitiveDeep: DittoMap = this.copy(toPrimitive(data))

  private def toPrimitive(data: Map[String, Any]): Map[String, Any] = data.map { case (k, v) => (k, deepPrimitiv(v)) }
  private def deepPrimitiv(value: Any): Any = value match {
    case list: List[Any] => list.map { row => deepPrimitiv(row) }
    case dittoList: DittoList => dittoList.primitive.map { row => deepPrimitiv(row) }
    case dittoMap: DittoMap => toPrimitive(dittoMap.primitive)
    case _ => value
  }
}
