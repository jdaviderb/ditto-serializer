package core

import types.{DittoList, DittoMap, DittoSerializer, DittoTypes}

abstract class Serializer extends DittoSerializer {
  var data: DittoMap = new DittoMap
  val middlewares = new MiddlewareManager

  def attribute[T: DittoTypes](key: String)(result: => T): T = {
    result match {
      case dittoMap: DittoMap => data.set[DittoMap](key, dittoMap)
      case dittoList: DittoList => data.set[DittoList](key, dittoList)
      case dittoSerializer: Serializer => data.set[DittoSerializer](key, dittoSerializer)
      case _ => data.set[T](key, result)
    }

    result
  }

  def map: DittoMap = new DittoMap
  def list: DittoList = new DittoList
  def serialize: DittoMap = middlewares.apply(data)
}
