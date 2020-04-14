package org.jdaviderb.dittoSerializer.middlewares
import org.jdaviderb.dittoSerializer.types.Middleware
import org.jdaviderb.dittoSerializer.types.DittoMap

class CamelCaseMiddleware extends Middleware {
  def apply(data: DittoMap): DittoMap = data.mapKeysDeep(toCamelCase(_))
  def toCamelCase(string: String) = string
}
