package types

import utils.MapKeys

class DittoMap {
  private var mapProxy: Map[String, Any] = Map()
  private var mapPrimitive: Map[String, Any] = Map()

  def set[T: DittoTypes](key: String, value: T): DittoMap = {
    setMap[T](key, value)
    this
  }

  def mapKeys()(map: (String) => String): Unit = {
    MapKeys.transformDeepKeys(mapPrimitive)(map)
  }

  def get[T: DittoTypes](key: String): Option[T] = mapProxy.get(key).asInstanceOf[Option[T]]
  def isPresent(key: String): Boolean = mapProxy.get(key) != None
  def primitive: Map[String, Any] = mapPrimitive

  private def setMap[T: DittoTypes](key: String, value: T): Unit = value match {
    case dittoMap: DittoMap =>
      mapProxy = mapProxy + (key -> dittoMap)
      mapPrimitive = mapPrimitive + (key -> dittoMap.primitive)
    case dittoList: DittoList =>
      mapProxy = mapProxy + (key -> dittoList)
      mapPrimitive = mapPrimitive + (key -> dittoList.primitive)
    case dittoSerializer: DittoSerializer =>
      mapProxy = mapProxy + (key -> dittoSerializer)
      mapPrimitive = mapPrimitive + (key -> dittoSerializer.serialize.primitive)
    case _ =>
      mapProxy = mapProxy + (key -> value)
      mapPrimitive = mapPrimitive + (key -> value)
  }
}
