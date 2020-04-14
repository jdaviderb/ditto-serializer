package serializer.cases.middlewareSimple

import org.jdaviderb.dittoSerializer.core.Serializer

class MiddlewareSimpleSerializer extends Serializer {
  middlewares
    .add(new MiddlewareVersion)
}
