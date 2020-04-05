package middlewares
import types.Middleware
import types.DittoMap

class CamelCaseMiddleware extends Middleware {
  def apply(data: DittoMap): DittoMap = data.mapKeysDeep()(toCamelCase(_))

  def toCamelCase(string: String) = string
}
