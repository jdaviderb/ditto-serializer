package serializer.cases.simple
import core.Serializer
import types.{DittoMap, Middleware}

class SimpleMiddleware extends Middleware {
  def apply(data: DittoMap): DittoMap = data
}

class SimpleSerializer extends Serializer {
  middlewares
    .add(new SimpleMiddleware)

  attribute[String]("name") { "Jorge" }
  attribute[String]("last_name") { "Hernandez" }
}
