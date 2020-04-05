package types
import utils.MapKeys

case class DittoMap private (data: Map[String, Any] = Map()) {
  def set[T: DittoTypes](key: String, value: T): DittoMap = copy(data + (key -> value))
  def get[T: DittoTypes](key: String): Option[T] = data.get(key).asInstanceOf[Option[T]]
  def each()(callback: (String, Any) => Unit): Unit = data.foreach { case (k, v) => callback(k, v) }
  def primitive: Map[String, Any] = data
  def primitiveDeep: DittoMap = this.copy(toPrimitive(data))

  def mapKeysDeep()(transform: (String) => String): DittoMap =
    copy(MapKeys.transformDeepKeys(primitiveDeep.primitive)(transform))

  private def toPrimitive(data: Map[String, Any]): Map[String, Any] =
    data.map { case (key, value) => (key, toPrimitiveDeep(value)) }

  private def toPrimitiveDeep(value: Any): Any = value match {
    case list: List[Any] => list.map { row => toPrimitiveDeep(row) }
    case dittoList: DittoList => dittoList.primitive.map { row => toPrimitiveDeep(row) }
    case dittoMap: DittoMap => toPrimitive(dittoMap.primitive)
    case _ => value
  }
}
