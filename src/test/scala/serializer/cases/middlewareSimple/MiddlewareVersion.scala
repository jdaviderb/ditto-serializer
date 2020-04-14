package serializer.cases.middlewareSimple

import org.jdaviderb.dittoSerializer.types.{DittoMap, Middleware}

class MiddlewareVersion extends Middleware {
  def apply(data: DittoMap): DittoMap = data.set("environment", "production")
}