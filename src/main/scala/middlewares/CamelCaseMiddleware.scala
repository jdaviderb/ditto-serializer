package middlewares
import types.Middleware
import types.DittoMap

class CamelCaseMiddleware extends Middleware {
  def apply(data: DittoMap): DittoMap = data
}
