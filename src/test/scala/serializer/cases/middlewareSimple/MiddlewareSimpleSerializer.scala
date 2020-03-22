package serializer.cases.middlewareSimple

import core.Serializer

class MiddlewareSimpleSerializer extends Serializer {
  middlewares
    .add(new MiddlewareVersion)
}
