package core

import types.{DittoList, DittoMap, DittoSerializer, DittoTypes}

abstract class Serializer extends DittoSerializer {
  var data: DittoMap = DittoMap()
  val middlewares = new MiddlewareManager

  def attribute[T: DittoTypes](key: String)(result: => T): T = {
    data = data.set[T](key, result)
    result
  }

  def map: DittoMap = DittoMap()
  def list: DittoList = new DittoList
  def serialize: DittoMap = middlewares.apply(data)
}
